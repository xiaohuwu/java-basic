package com.ktb.design.mode.headfirst.strategy;

/**
 * Created by dell on 2018-09-17.
 */
public class RedHeadDuck extends Duck {

    public RedHeadDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    public void  setFly(FlyBehavior flyBehavior){
        this.flyBehavior = flyBehavior;
    }

    @Override
    void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
