package it.unibo.pps.model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, 0);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        int amount = 100;
        bankAccount.deposit(accountHolder.id(), amount);
        assertEquals(amount, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        int deposit = 100;
        int wrongDeposit = 50;
        int wrongUser = 2;
        bankAccount.deposit(accountHolder.id(), deposit);
        bankAccount.deposit(wrongUser, wrongDeposit);
        assertEquals(deposit, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        int deposit = 100;
        int withdrawAmount = 70;
        bankAccount.deposit(accountHolder.id(), deposit);
        bankAccount.withdraw(accountHolder.id(), withdrawAmount);
        assertEquals(deposit - withdrawAmount, bankAccount.getBalance());
    }

    @Test
    void testWrongIDWithdraw() {
        int deposit = 100;
        int withDraw = 70;
        int wrongId = 2;
        bankAccount.deposit(accountHolder.id(), deposit);
        bankAccount.withdraw(wrongId, withDraw);
        assertEquals(deposit, bankAccount.getBalance());
    }

    @Test
    void testOverBalanceWithdraw() {
        int deposit = 50;
        int withDraw = 70;
        bankAccount.deposit(accountHolder.id(), deposit);
        bankAccount.withdraw(accountHolder.id(), withDraw);
        assertEquals(deposit, bankAccount.getBalance());
    }
}
