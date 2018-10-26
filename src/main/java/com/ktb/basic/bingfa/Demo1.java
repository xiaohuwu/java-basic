package com.ktb.basic.bingfa;
/**
 * Created by dell on 2018-10-26.
 */
public class Demo1 {
    static int count = 0;

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        Runnable runnable = () ->{
            System.out.println(Thread.currentThread().getName()+":"+(1/0));
        };
        Thread thread = new Thread(runnable);
        thread.setUncaughtExceptionHandler(new ThreadGroup("user"));
        thread.start();
    }
}
