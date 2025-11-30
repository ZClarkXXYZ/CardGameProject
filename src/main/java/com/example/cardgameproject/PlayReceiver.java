package com.example.cardgameproject;

import java.util.ArrayList;
import java.util.List;

public class PlayReceiver {
    private Hand hand;
    private Deck played;

    public PlayReceiver(Hand hand, Deck toPlay) {
        this.hand = hand;
        this.played = toPlay;
    }

    public void play(List<Card> cards) {
        if (cards == null || cards.isEmpty()) {
            return;
        }

        for (Card card : cards) {
            boolean playedCard = hand.removeCard(card);
            if (playedCard) {
                played.addCard(card);
            }
        }
    }

    public void playSelected(){
        List<Card> selectedCards = hand.getSelectedCards();
        play(selectedCards);
        hand.deselectAll();
    }
}
