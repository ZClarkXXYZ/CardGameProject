package com.example.cardgameproject.decorator;

/**
 * Filename:    DoubleValueDecorator.java
 * Purpose:     Card decorator that doubles the card's value for recipe matching.
 *              A card with value "F" becomes "FF" when decorated. Known as "shiny cards" in the game.
 * Design Pattern: Concrete Decorator
 * Use Case: Special card enhancement that makes cards more valuable for recipes
 *
 * Author: ZC
 */

public class DoubleValueDecorator extends CardDecorator{


    //Constructor: wrap card to double the value
    public DoubleValueDecorator(CardInterface card) {
        super(card);
    }

    //retrns double the card's inital value before the decoration'
    @Override
    public String giveCardValue() {
        return(decoratedCard.giveCardValue() + decoratedCard.giveCardValue());
    }

    @Override
    public String getCardName() {
        return("Shiny " + decoratedCard.getCardName());
    }
}
