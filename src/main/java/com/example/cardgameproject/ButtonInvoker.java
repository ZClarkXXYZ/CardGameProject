package com.example.cardgameproject;

/**
 *  * Filename:    ButtonInvoker.java
 *  * Purpose:     Invoker in the Command pattern. Holds a command and executes it
 *  *              when requested. Decouples UI buttons from their actions.
 *  *
 *  * Design Pattern: Command pattern - Invoker
 *  *
 *  * This class can be bound to UI buttons to execute different commands
 *  * without the button needing to know what the command does.
 *  *
 *  * Author:      [author]
 *  * Date:        [date]
 */

public class ButtonInvoker {
    private ButtonCommand button;   // the command to execute

    // sets the command to be executed
    public void setCommand(ButtonCommand command) {
        this.button = command;
    }

    // Executes command stored in the button if it has one
    public void executeCommand() {
        if (button != null) {
            button.execute();
        }
    }
}
