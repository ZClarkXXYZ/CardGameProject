package com.example.cardgameproject;

/**
 * Filename:    Hand.java
 * Purpose:     Manages the player's hand of CardInterface objects. Tracks which cards
 *              are selected for playing or discarding. Supports toggle selection.
 *
 * Design Pattern: None - data structure class
 *
 * Key Methods:
 * - addCard(CardInterface): Returns boolean, checks for duplicates
 * - toggleSelectedCard(CardInterface): Toggle card selection state
 * - getHand(): Returns List<CardInterface> (not showHand())
 * - clearSelectedCards(): Deselects all cards
 * - isSelected(CardInterface): Check if card is selected
 *
 * Note: Uses CardInterface (not Card) to support decorated cards
 *
 * Author:      Chris, ZC (slightly modified code)
 */

import com.example.cardgameproject.decorator.CardInterface;

import java.util.ArrayList;
import java.util.List;


public class Hand {
    private List<CardInterface> cards = new ArrayList<>();
    private List<CardInterface> selectedCards = new ArrayList<>();


    public boolean addCard(CardInterface card) {
        if (!(cards.contains(card))) {
        cards.add(card);
        return true;
        }
        else {
            return false;
        }
    }

    public boolean removeCard(CardInterface card) {
        return cards.remove(card);
    }

    public void discardHand() {
        cards.clear();
    }


    public List<CardInterface> getHand() {
        return cards;
    }

    public void toggleSelectedCard(CardInterface selectedCard) {
        if (selectedCards.contains(selectedCard)) {
            selectedCards.remove(selectedCard);
            System.out.println("deselected");
        }
        else {
            selectedCards.add(selectedCard);
            System.out.println("selected");
        }
    }

    public void clearSelectedCards() {
        selectedCards.clear();
    }

    public boolean isSelected(CardInterface selectedCard) {
        return selectedCards.contains(selectedCard);
    }


    public List<CardInterface> getSelectedCards() {
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