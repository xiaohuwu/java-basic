package com.ktb.design.mode.headfirst.strategy;

/**
 * Created by dell on 2018-09-17.
 */
public class Test {

    public static void main(String[] args) {
        RedHeadDuck redHeadDuck = new RedHeadDuck();
        redHeadDuck.performFly();

        redHeadDuck.setFly(new FlyWithRocte());

        redHeadDuck.performFly();

    }

}
