package com.example.cardgameproject.command;

public class DiscardButtonCommand implements ButtonCommand{

    private DiscardReceiver discardReceiver = new DiscardReceiver();

    // Constructor - creates a discard command
    public DiscardButtonCommand(DiscardReceiver discardReceiver) {
        this.discardReceiver = discardReceiver;
    }


    //executes the discarding of selected card (through the discardReceiver)
    @Override
    public void execute() {
        discardReceiver.discard();
    }

}
