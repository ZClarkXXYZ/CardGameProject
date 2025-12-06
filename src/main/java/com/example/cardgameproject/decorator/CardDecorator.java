package com.example.cardgameproject.decorator;

/**
 * Filename:    CardDecorator.java
 * Purpose:     Abstract decorator class for cards. Wraps a CardInterface and delegates
 *              calls to it. Concrete decorators extend this to add behavior.
 *
 * Design Pattern: Decorator pattern - Abstract Decorator
 *
 * Usage:
 *   CardInterface card = new Card("W", "Wheat");
 *   CardInterface goldenCard = new GoldenDecorator(card);
 *
 * Author: ZC
 */

public abstract class CardDecorator implements CardInterface{
    protected CardInterface decoratedCard;

    public CardDecorator(CardInterface card) {
        this.decoratedCard = card;
    }

    @Override
    public String giveCardValue() {
        return decoratedCard.giveCardValue();
    }

    @Override
    public void additionalPlayedEffects() {decoratedCard.additionalPlayedEffects();};

    @Override
    public void additionalDiscardEffects() {decoratedCard.additionalDiscardEffects();};

    @Override
    public String getCardName() {return decoratedCard.getCardName();};
}
