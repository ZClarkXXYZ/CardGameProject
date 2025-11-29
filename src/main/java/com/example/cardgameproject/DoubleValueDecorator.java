package com.example.cardgameproject;

public class DoubleValueDecorator extends CardDecorator{
    //worth x2 value for recipes
    public DoubleValueDecorator(CardInterface card) {
        super(card);
    }

    @Override
    public String giveCardValue() {
        return(decoratedCard.giveCardValue() + decoratedCard.giveCardValue());
    }

    @Override
    public String getCardName() {
        return("Shiny " + decoratedCard.getCardName());
    }
}
