package com.example.cardgameproject.decorator;

import com.example.cardgameproject.singleton.GameModel;

/**
 *  Filename:    GlassCardDecorator.java
 *  Purpose:     Card decorator that quadruples card value for recipes but
 *               destroys the card after one use (removed from deck).
 *
 *  Design Pattern: Decorator Pattern - Concrete Decorator
 *
 *  Mechanics:
 *    - 4x value makes it very powerful for completing recipes
 *    - One-time use adds strategic risk (permanent loss)
 *    - "Glass" theme represents fragility
 *
 *  Dependencies: Requires Deck.removeThisCard() method
 *  Author:      ZC
 */

public class GlassCardDecorator extends CardDecorator{
    //worth x4 for recipes, breaks after use
    public GlassCardDecorator(CardInterface card) {
        super(card);
    }
    @Override
    public String giveCardValue() {
        return(decoratedCard.giveCardValue() + decoratedCard.giveCardValue() + decoratedCard.giveCardValue() + decoratedCard.giveCardValue());
    }

    // When played, removes card from the deck
    @Override
    public void additionalPlayedEffects() {
        GameModel game = GameModel.getInstance();
        game.removeCardFromDeck(this);
    }

    @Override
    public String getCardName() {
        return("Glass " + decoratedCard.getCardName());
    }
}
