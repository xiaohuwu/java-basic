package com.ktb.basic.concurrency;

/**
 * Created by dell on 2018-10-26.
 * 线程通信
 * 有两个线程，子线程先执行10次，然后主线程执行5次，然后再切换到子线程执行10，再主线程执行5次……如此往返执行50次
 */
public class Demo2 {

    public static boolean flag = true;

    public static void main(String[] args) {
        //开启一个子线程
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 1; i <= 50; i++) {

                    synchronized (Demo2.class) {
                        //子线程任务：执行10次
                        if (!flag) {
                            try {
                                Demo2.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        for (int j = 1; j <= 10; j++) {
                            System.out.println("sub thread sequence of " + j + ", loop of " + i);
                        }
                        System.out.println();
                        flag =!flag;
                        Demo2.class.notifyAll();
                    }
                }

            }
        }).start();

        //main方法即主线程
        for (int i = 1; i <= 50; i++) {

            synchronized (Demo2.class) {
                //主线程任务：执行5次
                if (flag) {
                    try {
                        Demo2.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                for (int j = 1; j <= 5; j++) {
                    System.out.println("main thread sequence of " + j + ", loop of " + i);
                }
                flag =!flag;
                System.out.println();
                Demo2.class.notifyAll();
            }
        }
    }


}
