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
    private DiscardReceiver discardReceiver;        // The object that performs the discarding

    //TODO: Do we need a card field here?

    // Constructor - creates a discard command for a specific card
    public DiscardButtonCommand(DiscardReceiver discardReceiver) {
        this.discardReceiver = discardReceiver;
    }

    // Discard the card
    @Override
    public void execute() {
        discardReceiver.discardSelected();
    }
}
