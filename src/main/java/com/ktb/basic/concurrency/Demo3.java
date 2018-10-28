package com.ktb.basic.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 设计4个线程，其中两个线程每次对j增加1，另外两个线程对j每次减少1。写出程序
 */
public class Demo3 {
    private static AtomicInteger  cont= new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (Demo3.class){
                    cont.incrementAndGet();
                    System.out.println(Thread.currentThread().getName()+"+[j]:"+cont.intValue());
                }
            }
        };

        Runnable runnable_1 = new Runnable() {
            @Override
            public void run() {
                synchronized (Demo3.class){
                    cont.decrementAndGet();
                    System.out.println(Thread.currentThread().getName()+"-[j]:"+cont.intValue());
                }
            }
        };

        for(int k=0;k<2;k++){
            executorService.execute(runnable);
           executorService.execute(runnable_1);
        }
    }
}
