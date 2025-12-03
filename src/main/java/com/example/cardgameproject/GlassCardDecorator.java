package com.example.cardgameproject;

/**
 *  * Filename:    GlassCardDecorator.java
 *  * Purpose:     Card decorator that quadruples card value for recipes but
 *  *              destroys the card after one use (removed from deck).
 *  *
 *  * Design Pattern: Concrete Decorator
 *  *
 *  * Mechanics:
 *  *   - 4x value makes it very powerful for completing recipes
 *  *   - One-time use adds strategic risk (permanent loss)
 *  *   - "Glass" theme represents fragility
 *  *
 *  * Dependencies: Requires Deck.removeThisCard() method
 *  *
 *  * Author:      [author]
 *  * Date:        [date]
 */

public class GlassCardDecorator extends CardDecorator{
    // Constructor: Wraps the card to make it glass (high value, breaks)
    //worth x4 for recipes, breaks after use
    public GlassCardDecorator(Card card) {
        super(card);
    }
    // Decorator method that returns 4x the card value
    @Override
    public String giveCardValue() {
        return(decoratedCard.giveCardValue() + decoratedCard.giveCardValue() + decoratedCard.giveCardValue() + decoratedCard.giveCardValue());
    }

    // When played, removes card from the deck
    //TODO: Implement
    @Override
    public void additionalPlayedEffects() {
        //Deck.removeThisCard(card); //Not yet implemented
    }
}
