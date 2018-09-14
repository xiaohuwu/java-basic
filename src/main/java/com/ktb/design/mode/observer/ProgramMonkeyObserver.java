package com.ktb.design.mode.observer;

public class ProgramMonkeyObserver  implements  Observer {
    @Override
    public void update(String status) {
        System.out.println("Programer look the SDK download process is:"+status);
    }
}
