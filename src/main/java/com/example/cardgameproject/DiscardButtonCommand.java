package com.example.cardgameproject;

/**
 * Filename:       DiscrdButtonCommand.java
 * Purpose:        Concrete command that handles discarding a card. Encapsulates the discard action
 *                 so it can be bound to UI buttons.
 *
 * Design Pattern: Concrete Command in Command pattern
 *
 * Author:          [author]
 * Date:            [date]
 *
 *
 */

public class DiscardButtonCommand implements ButtonCommand{
    private DiscardReceiver discardReceiver;
    private Card card;

    public DiscardButtonCommand(DiscardReceiver discardReceiver, Card card) {
        this.discardReceiver = discardReceiver;
        this.card = card;
    }

    @Override
    public void execute() {
        discardReceiver.discard(card);
    }
}
