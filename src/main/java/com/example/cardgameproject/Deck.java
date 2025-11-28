package com.example.cardgameproject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.Collections;

public class Deck {
    //A Collection of Cards. Stores the cards and corresponding indexes. Is used by GameModel
    private ArrayList<Card> deck = new ArrayList<Card>();
    private int nextCardIndex = 0;

    private Random random = new Random();

    //addCard
    public void addCard(Card card) {
        deck.add(card);
    }

    //removeCard
    public void removeCard(Card card) {
        deck.remove(card);
    }

    //get deck
    public ArrayList<Card> getDeck() {
        return(deck);
    }

    //draw next card
    public Card drawCard() {
        if (deck.size() == 0) {
            return null;
        }
        nextCardIndex =+ 1;
        if (nextCardIndex >= deck.size()) {
            shuffleDeck();
            nextCardIndex = 0;
        }
        return(deck.get(nextCardIndex));
    }


    //shuffleDeck
    public void shuffleDeck() {
        for (int i = 0; i < deck.size()*2; i ++) {
            int j = random.nextInt(deck.size());
            Collections.swap(deck, i%(deck.size()), j);
        }
    }
}
