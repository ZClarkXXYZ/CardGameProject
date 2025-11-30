package com.example.cardgameproject;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();
    private List<Card> selectedCards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public boolean removeCard(Card card) {
        selectedCards.remove(card);
        return cards.remove(card);
    }

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
