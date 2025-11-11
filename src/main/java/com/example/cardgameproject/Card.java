package com.example.cardgameproject;

public class Card implements CardInterface{
    String cardCode;

    /*
     * CardCode: represents both the "value" of the card and what card effects it has
     * W : Wheat
     * F: Fire
     * S: Stone
     * L: Wood (leaf)
     * A: Water (Aqua)
     * C : Crystal
     *
     * Through decorators, the returned card value can be modified
     * WW: a double card, (this case, double wheat)
     * FFFF: a glass card, breaks after use
     * */

    @Override
    public String giveCardValue() {
        return(cardCode);
    }

    @Override
    public void additionalCardEffects() {
        //base effect does nothing
    }

}
