package com.ktb.basic.extendsdemo;
import com.ktb.basic.exception.Fruit;
/**
 * Created by dell on 2018-10-23.
 */

public class Apple extends Fruit {
    public static void main(String[] args) {
        Apple apple = new Apple();
        //info 方法 的访问类型为默认 他的作用域在一个包里面 此处访问不到
        //apple.info();
    }
}


