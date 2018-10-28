package com.ktb.basic.concurrency;

/**
 * Created by dell on 2018-10-26.
 */
public class waitDemo {
    public static Object object = new Object();
    public static void main(String[] args) {

        Thread thread_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                    }
                    System.out.println("线程"+Thread.currentThread().getName()+"获取到了锁");
                }
            }
        });
        thread_1.setName("thread_1");

        Thread thread_2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    object.notify();
                    System.out.println("线程"+Thread.currentThread().getName()+"调用了object.notify()");
                }
                System.out.println("线程"+Thread.currentThread().getName()+"释放了锁");
            }
        });
        thread_1.setName("thread_2");

        thread_1.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread_2.start();

    }
}
