package com.example.cardgameproject.command;

 /**
 * Filename:    ButtonCommand.java
 * Purpose:     Command pattern interface. Defines the contract for all button commands
 *              in the game (play, discard, etc.).
 *
 * Design Pattern: Command pattern interface
 *
 * Implementers: PlayButtonCommand, DiscardButtonCommand
 *
 * Author: Chris
 */

// Executes command action
public interface ButtonCommand {
    void execute();
}
