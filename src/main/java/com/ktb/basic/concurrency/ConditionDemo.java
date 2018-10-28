package com.ktb.basic.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 子线程循环10次，接着主线程循环100，
 * 接着又回到子线程循环10次，
 * 接着再回到主线程又循环100，
 * 如此循环50次，请写出程序
 * <p>
 * 尽量让 业务代码 与 线程实现机制分离
 */
public class ConditionDemo {
    static DataManager dataManager = new DataManager();

    public static void main(String[] args) {

        Runnable child = new Runnable() {
            @Override
            public void run() {
                dataManager.sub();
            }
        };
        Runnable parent = new Runnable() {
            @Override
            public void run() {
                dataManager.parent();
            }
        };

        new Thread(child).start();
        new Thread(parent).start();
    }

    static class DataManager {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        boolean flag = true;

        public void sub() {
            for (int j = 0; j < 50; j++) {
                lock.lock();
                try {
                    while (!flag) {
                        try {
                            condition.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    for (int k = 0; k < 10; k++) {
                        System.out.println(Thread.currentThread().getName() + "[k]" + k + "loop:" + j);
                    }
                    System.out.println();
                    flag = !flag;
                    condition.signal();
                } finally {
                    lock.unlock();
                }
            }
        }

        public void parent() {
            for (int j = 0; j < 50; j++) {
                lock.lock();
                try {
                    while (flag) {
                        try {
                            condition.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    for (int k = 0; k < 20; k++) {
                        System.out.println(Thread.currentThread().getName() + "[k]" + k + "loop:" + j);
                    }
                    System.out.println();
                    flag = !flag;
                    condition.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
