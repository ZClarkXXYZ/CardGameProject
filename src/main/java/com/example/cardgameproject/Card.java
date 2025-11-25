package com.example.cardgameproject;

public class Card implements CardInterface{
    String cardCode;

    @Override
    public String giveCardValue() {
        return(cardCode);
    }

    @Override
    public void additionalPlayedEffects() {
        //base effect does nothing
    }

    @Override
    public void additionalDiscardEffects() {
        //base effect does nothing
    }

}
