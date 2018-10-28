package com.ktb.basic.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
      final    CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        for(int k = 0;k<3;k++){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long)(Math.random()*10000));

                        System.out.println("当前有"+cyclicBarrier.getNumberWaiting()+"到达 集合点一 请稍候");
                        cyclicBarrier.await();

                        Thread.sleep((long)(Math.random()*10000));
                        System.out.println("当前有"+cyclicBarrier.getNumberWaiting()+"到达  集合点二 请稍候");
                        cyclicBarrier.await();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.execute(runnable);
        }
    }
}
