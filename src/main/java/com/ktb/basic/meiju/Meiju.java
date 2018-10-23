package com.ktb.basic.meiju;

/**
 * Created by dell on 2018-10-19.
 * 新建可数的实例变量 用枚举
 */
public enum Meiju {
    RED, BLUE, YELLOW;

    public Meiju getInstance(int value) {
        switch (value) {
            case 1:
                return RED;

            case 2:
                return BLUE;

            case 3:
                return YELLOW;

            default:
                break;
        }
        return null;
    }

    public static void main(String[] args) {
        Meiju[] values = Meiju.values();
        for(Meiju meiju: values){
            System.out.println(meiju.ordinal()+":"+meiju.name());
        }
    }
}
