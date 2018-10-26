package com.ktb.basic.funny;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by dell on 2018-10-26.
 * <p>
 * 双色球生成器   "01" 到 "32"随机生成 6个数字 做为红色球数字 再从 "01" "07" 里面选择一个座位蓝色球
 */
public class BallTest {
     static String[] read_array = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
            "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32"};
    //用数组的下标对应 默认初始值都为false
    static   boolean[] read_array_flag = new boolean[read_array.length];

    static String[] blue_array = {"01", "02", "03", "04", "05", "06", "07"};
    static String[] need_read = new String[8];
    static int red_count = 0;

    public static void main(String[] args) {

        method_me();
        method_teacher();

    }

    private static void method_teacher() {
        for(int k=0;k< need_read.length;k++){
            int index =0;
            Random random = new Random();
            do{
                index = random.nextInt(32);
            }while (read_array_flag[index]);

            need_read[k] = read_array[index];
            read_array_flag[index] = true;
        }
        System.out.println(Arrays.toString(need_read));
    }

    private static void method_me() {
        while (red_count < need_read.length) {
            int index = new Random().nextInt(32);
            if(!read_array_flag[index]){
                read_array_flag[index]=true;
                need_read[red_count] = read_array[index];
                red_count++;
            }
        }
        System.out.println(Arrays.toString(need_read));
    }

}
