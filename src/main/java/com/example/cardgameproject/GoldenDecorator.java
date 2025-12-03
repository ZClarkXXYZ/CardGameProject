package com.example.cardgameproject;

/**
 * * Filename:    GoldenDecorator.java
 *  * Purpose:     Card decorator that adds gold mechanics. Playing the card
 *  *              gives +2 gold, but discarding it removes ALL gold.
 *  *
 *  * Design Pattern: Concrete Decorator
 *  *
 *  * Risk/Reward: Powerful bonus for playing, but harsh penalty for discarding.
 *  *              Creates strategic decisions about when to use golden cards.
 *  *
 *  * Dependencies: Requires GameModel class with gold resource tracking
 *  *
 *  * Author:      [author]
 *  * Date:        [date]
 */

public class GoldenDecorator extends CardDecorator{
    // Constructor: wraps a card to add golden properties
    //gives +2 gold when played. removes all gold when discarded
    public GoldenDecorator(Card card) {
        super(card);
    }

    // When played, gives + 2 gold to player
    //TODO: Implement once GameModel is finished
    @Override
    public void additionalPlayedEffects() {
        //GameModel.addResource('gold', 2) //Give +2 Gold // Not yet implemented
    }

    // When discarded, removes all gold from the player
    //TODO: implement
    @Override
    public void additionalDiscardEffects() {
        //GameModel.setResource('gold', 0) // Remove all gold when discarded //Not yet implemented
    }

}
