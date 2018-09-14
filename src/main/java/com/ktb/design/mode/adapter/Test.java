package com.ktb.design.mode.adapter;

import com.ktb.design.mode.observer.Observer;
import com.ktb.design.mode.observer.ProgramMonkeyObserver;
import com.ktb.design.mode.observer.Subject;

public class Test {

    public static void main(String[] args) {

        ServerThree serverThree = new ServerThree();
        String s = XMLBuilder.buildXML(serverThree);
        System.out.println("[serverThree]:"+s);
        ServerTwo serverTwo = new ServerTwo();
        s = XMLBuilder.buildXML(serverTwo);
        System.out.println("[ServerTwo]:"+s);
        //XMLBuilder 暂时只能装配 PlayerCount 类型的参数 所以 serverOne 适应不了接口 只能 通过中间的适配器转变一下
        ServerOneAdapter adapter = new ServerOneAdapter(new ServerOne());
        s = XMLBuilder.buildXML(adapter);
        System.out.println("[ServerTwo]:"+s);
    }
}
