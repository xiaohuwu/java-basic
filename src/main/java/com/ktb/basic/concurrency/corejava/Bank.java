package com.ktb.basic.concurrency.corejava;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dell on 2018-10-29.
 * Condition 只能用于在 Lock 条件下的通信 即当一个线程拥有某个条件锁的时候 她仅仅可以在该条件上调用 await signalAll 或signal 方法
 *
 */

public class Bank {
    private double[] account;
    private Lock bankLock;
    private Condition sufficientFunds;
    public Bank(int accountNum, double initBalance) {
        account = new double[accountNum];
        Arrays.fill(account, initBalance);
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();

    }

    void transfer(int from, int to, double amount) throws InterruptedException {
        //注意此处 不用 if 用 while 防止线程假醒
        bankLock.lock();
        try{
            while (account[from] < amount){
                sufficientFunds.await();
            }
            account[to] += amount;
            account[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            sufficientFunds.signalAll();
        }finally {
            bankLock.unlock();
        }

    }

    private double getTotalBalance() {
        bankLock.lock();
        try{
            double sum = 0;
            for (int k = 0; k < size(); k++) {
                sum += account[k];
            }
            return sum;
        }finally {
            bankLock.unlock();
        }

    }

    public int size() {
        return account.length;
    }
}
