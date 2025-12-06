package com.example.cardgameproject.command;
import com.example.cardgameproject.decorator.CardInterface;
import com.example.cardgameproject.singleton.GameModel;
import com.example.cardgameproject.Hand;

import java.util.List;

/**
 *  Filename:    DiscardReceiver.java
 *  Purpose:     Receiver in the Command pattern. Contains the
 *               logic for discarding cards. Removes cards from hand, draws new ones from the deck.
 *
 *  Design Pattern: Command pattern - Receiver

 *
 *  The receiver knows how to discard cards. Commands delegate to this class
 *  to perform the actual work.
 *
 *  Authors: Chris (design pattern, main code), ZC (some modifications to the code)
 */

public class DiscardReceiver {
    private Hand hand; // Player's hand
    private GameModel game;

    public DiscardReceiver() {
        this.game = GameModel.getInstance();
        this.hand = game.getHandObject();
    }

    // Check to determine if there are selected cards
    public void discard() {
        if (hand.getSelectedCards().size() == 0) {
            return;
        }
        discardSelected();
    }

    // Loop to discard cards, clear the selcted cards,then have hand draw more cards
    public void discardSelected(){
        List<CardInterface> selectedCards = hand.getSelectedCards();
        for (int i = 0; i < selectedCards.size(); i++) {
            System.out.println("Discarded: " + selectedCards.get(i).getCardName());
            selectedCards.get(i).additionalDiscardEffects();
            hand.removeCard(selectedCards.get(i));
        }
        hand.clearSelectedCards();
        game.drawHand();
    }
}
