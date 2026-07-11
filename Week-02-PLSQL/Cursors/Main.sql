DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT c.CustomerID, c.Name, a.AccountID, t.TransactionID, t.TransactionDate, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM CURRENT_DATE)
          AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM CURRENT_DATE)
        ORDER BY c.CustomerID, t.TransactionDate;
    v_CurrentCustomer NUMBER := -1;
BEGIN
    FOR r_trans IN GenerateMonthlyStatements LOOP
        IF v_CurrentCustomer <> r_trans.CustomerID THEN
            v_CurrentCustomer := r_trans.CustomerID;
            DBMS_OUTPUT.PUT_LINE('Statement for Customer: ' || r_trans.Name || ' (ID: ' || r_trans.CustomerID || ')');
        END IF;
        DBMS_OUTPUT.PUT_LINE('  Account ID: ' || r_trans.AccountID || ' | Trans ID: ' || r_trans.TransactionID || ' | Date: ' || TO_CHAR(r_trans.TransactionDate, 'YYYY-MM-DD') || ' | Type: ' || r_trans.TransactionType || ' | Amount: ' || r_trans.Amount);
    END LOOP;
END;
/

DECLARE
    CURSOR ApplyAnnualFee IS
        SELECT AccountID, Balance, AccountType
        FROM Accounts;
    v_Fee NUMBER;
BEGIN
    FOR r_acc IN ApplyAnnualFee LOOP
        IF r_acc.AccountType = 'Savings' THEN
            v_Fee := 20;
        ELSE
            v_Fee := 50;
        END IF;
        UPDATE Accounts
        SET Balance = Balance - v_Fee,
            LastModified = CURRENT_DATE
        WHERE AccountID = r_acc.AccountID;
    END LOOP;
    COMMIT;
END;
/

DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID, LoanAmount, InterestRate
        FROM Loans;
    v_NewRate NUMBER;
BEGIN
    FOR r_loan IN UpdateLoanInterestRates LOOP
        IF r_loan.LoanAmount > 10000 THEN
            v_NewRate := r_loan.InterestRate - 0.5;
        ELSE
            v_NewRate := r_loan.InterestRate - 0.25;
        END IF;
        UPDATE Loans
        SET InterestRate = v_NewRate
        WHERE LoanID = r_loan.LoanID;
    END LOOP;
    COMMIT;
END;
/
