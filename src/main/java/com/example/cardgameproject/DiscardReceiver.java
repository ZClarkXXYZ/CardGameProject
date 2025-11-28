package com.example.cardgameproject;
import java.util.List;

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
        List<Card> selectedCards = hand.getSelectedCards();
        if (selectedCards.size() != 0) {
            for (int i = 0; i < selectedCards.size(); i++)
                System.out.print(i);
                //selectedCards.get(i).discard(selectedCards.get(i));
        }
    }
}
