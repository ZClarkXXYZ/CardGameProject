package com.example.cardgameproject;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable{

    @FXML
    private TextArea recipeTextArea;

    @FXML
    private FlowPane handFlowPane;

    @FXML
    private Button viewDeckButton;

    @FXML
    private ImageView playHandButton;

    @FXML
    private ImageView discardButton;

    @FXML
    private Button viewUnitsButton;

    @FXML
    private FlowPane questFlowPane;

    @FXML
    private FlowPane shopFlowPane;

    @FXML
    private TextArea overlayTextArea;

    GameModel game = new GameModel();


    public void initialize(URL url, ResourceBundle resourceBundle) {
        game.gameInitialize();

        viewDeckButton.setOnAction(Event -> {
            //view the deck
        });

        playHandButton.setOnMouseClicked(Event -> {
            //play selected cards in hand
        });

        discardButton.setOnMouseClicked(Event -> {
            //discard selected cards in hand
        });

        viewUnitsButton.setOnAction(Event -> {
            //view units
        });

        overlayTextArea.setVisible(false);


    }


    public void updateHand() {
        //update the hand
    }
    public void updateRecipeArea() {
        //update recipe area with able recipes
    }
    public void updateShopArea() {
        //update each shop label with random shop item
    }
    public void updateQuestArea() {
        //update each quest label with random quest
    }
    public void showDeck() {
        overlayTextArea.setText("");
        //set text to current deck
    }
    public void showUnits() {
        overlayTextArea.setText("");
        //set text to current army
    }

    public void modifyCardImage() {
        //add effects, and get correct card image


        /*image effects:
        All have dropshadow
        double gets bloom effect:
        golden gets SepiaTone
        glass gets reflection
        */
    }
}