package com.example.cardgameproject;

/**
 *  * Filename:    CardInterface.java
 *  * Purpose:     Defines the interface for all cards (base and decorated).
 *  *              Ensures cards can provide their value and trigger effects
 *  *              when played or discarded.
 *  *
 *  * Design Pattern: Component interface in Decorator pattern
 *  *
 *  * Implementers: Card (base), CardDecorator (wrapper for decorators)
 *  *
 *  * Author:      [author]
 *  * Date:        [date]
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
}
