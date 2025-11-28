package com.example.cardgameproject;

public class GoldenDecorator extends CardDecorator{
    //gives +3 gold when played. removes all gold when discarded
    public GoldenDecorator(Card card) {
        super(card);
    }

    @Override
    public void additionalPlayedEffects() {
        GameModel game = GameModel.getInstance();
        game.addGold(3);
    }

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
