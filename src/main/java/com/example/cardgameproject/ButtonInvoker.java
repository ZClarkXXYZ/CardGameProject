package com.example.cardgameproject;

public class ButtonInvoker {
    private ButtonCommand button;

    public void setCommand(ButtonCommand command) {
        this.button = command;
    }

    public void executeCommand() {
        if (button != null) {
            button.execute();
        }
    }
}
