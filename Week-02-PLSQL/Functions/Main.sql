CREATE OR REPLACE FUNCTION CalculateAge(
    p_DOB IN DATE
) RETURN NUMBER IS
BEGIN
    RETURN FLOOR(MONTHS_BETWEEN(CURRENT_DATE, p_DOB) / 12);
END CalculateAge;
/

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_LoanAmount    IN NUMBER,
    p_InterestRate  IN NUMBER,
    p_DurationYears IN NUMBER
) RETURN NUMBER IS
    v_MonthlyRate NUMBER;
    v_TotalMonths NUMBER;
    v_EMI         NUMBER;
BEGIN
    v_MonthlyRate := p_InterestRate / 12 / 100;
    v_TotalMonths := p_DurationYears * 12;
    
    IF v_MonthlyRate = 0 THEN
        v_EMI := p_LoanAmount / v_TotalMonths;
    ELSE
        v_EMI := (p_LoanAmount * v_MonthlyRate * POWER(1 + v_MonthlyRate, v_TotalMonths)) / 
                 (POWER(1 + v_MonthlyRate, v_TotalMonths) - 1);
    END IF;
    
    RETURN v_EMI;
END CalculateMonthlyInstallment;
/

CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_AccountID IN NUMBER,
    p_Amount    IN NUMBER
) RETURN BOOLEAN IS
    v_Balance NUMBER;
BEGIN
    SELECT Balance INTO v_Balance FROM Accounts WHERE AccountID = p_AccountID;
    IF v_Balance >= p_Amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END HasSufficientBalance;
/
