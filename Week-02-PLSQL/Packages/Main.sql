CREATE OR REPLACE PACKAGE CustomerManagement IS
    PROCEDURE AddNewCustomer(
        p_CustomerID IN NUMBER,
        p_Name        IN VARCHAR2,
        p_DOB         IN DATE,
        p_Balance     IN NUMBER
    );
    PROCEDURE UpdateCustomerDetails(
        p_CustomerID IN NUMBER,
        p_Name        IN VARCHAR2,
        p_Balance     IN NUMBER
    );
    FUNCTION GetCustomerBalance(
        p_CustomerID IN NUMBER
    ) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement IS
    PROCEDURE AddNewCustomer(
        p_CustomerID IN NUMBER,
        p_Name        IN VARCHAR2,
        p_DOB         IN DATE,
        p_Balance     IN NUMBER
    ) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, IsVIP, LastModified)
        VALUES (p_CustomerID, p_Name, p_DOB, p_Balance, 'FALSE', CURRENT_DATE);
        COMMIT;
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            RAISE_APPLICATION_ERROR(-20001, 'Customer already exists.');
    END AddNewCustomer;

    PROCEDURE UpdateCustomerDetails(
        p_CustomerID IN NUMBER,
        p_Name        IN VARCHAR2,
        p_Balance     IN NUMBER
    ) IS
    BEGIN
        UPDATE Customers
        SET Name = p_Name,
            Balance = p_Balance,
            LastModified = CURRENT_DATE
        WHERE CustomerID = p_CustomerID;
        IF SQL%NOTFOUND THEN
            RAISE_APPLICATION_ERROR(-20002, 'Customer not found.');
        END IF;
        COMMIT;
    END UpdateCustomerDetails;

    FUNCTION GetCustomerBalance(
        p_CustomerID IN NUMBER
    ) RETURN NUMBER IS
        v_Balance NUMBER;
    BEGIN
        SELECT Balance INTO v_Balance
        FROM Customers
        WHERE CustomerID = p_CustomerID;
        RETURN v_Balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RAISE_APPLICATION_ERROR(-20003, 'Customer not found.');
    END GetCustomerBalance;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE EmployeeManagement IS
    PROCEDURE HireNewEmployee(
        p_EmployeeID IN NUMBER,
        p_Name        IN VARCHAR2,
        p_Position    IN VARCHAR2,
        p_Salary      IN NUMBER,
        p_Department  IN VARCHAR2,
        p_HireDate    IN DATE
    );
    PROCEDURE UpdateEmployeeDetails(
        p_EmployeeID IN NUMBER,
        p_Name        IN VARCHAR2,
        p_Position    IN VARCHAR2,
        p_Salary      IN NUMBER,
        p_Department  IN VARCHAR2
    );
    FUNCTION CalculateAnnualSalary(
        p_EmployeeID IN NUMBER
    ) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement IS
    PROCEDURE HireNewEmployee(
        p_EmployeeID IN NUMBER,
        p_Name        IN VARCHAR2,
        p_Position    IN VARCHAR2,
        p_Salary      IN NUMBER,
        p_Department  IN VARCHAR2,
        p_HireDate    IN DATE
    ) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_EmployeeID, p_Name, p_Position, p_Salary, p_Department, p_HireDate);
        COMMIT;
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            RAISE_APPLICATION_ERROR(-20004, 'Employee already exists.');
    END HireNewEmployee;

    PROCEDURE UpdateEmployeeDetails(
        p_EmployeeID IN NUMBER,
        p_Name        IN VARCHAR2,
        p_Position    IN VARCHAR2,
        p_Salary      IN NUMBER,
        p_Department  IN VARCHAR2
    ) IS
    BEGIN
        UPDATE Employees
        SET Name = p_Name,
            Position = p_Position,
            Salary = p_Salary,
            Department = p_Department
        WHERE EmployeeID = p_EmployeeID;
        IF SQL%NOTFOUND THEN
            RAISE_APPLICATION_ERROR(-20005, 'Employee not found.');
        END IF;
        COMMIT;
    END UpdateEmployeeDetails;

    FUNCTION CalculateAnnualSalary(
        p_EmployeeID IN NUMBER
    ) RETURN NUMBER IS
        v_Salary NUMBER;
    BEGIN
        SELECT Salary INTO v_Salary
        FROM Employees
        WHERE EmployeeID = p_EmployeeID;
        RETURN v_Salary * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RAISE_APPLICATION_ERROR(-20006, 'Employee not found.');
    END CalculateAnnualSalary;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE AccountOperations IS
    PROCEDURE OpenAccount(
        p_AccountID   IN NUMBER,
        p_CustomerID  IN NUMBER,
        p_AccountType IN VARCHAR2,
        p_Balance     IN NUMBER
    );
    PROCEDURE CloseAccount(
        p_AccountID   IN NUMBER
    );
    FUNCTION GetTotalBalance(
        p_CustomerID  IN NUMBER
    ) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations IS
    PROCEDURE OpenAccount(
        p_AccountID   IN NUMBER,
        p_CustomerID  IN NUMBER,
        p_AccountType IN VARCHAR2,
        p_Balance     IN NUMBER
    ) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_AccountID, p_CustomerID, p_AccountType, p_Balance, CURRENT_DATE);
        COMMIT;
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            RAISE_APPLICATION_ERROR(-20007, 'Account already exists.');
    END OpenAccount;

    PROCEDURE CloseAccount(
        p_AccountID   IN NUMBER
    ) IS
    BEGIN
        DELETE FROM Accounts
        WHERE AccountID = p_AccountID;
        IF SQL%NOTFOUND THEN
            RAISE_APPLICATION_ERROR(-20008, 'Account not found.');
        END IF;
        COMMIT;
    END CloseAccount;

    FUNCTION GetTotalBalance(
        p_CustomerID  IN NUMBER
    ) RETURN NUMBER IS
        v_TotalBalance NUMBER;
    BEGIN
        SELECT NVL(SUM(Balance), 0) INTO v_TotalBalance
        FROM Accounts
        WHERE CustomerID = p_CustomerID;
        RETURN v_TotalBalance;
    END GetTotalBalance;
END AccountOperations;
/
