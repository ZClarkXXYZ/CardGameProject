package com.example.cardgameproject.decorator;
/**
 *  Filename:    CardInterface.java
 *  Purpose:     Defines the interface for all cards (base and decorated).
 *               Ensures cards can provide their value and trigger effects
 *               when played or discarded. Allows cards to be wrapped with additional functionality.
 *
 *  Design Pattern: Component interface in Decorator pattern
 *
 *  Implementers: Card (base), CardDecorator (wrapper for decorators)
 *
 *  Author: ZC
 */

public interface CardInterface {

    //Returns a card's value for recipe matching
    // Decorators can modify this
    String giveCardValue();

    //Triggers additional effects when the card is played
    // Base cards have no effects, decorated cards have added effects
    void additionalPlayedEffects();

    // Triggers any applicable effects a card may have from decorators
    // for when the card is discarded specifically
    void additionalDiscardEffects();

    //Gets the stored name of the CardInterface object
    String getCardName();
}
