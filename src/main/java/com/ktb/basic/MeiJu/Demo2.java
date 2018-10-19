package com.ktb.basic.MeiJu;

/**
 * Created by dell on 2018-10-19.
 */
public enum Demo2 {

    RED(1, "red"), BLUE(2, "blue"), YELLOW(3, "yellow");
    private int value;
    private String name;

    Demo2(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        for (Demo2 demo2 : Demo2.values()) {
            System.out.println(demo2.getName() + ":" + demo2.getValue());
        }
    }

}
