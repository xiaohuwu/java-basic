package com.ktb.basic.daimakuai;

/**
 * Created by dell on 2018-10-23.
 */

public class Student extends Person{

    static {
        System.out.println("[Student]static 代码块");
    }

    {
        int a = 6;
        if (a > 4) {
            System.out.println("[Student] a >4");
        }
    }

    public Student() {
        System.out.println("[Student]");
    }

    public static void main(String[] args) {
        new Student();
        //验证 static 代码块只初始化一次 即是在类初始化的时候
        new Student();
    }

}
