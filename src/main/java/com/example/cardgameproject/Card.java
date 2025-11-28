package com.example.cardgameproject;

public class Card implements CardInterface{
    String cardCode;
    String cardName;
    /*CardCode: represents both the "value" of the card
    W : Wheat
    F: Fire
    S: Stone
    L: Wood (leaf)
    A: Water (Aqua)
    C : Crystal */

    //constructor
    public Card(String cardCode, String cardName) {
        this.cardCode = cardCode;
        this.cardName = cardName;
    }


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

    @Override
    public String getCardName() {
        return(cardName);
    }

}
