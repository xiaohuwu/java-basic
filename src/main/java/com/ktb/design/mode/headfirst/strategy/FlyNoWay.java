package com.ktb.design.mode.headfirst.strategy;

/**
 * Created by dell on 2018-09-17.
 */
public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I can't fly");
    }

}
