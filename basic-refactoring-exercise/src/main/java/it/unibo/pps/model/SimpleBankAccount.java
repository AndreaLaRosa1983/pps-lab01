package it.unibo.pps.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal
 * the withdrawal amount plus a fixed fee
 */
public class SimpleBankAccount implements BankAccount {

    private double balance;
    private final AccountHolder holder;
    private  final double WITHDRAW_FEE = 1;
    public SimpleBankAccount(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (checkUser(userID)) {
            this.balance += amount;
        }
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        if (checkUser(userID) && isWithdrawAllowed(withdrawTotalCost(amount))) {
            this.balance -= withdrawTotalCost(amount);
        }
    }

    private boolean isWithdrawAllowed(final double withdrawTotalCost){
        return this.balance >= withdrawTotalCost;
    }

    private boolean checkUser(final int id) {
        return this.holder.id() == id;
    }

    private double withdrawTotalCost(double amount) {
        return amount + WITHDRAW_FEE;
    }
}
