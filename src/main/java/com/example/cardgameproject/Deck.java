package com.example.cardgameproject;

import java.util.ArrayList;

public class Deck {
    //A Collection of Cards. Stores the cards and corresponding indexes. Is used by GameModel
    private ArrayList<Card> deck = new ArrayList<Card>();
    private ArrayList<Integer> deckIndexes = new ArrayList<Integer>();

    //addCard
    public void addCard(Card card) {
        deck.add(card);
        if (deckIndexes.size() > 0) {
            deckIndexes.add(deckIndexes.get(deckIndexes.size()));
        }
        else {
            deckIndexes.add(0);
        }
    }

    //removeCard
    public void removeCard(Card card) {
        deck.remove(card);
    }

    //get deck
    public ArrayList<Card> getDeck() {
        return(deck);
    }

    //get deck indexes
    public ArrayList<Integer> getDeckIndexes() {
        return(deckIndexes);
    }

}
