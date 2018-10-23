package com.ktb.poker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018-10-10.
 */
public class Test {
    public static void main(String[] args) {
        //制牌
        Poker poker = new Poker();
        //洗牌
        poker.shuffle();
        List<String> players = new ArrayList<String>();
        players.add("张三");
        players.add("李四");
        players.add("王五");
        poker.initPlayer(players);
        //发牌
        poker.deal();
    }
}
