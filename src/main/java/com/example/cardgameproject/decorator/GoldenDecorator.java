package com.example.cardgameproject.decorator;

import com.example.cardgameproject.singleton.GameModel;

/**
 * Filename:    GoldenDecorator.java
 * Purpose:     Concrete Card decorator that adds gold mechanics. Playing the card
 *               gives +2 gold, but discarding it removes ALL gold.
 *
 *  Design Pattern: Concrete Decorator
 *
 *
 *  Dependencies: Requires GameModel class with gold resource tracking
 *
 *  Author: ZC
 */

 // Constructor: wraps a card to add golden properties
public class GoldenDecorator extends CardDecorator{
    public GoldenDecorator(CardInterface card) {
        super(card);
    }


    //gives +3 gold when played
    @Override
    public void additionalPlayedEffects() {
        GameModel game = GameModel.getInstance();
        game.addGold(3);
    }


    //removes all gold when discarded
    @Override
    public void additionalDiscardEffects() {
        GameModel game = GameModel.getInstance();
        game.resetGold();
    }

    @Override
    public String getCardName() {
        return("Golden " + decoratedCard.getCardName());
    }

}
