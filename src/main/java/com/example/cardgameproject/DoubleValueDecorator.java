package com.example.cardgameproject;

/**
 *
 * Filename:    DoubleValueDecorator.java
 * Purpose:     Card decorator that doubles the card's value for recipe matching.
 *              A card with value "F" becomes "FF" when decorated.
 *
 * Design Pattern: Concrete Decorator
 *
 * Use Case: Special card enhancement that makes cards more valuable for recipes
 *
 * Author:      [author]
 * Date:        [date]
 */

public class DoubleValueDecorator extends CardDecorator{
    // Constructor: wraps a card to double its value
    public DoubleValueDecorator(Card card) {
        super(card);
    }

    // Will return double the card's value because of the decorator
    @Override
    public String giveCardValue() {
        return(decoratedCard.giveCardValue() + decoratedCard.giveCardValue());
    }

}
