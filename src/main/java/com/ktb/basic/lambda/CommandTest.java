package com.ktb.basic.lambda;

/**
 * Created by dell on 2018-10-22.
 */
public class CommandTest {
    public static void main(String[] args) {
        ProcessArray processArray = new ProcessArray();
        int[] target = new int[]{1, 2, 3, 4, 6, 7, 9};
        processArray.process(target, (int[] array)-> {
                int sum = 0;
                for (int tmp : array) {
                    sum += tmp;
                }
                System.out.println("[sum]:" + sum);
            }
        );
    }
}
