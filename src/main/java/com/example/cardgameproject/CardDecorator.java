package com.example.cardgameproject;

public abstract class CardDecorator implements CardInterface{
    protected Card decoratedCard;

    public CardDecorator(Card card) {
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
}
