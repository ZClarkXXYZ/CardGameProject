package com.example.cardgameproject;

/**
 * Filename:        ButtonCommand.java
 * Purpose:         Command interface for button actions. part of Command pattern that separates
 *                  button clicks from their actions.
 *
 * Design Pattern:  Command pattern interface
 *
 * Author:      [author]
 * Date:        [date]
 *
 */

// Executes command action
public interface ButtonCommand {
    void execute();
}
