package com.ktb.basic.funny;

/**
 * Created by dell on 2018-10-26.
 *
 *
 *
 *
 * 在两个数组中，索引相同且该相同索引上的值也相同，用a表示。
 在两个数组中，索引不同且该不同索引上的两个值相同，用b表示。
 例：
 int[] arrOne = { 2, 1, 4, 5, 6 };
 int[] arrTwo = { 2, 4, 7, 1, 6 };
 以上数组中有2个a， 2个b
 */
public class Matching {

    public static void main(String[] args) {
        int[] arrOne = { 2, 1, 4, 5, 6 };
        int[] arrTwo = { 2, 4, 7, 1, 6 };
        String result = match(arrOne,arrTwo);
        System.out.println(result);
    }

    private static String match(int[] arrOne, int[] arrTwo) {
        int a = 0;int b=0;
        for(int k=0;k< arrOne.length;k++){
            for(int j=0;j< arrTwo.length;j++){
                if(arrOne[k]==arrTwo[j] && k==j){
                    a++;
                }else if(arrOne[k]==arrTwo[j] && k!=j){
                    b++;
                }
            }
        }
        return "a="+a+"b="+b;
    }
}
