package com.ktb.design.mode.headfirst.strategy;
/**
 * Created by dell on 2018-09-17.
 */
public class Quack implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("Quack");
    }

}
