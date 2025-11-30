package com.example.cardgameproject;

public class DiscardButtonCommand implements ButtonCommand{
    private DiscardReceiver discardReceiver;

    public DiscardButtonCommand(DiscardReceiver discardReceiver) {
        this.discardReceiver = discardReceiver;
    }

    @Override
    public void execute() {
        discardReceiver.discardSelected();
    }
}
