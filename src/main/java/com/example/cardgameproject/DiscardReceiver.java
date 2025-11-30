package com.example.cardgameproject;

import java.util.ArrayList;
import java.util.List;

public class DiscardReceiver {
    private Hand hand;
    private Deck discardPile;

    public DiscardReceiver(Hand hand, Deck discardPile) {
        this.hand = hand;
        this.discardPile = discardPile;
    }

    public void discard(List<Card> cards) {
        if (cards == null || cards.isEmpty()) {
            return;
        }

        for (Card card : cards) {
            boolean discarded = hand.removeCard(card);
            if (discarded) {
                discardPile.addCard(card);
            }
        }
    }

    public void discardSelected(){
        List<Card> selected = hand.getSelectedCards();
        discard(selected);
        hand.deselectAll();
    }
}
