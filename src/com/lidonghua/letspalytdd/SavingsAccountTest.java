package com.lidonghua.letspalytdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SavingsAccountTest {
    @Test
    public void nothing() {
        SavingsAccount account = new SavingsAccount();
        account.deposit(100);
        assertEquals(100, account.balance());
    }
}
