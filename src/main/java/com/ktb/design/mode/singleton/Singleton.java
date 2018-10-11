package com.ktb.design.mode.singleton;

public class Singleton {

    public static volatile Singleton singleton;

    private Singleton(){

    }

    public static  Singleton getSingleton(){
        synchronized (Singleton.class){
            if (singleton==null){
                singleton  =new Singleton();
            }
        }
        return  singleton;
    }


}
