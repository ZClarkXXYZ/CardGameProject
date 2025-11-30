package com.example.cardgameproject;

/**
 * Filename:    CardDecorator.java
 * Purpose:     Abstract base class for all card decorators.
 *              Wraps a Card and adds additional behavior or modifies existing behavior.
 *
 * Design Pattern: Decorator pattern - allows adding features to cards
 *
 * Current Decorators:
 *          - GoldenDecorator: Gives gold when played, removes all gold when discarded
 *          - GlassCardDecorator: 4x value for recipes, breaks after one use
 *          - DoubleValueDecorator: 2x value for recipes
 *
 * Author:      [author]
 * Date:        [date]
 *
 */

public abstract class CardDecorator implements CardInterface{
    protected Card decoratedCard;

    // Constructor for decorators
    public CardDecorator(Card card) {
        this.decoratedCard = card;
    }

    // A decoration method that gives a card a specified value
    @Override
    public String giveCardValue() {
        return decoratedCard.giveCardValue();
    }

    // Method to give a card additional effects when the card is played
    @Override
    public void additionalPlayedEffects() {decoratedCard.additionalPlayedEffects();};

    //Method to give the card additional effects when the card is discaarded
    @Override
    public void additionalDiscardEffects() {decoratedCard.additionalDiscardEffects();};
}
