package com.ktb.design.mode.headfirst.strategy;

/**
 * Created by dell on 2018-09-17.
 */
public abstract class Duck {

   protected FlyBehavior flyBehavior;
    protected  QuackBehavior quackBehavior;

    public void performFly(){
        flyBehavior.fly();
    }
    abstract void display();
    public void performQuack(){
        quackBehavior.quack();
    }
    public void swim(){
        System.out.println("swim");
    }
}
