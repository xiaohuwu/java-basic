package com.ktb.basic.concurrency;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 多线程并发执行 并获取执行结果
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();//定义一个缓存线程池
        CompletionService<Integer> completionService =
                new ExecutorCompletionService<Integer>(threadPool); //将线程池扔进去

        for(int i = 1; i <= 5; i ++) {
            final int seq = i;
            completionService.submit( //用里面装的线程去执行这些任务，每个线程都会返回一个数据
                    new Callable<Integer> () {
                        @Override
                        public Integer call() throws Exception {
                            Thread.sleep(new Random().nextInt(5000));
                            return seq;
                        }

                    }
            );
        }

        System.out.println("main wait:");
        for(int i = 0; i < 5; i ++) { //执行完了后，再取出来
            try {
                System.out.print(completionService.take().get() + " ");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
