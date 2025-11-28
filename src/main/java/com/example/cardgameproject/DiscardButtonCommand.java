package com.example.cardgameproject;

public class DiscardButtonCommand implements ButtonCommand{


    private DiscardReceiver discardReceiver;


    private Card card;


    public DiscardButtonCommand(DiscardReceiver discardReceiver, Card card) {


        this.discardReceiver = discardReceiver;


        this.card = card;


    }



    @Override
    public void execute() {
        discardReceiver.discard(card);
    }

}
