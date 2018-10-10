package com.ktb.poker;

/**
 * Created by dell on 2018-10-10.
 */
public class Test {
    public static void main(String[] args) {
        //制牌
        Poker poker = new Poker();
        //洗牌
        poker.shuffle();
        //发牌
        poker.deal(3);
    }
}
