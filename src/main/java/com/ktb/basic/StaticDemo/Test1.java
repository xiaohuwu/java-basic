package com.ktb.basic.StaticDemo;
import com.ktb.design.mode.adapter.Test;
/**
 * Created by dell on 2018-10-22.
 * static 变量 也称全局变量 被所有对象共享
 */
public class Test1 {

    //一般来说 用静态常量
    private static int count = 0;
    public Test1() {
        count++;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        Test1 test2 = new Test1();
        System.out.println("新建对象：" + Test1.count + "次");
        System.out.println("[test2.count]" + test2.count + "次");
        int k=0;
        //验证 | || 短路运算
        if(k!=0 && 10/k==0){
            System.out.println("NO OK");
        }else{
            System.out.println("OK");
        }
    }


}
