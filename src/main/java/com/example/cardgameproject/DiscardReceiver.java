package com.example.cardgameproject;

/**
 *  Filename:    DiscardReceiver.java
 *  Purpose:     Receiver in the Command pattern. Contains the actual business
 *               logic for discarding cards. Moves cards from hand to discard pile.
 *
 *  Design Pattern: Command pattern - Receiver
 *
 *  The receiver knows how to discard cards. Commands delegate to this class
 *  to perform the actual work.
 *
 *  Author:      [author]
 *  Date:        [date]
 */

import java.util.ArrayList;
import java.util.List;

public class DiscardReceiver {
    private Hand hand;      // Player's hand
    private Deck discardPile;       // Discard pile

    // Constructor: creates a receiver with references to hand and discardPile
    public DiscardReceiver(Hand hand, Deck discardPile) {
        this.hand = hand;
        this.discardPile = discardPile;
    }

    // Discards a specific card by moving it from the hand to discard pile
    public void discard(List<Card> cards) {
        if (cards == null || cards.isEmpty()) { // null check
            return;
        }

        // Loop to discard cards
        for (Card card : cards) {
            boolean discarded = hand.removeCard(card); // try to remove card from hand
            if (discarded) {   // if it has been removed from hand, add to discard pile
                discardPile.addCard(card);
            }
        }
    }

    // Discards the currently selected list of cards from hand
    public void discardSelected(){
        List<Card> selected = hand.getSelectedCards();
        discard(selected);
        hand.deselectAll();
    }
}
