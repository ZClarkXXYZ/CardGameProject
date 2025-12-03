package com.example.cardgameproject;

/**
 *  * Filename:    GameController.java
 *  * Purpose:     JavaFX controller that manages UI interactions for the main
 *  *              game screen. Handles button clicks and updates displays.
 *  *
 *  * FXML File: main.fxml
 *  *
 *  * Author:      [author]
 *  * Date:        [date]
 */

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
    private TextArea recipeTextArea; // Displays available recipes

    @FXML
    private FlowPane handFlowPane; // Container for hand cards

    @FXML
    private Button viewDeckButton; // Button to view full deck

    @FXML
    private ImageView playHandButton; // Button to play selected cards

    @FXML
    private ImageView discardButton; // Button to discard selected cards

    @FXML
    private Button viewUnitsButton;  // Button to view army units

    @FXML
    private FlowPane questFlowPane; // Container for quests

    @FXML
    private FlowPane shopFlowPane; // Container for shop


    // Initializes controller after FXML loads
    public void initialize(URL url, ResourceBundle resourceBundle) {



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

    }


    public void updateHand() {}

    public void updateRecipeShopArea() {}








}