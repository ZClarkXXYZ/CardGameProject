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