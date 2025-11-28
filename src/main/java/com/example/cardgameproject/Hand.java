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
        return cards.remove(card);
    }

    public void discardHand() {
        cards.clear();
    }


    public List<Card> getHand() {
        return cards;
    }

    public void toggleSelectedCard(Card selectedCard) {
        if (selectedCards.contains(selectedCard)) {
            selectedCards.remove(selectedCard);
        }
        else {selectedCards.add(selectedCard);}
    }


    public List<Card> getSelectedCards() {
        return selectedCards;
    }

}