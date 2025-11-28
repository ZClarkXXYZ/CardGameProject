package com.example.cardgameproject;

public class DiscardReceiver {
    private Hand hand;
    private Deck discardPile;

    public DiscardReceiver(Hand hand, Deck discardPile) {
        this.hand = hand;
        this.discardPile = discardPile;
    }

    public void discard(Card card) {
        if (card == null) {
            return;
        }

        boolean discarded = hand.removeCard(card);
        if (discarded) {
            discardPile.addCard(card);
        }
    }

    public void discardSelected(){
        Card selected = hand.getSelectedCard();
        discard(selected);
    }
}
