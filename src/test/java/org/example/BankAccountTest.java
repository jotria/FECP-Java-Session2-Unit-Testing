package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankAccountTest {
    private BankAccount bankAccount;

    @BeforeEach
    void setup(){
        bankAccount = new BankAccount("104465", "Joana S. Tria", 1000.0F);
    }

    // Deposit a valid amount
    @Test
    void shouldReturnCorrectAmountAfterValidDeposit() {
        bankAccount.deposit(500.0F);  // Deposit amount
        assertEquals(1500.0F, bankAccount.getAvailableBalance());
    }

    // Deposit an invalid amount
    @Test
    void shouldReturnCorrectAmountAfterInvalidDeposit() {
        bankAccount.deposit(-500.0F);  // Deposit amount
        assertEquals(1000.0F, bankAccount.getAvailableBalance());
    }

    // Withdraw a valid amount
    @Test
    void shouldReturnCorrectAmountAfterValidWithdraw() {
        bankAccount.withdraw(200.0F);  // Withdraw amount
        assertEquals(800.0F, bankAccount.getAvailableBalance());
    }

    // Withdraw an invalid amount
    @Test
    void shouldReturnCorrectAmountAfterInvalidWithdraw() {
        bankAccount.withdraw(-500.0F);  // Withdraw amount
        assertEquals(1000.0F, bankAccount.getAvailableBalance());
    }

    // Withdraw an amount that exceeds the balance
    @Test
    void shouldReturnCorrectAmountAfterWithdrawExceedBalance() {
        bankAccount.withdraw(2000.0F);  // Withdraw amount
        assertEquals(1000.0F, bankAccount.getAvailableBalance());
    }

    // Test the getAccountNumber() method
    @Test
    void shouldReturnCorrectAccountNumber() {
        assertEquals("104465",  bankAccount.getAccountNumber());
    }

    // Test creation of Bank Account without deposits
    @Test
    void shouldReturnCorrectAccountWithoutDeposits(){
        BankAccount bankAccount1 = new BankAccount("100500", "Bob the Builder");
        bankAccount1.displayInformation();
        assertEquals("100500", bankAccount1.getAccountNumber());
        assertEquals("Bob the Builder", bankAccount1.getBankAccountHolderName());
        assertEquals(0, bankAccount1.getAvailableBalance());
    }

    // additional: Test creation of Bank Account without invalid deposit
    @Test
    void shouldReturnCorrectAccountWithInvalidDeposits(){
        BankAccount bankAccount1 = new BankAccount("100500", "Bobby not the Builder", 0);
        bankAccount1.displayInformation();
        assertEquals("100500", bankAccount1.getAccountNumber());
        assertEquals("Bobby not the Builder", bankAccount1.getBankAccountHolderName());
        assertEquals(0, bankAccount1.getAvailableBalance());
    }
}