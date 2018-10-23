package com.ktb.basic.fanxing;

/**
 * Created by dell on 2018-10-19.
 */
@Deprecated
public class Demo<T> {
    private T var;

    public T getVar() {
        return var;
    }

    public void setVar(T var) {
        this.var = var;
    }
    public static void main(String[] args) {
        Demo demo  =new Demo();
        demo.setVar("xikao");
        System.out.println(demo.getVar());
    }
}
