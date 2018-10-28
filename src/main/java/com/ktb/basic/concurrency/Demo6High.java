package com.ktb.basic.concurrency;

/**
 * 子线程循环10次，接着主线程循环100，
 * 接着又回到子线程循环10次，
 * 接着再回到主线程又循环100，
 * 如此循环50次，请写出程序
 *
 * 尽量让 业务代码 与 线程实现机制分离
 */
public class Demo6High {
   static   DataManager dataManager = new DataManager();

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

    static class DataManager{
         boolean flag = true;
         public void sub(){
             for (int j = 0; j < 50; j++) {
                 synchronized (DataManager.class) {
                     if (!flag) {
                         try {
                             DataManager.class.wait();
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                     }
                     for (int k = 0; k < 10; k++) {
                         System.out.println(Thread.currentThread().getName() + "[k]" + k);
                     }
                     System.out.println();
                     flag = !flag;
                     DataManager.class.notifyAll();
                 }
             }
        }

        public void parent(){
            for (int j = 0; j < 50; j++) {
                synchronized (DataManager.class) {
                    if (flag) {
                        try {
                            DataManager.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    for (int k = 0; k < 20; k++) {
                        System.out.println(Thread.currentThread().getName() + "[k]" + k);
                    }
                    System.out.println();
                    flag = !flag;
                    DataManager.class.notifyAll();
                }
            }
        }
    }
}
