package com.example.cardgameproject;

public class GoldenDecorator extends CardDecorator{
    //gives +2 gold when played. removes all gold when discarded
    public GoldenDecorator(Card card) {
        super(card);
    }

    @Override
    public void additionalPlayedEffects() {
        //GameModel.addResource('gold', 2) //Give +2 Gold // Not yet implemented
    }

    @Override
    public void additionalDiscardEffects() {
        //GameModel.setResource('gold', 0) // Remove all gold when discarded //Not yet implemented
    }

}
