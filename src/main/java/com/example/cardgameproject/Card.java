package com.example.cardgameproject;

/**
 * Filename:    Card.java
 * Purpose:     Base implementation of a resource card. Cards have a code representing their type
 *              and can be decorated with special properties (Golden, Glass, DoubleValue)
 *
 * Design Pattern: Component in Decorator pattern
 *
 * Card Code examples:
 *      F = Fire, W = Water, S = Strong, G = Gold, C = Crystal etc.
 *
 * Author:      [author]
 * Date:        [date]
 *
 */

public class Card implements CardInterface{
    String cardCode;    // Single character representing card type

    // Returns the card's value for recipe matching
    @Override
    public String giveCardValue() {
        return(cardCode);
    }

    // Additional effects when this card is played
    @Override
    public void additionalPlayedEffects() {
        //base effect does nothing, effects can be added with Decorator
    }


    @Override
    public void additionalDiscardEffects() {
        //base effect does nothing
    }

}
