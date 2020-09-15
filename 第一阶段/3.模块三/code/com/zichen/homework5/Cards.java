package com.zichen.homework5;

import java.util.*;

public class Cards{
   private static final String[] values = {"大王", "小王", "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};
   private static final String[] suits = {"红桃", "黑桃", "梅花", "方块" };
   private Map<Integer, String> cards = new HashMap<>();
   private List<Integer> order = new ArrayList<>();
   private List<Integer> player1 = new ArrayList<>();
   private List<Integer> player2 = new ArrayList<>();
   private List<Integer> player3 = new ArrayList<>();
   private List<Integer> holeCards = new ArrayList<>();

   private void generateCards(){
       cards.put(1, values[0]);
       cards.put(2, values[1]);
       order.add(1);
       order.add(2);
       int cardKey = 3;
       for(int i = 2; i < values.length; i++){
           for (String suit : suits) {
               cards.put(cardKey, suit + values[i]);
               order.add(cardKey);
               cardKey++;
           }
       }
       Collections.shuffle(order);
   }

   private void dealCards(){
       for(int i = 0; i < order.size(); i++){
           int cardKey = order.get(i);
           if(i < 3){
               holeCards.add(cardKey);
           }else if(i % 3 == 1){
               player1.add(cardKey);
           }else if(i % 3 == 2){
               player2.add(cardKey);
           }else{
               player3.add(cardKey);
           }
       }
   }

    public void showCardsInfo(){
       generateCards();
       dealCards();
       Collections.sort(player1);
       Collections.sort(player2);
       Collections.sort(player3);
       System.out.println("玩家一");
       printCards(player1, cards);
       System.out.println("玩家二");
       printCards(player2, cards);
       System.out.println("玩家三");
       printCards(player3, cards);
       System.out.println("底牌");
       printCards(holeCards, cards);
    }

    private void printCards(List<Integer> player, Map<Integer, String> cards){
        for(Integer cardKey : player){
            System.out.print(cards.get(cardKey)+" ");
        }
        System.out.println();
    }
}
