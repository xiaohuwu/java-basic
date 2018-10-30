package com.ktb.basic.concurrency.corejava;
/**
 * Created by dell on 2018-10-29.
 * 一个银行有100个账户 在这些账户之间转钱 本应该 总数不变的
 */
public class UnsynchBankTest {
    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 10000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;

    public static void main(String[] args) {
        Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
        for (int k = 0; k < NACCOUNTS; k++) {
            int fromAccount = k;
            Runnable runnable = () -> {
                try {
                    while (true) {
                        Thread.sleep(3000);
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((int) (DELAY * Math.random()));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            new Thread(runnable).start();
        }


    }
}
