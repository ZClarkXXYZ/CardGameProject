package com.example.cardgameproject;

/**
 * Filename:    Deck.java
 * Purpose:     Manages a deck of CardInterface objects. Handles drawing cards and
 *              shuffling when the deck runs out. Works with decorated cards.
 *
 * Design Pattern: None - data structure class
 *
 * Note: Uses CardInterface (not Card) to support decorated cards
 *
 * Author:      ZC, jlg-repo (docs)
 */

import com.example.cardgameproject.decorator.CardInterface;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Deck {
    //A Collection of Cards. Stores the cards and corresponding indexes. Is used by GameModel
    private ArrayList<CardInterface> deck = new ArrayList<CardInterface>();
    private int nextCardIndex = 0;

    private Random random = new Random();

    //add CardInterface to the deck
    public void addCard(CardInterface card) {
        deck.add(card);
    }

    //remove CardInterface from the deck
    public void removeCard(CardInterface card) {
        System.out.println("Removing from deck: "+ card.getCardName());
        deck.remove(card);
    }

    //get the ArrayList of CardInterface object (the "deck" of cards)
    public ArrayList<CardInterface> getDeck() {
        return(deck);
    }

    //Clear the deck
    public void resetDeck() {
        deck.clear();
    }

    //draw next card
    public CardInterface drawCard() {
        if (deck.size() == 0) {
            return null;
        }
        nextCardIndex = nextCardIndex + 1;
        if (nextCardIndex >= deck.size()) {
            shuffleDeck();
            nextCardIndex = 0;
        }
        return(deck.get(nextCardIndex));
    }
    //gets a random card from the deck (without "drawing"
    public CardInterface getRandomCard() {
        CardInterface card = deck.get(random.nextInt(deck.size()));
        return card;
    }


    //shuffle the deck (array list of CardInterface objects)
    public void shuffleDeck() {
        for (int i = 0; i < deck.size()*3; i ++) {
            int j = random.nextInt(deck.size());
            Collections.swap(deck, i%(deck.size()), j);
        }
    }
}
