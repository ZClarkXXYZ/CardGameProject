package com.example.cardgameproject.command;

/**
 *  Filename:    ButtonInvoker.java
 *  Purpose:     Invoker in the Command pattern. Holds a command and executes it
 *               when requested. Decouples UI buttons from their actions.
 *
 *  Design Pattern: Command pattern - Invoker
 *
 *  Usage:
 *    ButtonInvoker invoker = new ButtonInvoker();
 *    invoker.setCommand(playCommand);
 *    invoker.executeCommand();
 *  This class can be bound to UI buttons to execute different commands
 *  without the button needing to know what the command does.
 *
 *  Author: Chris
 */

public class ButtonInvoker {
    private ButtonCommand button;



    public void setCommand(ButtonCommand command) {
        //
        this.button = command; // the command to execute

    }

    // Executes command stored in the button if it has one
    public void executeCommand() {
        //
        if (button != null) {
            button.execute();
        }

    }

}
