package com.example.cardgameproject;

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
