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

    public SavingsAccountYear(int startingBalance, int staringPrincipal, int interestRate) {
        this.startingBalance = startingBalance;
        this.capitalGainsAmount = startingBalance - staringPrincipal;
        this.interestRate = interestRate;
    }

    public int startingBalance() {
        return startingBalance;
    }

    public int startingPrincipal () {
        return startingBalance() - capitalGainsAmount;
    }

    public int totalWithdrawn() {
        return totalWithdrawn;
    }

    public int endingPrincipal() {
        int result = startingPrincipal() - totalWithdrawn();
        return Math.max(0, result);
    }

    public int endingBalance(int capitalGainsTaxRate) {
        int modifiedStart = startingBalance - totalWithdrawn() - capitalGainsTaxIncurred(capitalGainsTaxRate);
        return modifiedStart + (modifiedStart  * interestRate / 100);
    }

    public int interestRate() {
        return interestRate;
    }

    public SavingsAccountYear nextYear(int capitalGainsTaxRate) {
        return new SavingsAccountYear(endingBalance(capitalGainsTaxRate), interestRate);
    }

    public void withdrawal(int amount) {
        this.totalWithdrawn += amount;
    }

    public int capitalGainsWithdrawn() {
        int result = -1 * (startingPrincipal() - totalWithdrawn());
        return Math.max(0, result);
    }

    public int capitalGainsTaxIncurred(int taxRate) {
        return capitalGainsWithdrawn() * taxRate / 100;
    }
}
