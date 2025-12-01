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

    public DiscardButtonCommand(DiscardReceiver discardReceiver) {
        this.discardReceiver = discardReceiver;
    }

    @Override
    public void execute() {
        discardReceiver.discardSelected();
    }
}
