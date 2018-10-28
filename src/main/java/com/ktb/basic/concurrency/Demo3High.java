package com.ktb.basic.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 设计4个线程，其中两个线程每次对j增加1，另外两个线程对j每次减少1。写出程序
 */
public class Demo3High {
   static NumManager numManager =  new NumManager();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //new NumManager().add() not work 他们不是用的同一把锁
                for(int k=0;k<10;k++){
                    numManager.add();
                }
            }
        };

        Runnable runnable_1 = new Runnable() {
            @Override
            public void run() {
                for(int k=0;k<10;k++){
                    numManager.sub();
                }
            }
        };

        for(int k=0;k<2;k++){
            executorService.execute(runnable);
           executorService.execute(runnable_1);
        }
    }
    static class  NumManager{
        private int j=0;
        public synchronized void add(){
            j++;
            System.out.println(Thread.currentThread().getName()+"[add]"+j);
        }
        public synchronized void sub(){
            j--;
            System.out.println(Thread.currentThread().getName()+"[sub]"+j);
        }
    }
}
