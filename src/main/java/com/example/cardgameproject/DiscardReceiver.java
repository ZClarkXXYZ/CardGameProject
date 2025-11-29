package com.example.cardgameproject;
import java.util.List;

public class DiscardReceiver {
    private Hand hand;
    private GameModel game;

    public DiscardReceiver() {
        this.game = GameModel.getInstance();
        this.hand = game.getHandObject();
    }


    public void discard() {
        if (hand.getSelectedCards().size() == 0) {
            return;
        }
        discardSelected();
    }

    public void discardSelected(){
        List<Card> selectedCards = hand.getSelectedCards();
        for (int i = selectedCards.size() -1; i > 0; i--) {
            System.out.println("Discarded: " + selectedCards.get(i).getCardName());
            hand.removeCard(selectedCards.get(i));
        }
        hand.clearSelectedCards();
        game.drawHand();
    }
}
