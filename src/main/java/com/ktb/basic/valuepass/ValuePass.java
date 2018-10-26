package com.ktb.basic.valuepass;

import com.ktb.basic.Dog;

import java.util.Arrays;

/**
 * Created by dell on 2018-10-18.
 */
public class ValuePass {
    public static void main(String[] args) {
        Dog dog = new Dog("max");
        foo(dog);//2
        boolean max = dog.getName().equals("max");
        //@行注释 false @ 不注释 true  最好画出他们的堆栈图 便于理解
        System.out.println(max);
        int[] array = {1, 2, 3, 4};
        int[] ints = Arrays.copyOf(array, array.length * 2);
        System.out.println("[ints]:" + Arrays.toString(ints));
    }

    private static void foo(Dog dog) { //在栈中新建一个变量 并且把2处的值赋值给它。
        // dog = new Dog("xiaozhang"); //@
        dog.setName("黄东");
    }

}
