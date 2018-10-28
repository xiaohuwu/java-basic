package com.ktb.basic.concurrency;

import java.util.concurrent.ExecutorService;

/**
 * 子线程循环10次，接着主线程循环100，
 * 接着又回到子线程循环10次，
 * 接着再回到主线程又循环100，
 * 如此循环50次，请写出程序
 */
public class Demo6 {
    static boolean flag = true;

    public static void main(String[] args) {

        Runnable child = new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 50; j++) {
                    synchronized (Demo6.class) {
                        if (!flag) {
                            try {
                                Demo6.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        for (int k = 0; k < 10; k++) {
                            System.out.println(Thread.currentThread().getName() + "[k]" + k);
                        }
                        flag = !flag;
                        Demo6.class.notifyAll();
                    }
                }
            }
        };
        Runnable parent = new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 50; j++) {
                    synchronized (Demo6.class) {
                        if (flag) {
                            try {
                                Demo6.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        for (int k = 0; k < 100; k++) {
                            System.out.println(Thread.currentThread().getName() + "[k]" + k);
                        }
                        flag = !flag;
                        Demo6.class.notifyAll();
                    }
                }
            }
        };

        new Thread(child).start();
        new Thread(parent).start();
    }
}
