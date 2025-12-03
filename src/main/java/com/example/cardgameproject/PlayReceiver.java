package com.example.cardgameproject;
/**
 *  * Filename:    PlayReceiver.java
 *  * Purpose:     Receiver in the Command pattern. Contains the actual business
 *  *              logic for playing cards. Moves cards from hand to the played
 *  *              pile for recipe matching or other game mechanics.
 *  *
 *  * Design Pattern: Command pattern - Receiver
 *  *
 *  * The receiver knows HOW to play cards. Commands delegate to this class
 *  * to perform the actual work. Playing cards typically triggers recipe
 *  * checking and card effects.
 *  *
 *  * Author:      [author]
 *  * Date:        [date]
 */

import java.util.ArrayList;
import java.util.List;

public class PlayReceiver {
    private Hand hand; // player's hand
    private Deck played; // the cards that have been played

    // Constructor: creates receiver with refs. to hand and played pile
    public PlayReceiver(Hand hand, Deck toPlay) {
        this.hand = hand;
        this.played = toPlay;
    }

    // Plays a list of cards, moves them from hand to played pile
    // Moves the cards but does not trigger recipe checks or card effects
    public void play(List<Card> cards) {
        if (cards == null || cards.isEmpty()) { // null check
            return;
        }

        // Iterate through cards, attempt to play each one
        for (Card card : cards) {
            boolean playedCard = hand.removeCard(card);
            if (playedCard) {
                played.addCard(card);
            }
        }
    }

    // Plays currently selected cards from hand
    public void playSelected(){
        List<Card> selectedCards = hand.getSelectedCards();
        play(selectedCards);
        hand.deselectAll();
    }

    // TODO: After all cards played, check for recipe matches/card effects?
}
