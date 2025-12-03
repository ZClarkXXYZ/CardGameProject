package com.example.cardgameproject;

/**
 *  * Filename:    Deck.java
 *  * Purpose:     Manages a collection of cards with parallel index tracking.
 *  *              Used for draw deck, discard pile, and deck building.
 *  *
 *  * Note: The deckIndexes list appears to track card positions, but the
 *  *       current implementation always adds the same index. This may need
 *  *       revision based on intended shuffling/ordering behavior.
 *  *
 *  * Author:      [author]
 *  * Date:        [date]
 */

import java.util.ArrayList;

public class Deck {
    //A Collection of Cards. Stores the cards and corresponding indexes. Is used by GameModel
    private ArrayList<Card> deck = new ArrayList<Card>();

    //Parallel list tracking card indices
    private ArrayList<Integer> deckIndexes = new ArrayList<Integer>();

    //add card to the deck and update indices
    public void addCard(Card card) {
        deck.add(card);
        if (deckIndexes.size() > 0) {
            deckIndexes.add(deckIndexes.get(deckIndexes.size() - 1));
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
