package com.example.cardgameproject;

/**
 *  * Filename:    PlayButtonCommand.java
 *  * Purpose:     Concrete implementation of ButtonCommand for playing cards.
 *  *              Encapsulates the play action to be executed when the play
 *  *              button is clicked.
 *  *
 *  * Design Pattern: Command pattern - Concrete Command
 *  *
 *  * Usage:
 *  *   ButtonCommand playCmd = new PlayButtonCommand(receiver);
 *  *   invoker.setCommand(playCmd);
 *  *   invoker.executeCommand();  // Executes the play action
 *  *
 *  * Author:      [author]
 *  * Date:        [date]
 */

public class PlayButtonCommand implements ButtonCommand {
    private PlayReceiver playReceiver; // the object that performs the play action

    // Constructor : creates a play command w/ a receiver
    public PlayButtonCommand(PlayReceiver playReceiver) {
        this.playReceiver = playReceiver;
    }

    // Executes play command by delegating to the receiver
    // Plays currently selected cards from player's hand
    @Override
    public void execute() {
        playReceiver.playSelected();
    }
}
