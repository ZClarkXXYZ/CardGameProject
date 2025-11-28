package com.example.cardgameproject;

public class GlassCardDecorator extends CardDecorator{
    //worth x4 for recipes, breaks after use
    public GlassCardDecorator(Card card) {
        super(card);
    }
    @Override
    public String giveCardValue() {
        return(decoratedCard.giveCardValue() + decoratedCard.giveCardValue() + decoratedCard.giveCardValue() + decoratedCard.giveCardValue());
    }

    @Override
    public void additionalPlayedEffects() {
        //Deck.removeThisCard(card); //Not yet implemented
    }

    @Override
    public String getCardName() {
        return("Glass " + decoratedCard.getCardName());
    }
}
