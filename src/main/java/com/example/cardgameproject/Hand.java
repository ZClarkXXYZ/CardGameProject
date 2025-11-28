package com.example.cardgameproject;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();
    private Card selectedCard;

    public void addCard(Card card) {
        cards.add(card);
    }

    public boolean removeCard(Card card) {
        return cards.remove(card);
    }

    public List<Card> showHand() {
        return cards;
    }

    public void setSelectedCard(Card selectedCard) {
        this.selectedCard = selectedCard;
    }

    public Card getSelectedCard() {
        return selectedCard;
    }
}
