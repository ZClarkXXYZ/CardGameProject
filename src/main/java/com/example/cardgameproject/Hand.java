package com.example.cardgameproject;

/**
 * Filename:        Hand.java
 * Purpose:         Manages the player's hand of cards. Supports adding, removing, displaying cards,
 *                  and tracking which card is currently selected.
 *
 * Author:          [author]
 * Date:            [date]
 *
 *
 */

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();   // Cards currently in hand
    private Card selectedCard;                      // Currently selected card

    // Adds a card to the hand
    public void addCard(Card card) {
        cards.add(card);
    }

    // Removes a card from the hand
    public boolean removeCard(Card card) {
        return cards.remove(card);
    }

    // Returns all cards currently in hand
    public List<Card> showHand() {
        return cards;
    }

    //Sets which card is currently selected for play/discard
    public void setSelectedCard(Card selectedCard) {
        this.selectedCard = selectedCard;
    }

    // Gets the selected card
    public Card getSelectedCard() {
        return selectedCard;
    }
}
