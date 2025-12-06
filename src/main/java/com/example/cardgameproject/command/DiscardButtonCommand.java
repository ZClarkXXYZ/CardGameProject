package com.example.cardgameproject.command;

/**
 * Filename:    DiscardButtonCommand.java
 * Purpose:     Concrete implementation of ButtonCommand for discarding cards.
 *              Encapsulates the discard action to be executed when the discard
 *              button is clicked.
 *
 * Design Pattern: Command pattern - Concrete Command
 *
 * Author: Chris
 */

public class DiscardButtonCommand implements ButtonCommand{

    private DiscardReceiver discardReceiver = new DiscardReceiver();

    // Constructor - creates a discard command
    public DiscardButtonCommand(DiscardReceiver discardReceiver) {
        this.discardReceiver = discardReceiver;
    }


    //executes the discarding of selected card (through the discardReceiver)
    @Override
    public void execute() {
        discardReceiver.discard();
    }

}
