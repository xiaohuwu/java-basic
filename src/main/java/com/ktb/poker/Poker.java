package com.ktb.poker;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by dell on 2018-10-10.
 */
public class Poker {
    private static String[] suites = {"黑桃", "红桃", "梅花", "方块"};
    private static String[] faces = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
    private Card[] cards;

    public Poker() {
        int index = 0;
        cards = new Card[suites.length * faces.length];
            for (int j = 0; j < faces.length; j++) {
                for (int k = 0; k < suites.length; k++) {
                cards[index++] =new Card( suites[k] , faces[j]);
            }
        }
        System.out.println("[poker]:"+ Arrays.toString(cards));
    }

    public void shuffle() {
        for (int k = 0; k < cards.length; k++) {
            int ramdom_index = (int) (Math.random() * cards.length);
            Card temp = cards[ramdom_index];
            cards[ramdom_index] = cards[k];
            cards[k] = temp;
        }
        System.out.println("[shuffle]:"+cards.length);
    }
    //发牌
    public void deal(int person_count) {

        HashMap<String,List<Card>> result = new HashMap<>();

        for(int k=0;k<cards.length;k++ ){
            if(k%person_count==0){
                dealData(result, k,"第一人");
            }else if(k%person_count == 1){
                dealData(result, k,"第二人");
            }else if (k%person_count == 2){
                dealData(result, k,"第三人");
            }
        }

        for(Map.Entry<String,List<Card>> entry: result.entrySet()){
            String key = entry.getKey();
            List<Card> value = entry.getValue();
            System.out.print(key+" ");
            for(Card card: value){
                System.out.print(card.toString());
            }
            System.out.println();
        }

    }

    private void dealData(HashMap<String, List<Card>> result, int index,String person) {
        if (!result.containsKey(person)){
            List<Card> list = new ArrayList<>();
            list.add(cards[index]);
            result.put(person,list);
        }else {
            List<Card> list = result.get(person);
            list.add(cards[index]);
            result.put(person,list);
        }
    }


}
