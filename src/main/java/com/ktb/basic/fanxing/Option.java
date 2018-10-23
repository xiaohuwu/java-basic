package com.ktb.basic.fanxing;

/**
 * Created by dell on 2018-10-19.
 */
public class Option{
    private char chioce;
    private String desc;

    public Option(char chioce, String desc) {
        this.chioce = chioce;
        this.desc = desc;
    }

    public char getChioce() {
        return chioce;
    }

    public void setChioce(char chioce) {
        this.chioce = chioce;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return  chioce +
                "  " + desc +";";
    }
}
