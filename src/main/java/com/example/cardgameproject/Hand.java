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
    private List<Card> selectedCards = new ArrayList<>();

    // Adds a card to the hand
    public void addCard(Card card) {
        cards.add(card);
    }

    // Removes a card from the hand
    public boolean removeCard(Card card) {
        selectedCards.remove(card);
        return cards.remove(card);
    }

    // Returns all cards currently in hand
    public List<Card> showHand() {
        return cards;
    }

    public void selectCard(Card card) {
        if (card == null) {return;}
        if (cards.contains(card) && !selectedCards.contains(card)) {
            selectedCards.add(card);
        }
    }

    public void deselectCard(Card card) {
        selectedCards.remove(card);
    }



    public void deselectAll() {
        selectedCards.clear();
    }

    public List<Card> getSelectedCards() {
        return new ArrayList<>(selectedCards);
    }
}
