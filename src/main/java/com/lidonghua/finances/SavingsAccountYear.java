package com.lidonghua.finances;

public class SavingsAccountYear {
    private int interestRate = 0;
    private int startingBalance = 0;

    public SavingsAccountYear() {}

    public SavingsAccountYear(int startingBalance, int interestRate) {
        this.startingBalance = startingBalance;
        this.interestRate = interestRate;
    }

    public int startingBalance() {
        return startingBalance;
    }

    public int balance() {
        return startingBalance;
    }

    public SavingsAccountYear nextYear() {
        return new SavingsAccountYear(endingBalance(), interestRate);
    }

    public int endingBalance() {
        return balance() + balance() * interestRate / 100;
    }

    public int interestRate() {
        return interestRate;
    }
}
