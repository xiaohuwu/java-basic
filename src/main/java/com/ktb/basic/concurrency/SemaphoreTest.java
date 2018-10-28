package com.ktb.basic.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore 控制并发访问数
 *
 *
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(3);
        for (int k = 0; k < 10; k++) {
            int NO = k;
            Runnable child = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        synchronized (SemaphoreTest.class) {
                            System.out.println(Thread.currentThread().getName()
                                    + " 获取许可" + "剩余：" + semaphore.availablePermits());
                            Thread.sleep(1000);
                        }
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.execute(child);
        }
        executorService.shutdown();
    }
}
