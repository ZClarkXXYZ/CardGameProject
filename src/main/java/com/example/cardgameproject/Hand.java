package com.example.cardgameproject;

import java.util.ArrayList;
import java.util.List;


public class Hand {
    private List<Card> cards = new ArrayList<>();
    private List<Card> selectedCards = new ArrayList<>();


    public boolean addCard(Card card) {
        if (!(cards.contains(card))) {
        cards.add(card);
        return true;
        }
        else {
            return false;
        }
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

    public void clearSelectedCards() {
        selectedCards.clear();
    }

    public boolean isSelected(Card selectedCard) {
        return selectedCards.contains(selectedCard);
    }


    public List<Card> getSelectedCards() {
        return selectedCards;
    }

    public void printHand() {
        for (int i = 0; i < cards.size(); i++) {
            System.out.println(cards.get(i).getCardName());
        }
    }
    public void printSelectedCards() {
        for (int i = 0; i < cards.size(); i++) {
            System.out.println(selectedCards.get(i).getCardName());
        }
    }

    public int getHandSize() {
        return cards.size();
    }
}