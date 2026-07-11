package com.example;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {
    private BankAccount account;

    @Before
    public void setUp() {
        account = new BankAccount(100.0);
    }

    @After
    public void tearDown() {
        account = null;
    }

    @Test
    public void testDeposit() {
        // Arrange
        double depositAmount = 50.0;
        double expectedBalance = 150.0;

        // Act
        account.deposit(depositAmount);
        double actualBalance = account.getBalance();

        // Assert
        assertEquals(expectedBalance, actualBalance, 0.001);
    }

    @Test
    public void testWithdraw() {
        // Arrange
        double withdrawAmount = 40.0;
        double expectedBalance = 60.0;

        // Act
        account.withdraw(withdrawAmount);
        double actualBalance = account.getBalance();

        // Assert
        assertEquals(expectedBalance, actualBalance, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawInsufficientFunds() {
        // Arrange
        double withdrawAmount = 150.0;

        // Act
        account.withdraw(withdrawAmount);
    }
}
