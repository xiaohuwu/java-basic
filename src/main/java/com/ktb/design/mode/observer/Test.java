package com.ktb.design.mode.observer;

public class Test {

    public static void main(String[] args) {
        Observer observer = new ProgramMonkeyObserver();
        Subject subject = new Subject();
        subject.register(observer);
        subject.notifyObserver("20%");
        subject.notifyObserver("30%");
    }
}
