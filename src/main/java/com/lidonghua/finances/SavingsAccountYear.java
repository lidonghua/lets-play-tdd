package com.lidonghua.finances;

public class SavingsAccountYear {
    private int interestRate = 0;
    private int capitalGainsAmount = 0;
    private int startingBalance = 0;
    private int totalWithdrawn  = 0;

    public SavingsAccountYear(int startingBalance, int interestRate) {
        this.startingBalance = startingBalance;
        this.interestRate = interestRate;
    }

    public SavingsAccountYear(int startingBalance, int capitalGainsAmount, int interestRate) {
        this.startingBalance = startingBalance;
        this.capitalGainsAmount = capitalGainsAmount;
        this.interestRate = interestRate;
    }

    public int startingBalance() {
        return startingBalance;
    }

    public int startingPrincipal () {
        return startingBalance - capitalGainsAmount;
    }

    public int endingPrincipal() {
        int result = startingPrincipal() - totalWithdrawn;
        return (result < 0) ? 0 : result;
    }

    public int endingBalance() {
        int modifiedStart = startingBalance - totalWithdrawn;
        return modifiedStart + (modifiedStart  * interestRate / 100);
    }

    public int interestRate() {
        return interestRate;
    }

    public SavingsAccountYear nextYear() {
        return new SavingsAccountYear(endingBalance(), interestRate);
    }

    public void withdrawal(int amount) {
        this.totalWithdrawn += amount;
    }
}
