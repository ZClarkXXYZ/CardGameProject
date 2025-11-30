package com.example.cardgameproject;

public class PlayButtonCommand implements ButtonCommand {
    private PlayReceiver playReceiver;



    public PlayButtonCommand(PlayReceiver playReceiver) {
        this.playReceiver = playReceiver;
    }


    @Override
    public void execute() {
        playReceiver.playSelected();
    }
}