package com.ktb.poker;

/**
 * Created by dell on 2018-10-10.
 */

public class Card {
    private String suit;
    //花色
    private String face;

    //点数


    public Card(String suit,String face){
        this.suit = suit;
        this.face = face;
    }

    @Override
    public String toString() {
        return "[" +suit +" " + face +']';
    }
}
