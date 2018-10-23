package com.ktb.basic.meiju;

/**
 * Created by dell on 2018-10-19.
 */
public enum Demo3 implements Print{

    RED(1, "red") {
        @Override
        public String print() {
            return "红色";
        }
    }, BLUE(2, "blue"){
        @Override
        public String print() {
            return "蓝色";
        }
    }, YELLOW(3, "yellow"){
        @Override
        public String print() {
            return "黄色";
        }
    };
    private int value;
    private String name;

    Demo3(int value, String name) {
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
        for (Demo3 demo2 : Demo3.values()) {
            System.out.println(demo2.getName() + ":" + demo2.getValue()+":"+demo2.print());
        }
    }

}
