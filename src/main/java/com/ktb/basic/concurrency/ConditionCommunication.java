package com.ktb.basic.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionCommunication {

    public static void main(String[] args) {
        Business bussiness = new Business();

        new Thread(new Runnable() {// 开启一个子线程

            @Override
            public void run() {
                for (int i = 1; i <= 50; i++) {

                    bussiness.sub(i);
                }

            }
        }).start();

        // main方法主线程
        for (int i = 1; i <= 50; i++) {

            bussiness.main(i);
        }
    }
}

class Business {

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition(); //Condition是在具体的lock之上的

    private boolean bShouldSub = true;

    public void sub(int i) {
        lock.lock();
        try {
            while (!bShouldSub) {
                try {
                    condition.await(); //用condition来调用await方法
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            for (int j = 1; j <= 10; j++) {
                System.out.println("sub thread sequence of " + j
                        + ", loop of " + i);
            }
            bShouldSub = false;
            condition.signal(); //用condition来发出唤醒信号，唤醒某一个
        } finally {
            lock.unlock();
        }
    }

    public void main(int i) {
        lock.lock();
        try {
            while (bShouldSub) {
                try {
                    condition.await(); //用condition来调用await方法
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            for (int j = 1; j <= 10; j++) {
                System.out.println("main thread sequence of " + j
                        + ", loop of " + i);
            }
            bShouldSub = true;
            condition.signal(); //用condition来发出唤醒信号么，唤醒某一个
        } finally {
            lock.unlock();
        }
    }
}

