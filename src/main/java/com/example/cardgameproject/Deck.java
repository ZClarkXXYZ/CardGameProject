package com.example.cardgameproject;

/**


 *  * Filename:    Deck.java
 *  * Purpose:     Manages a collection of cards, and the next card to draw based on an index.
 *  *              Used for draw deck, discard pile, and deck building.
 *  *
 *  * Note: The deckIndexes list appears to track card positions, but the
 *  *       current implementation always adds the same index. This may need
 *  *       revision based on intended shuffling/ordering behavior.
 *  *
 *  * Author:      [author]
 *  * Date:        [date]
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
