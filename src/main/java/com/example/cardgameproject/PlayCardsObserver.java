package com.example.cardgameproject;

import java.util.ArrayList;

public class PlayCardsObserver {
    private ArrayList<Card> playingHand = new ArrayList<Card>();


    public void addCard(Card card) {
        playingHand.add(card);
    }
    public void removeCard(Card card) {
        playingHand.remove(card);
    }

    public String playHand() {
        String fullString = "";
        for (int i = 0; i < playingHand.size(); i++) {
            //playCard
        }
        return fullString;
    }


}
