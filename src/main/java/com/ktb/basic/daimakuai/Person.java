package com.ktb.basic.daimakuai;

/**
 * Created by dell on 2018-10-23.
 */
public class Person {

    static {
        System.out.println("[Person]:static 代码块");
    }

    {
        int a = 6;
        if (a > 4) {
            System.out.println("[Person]:a >4");
        }
    }

    public Person() {
        System.out.println("[Person]:Person");
    }

    public static void main(String[] args) {
        new Person();
    }

}
