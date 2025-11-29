package com.example.cardgameproject;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.image.Image;
import javafx.scene.effect.*;
import javafx.scene.paint.Color;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.net.URL;
import java.util.List;
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

    GameModel game = GameModel.getInstance();


    public void initialize(URL url, ResourceBundle resourceBundle) {
        game.gameInitialize();

        viewDeckButton.setOnAction(Event -> {
            //view the deck
            showDeck();
        });

        playHandButton.setOnMouseClicked(Event -> {
            //play selected cards in hand
        });

        discardButton.setOnMouseClicked(Event -> {
            //discard selected cards in hand
            game.discardSelectedCards();
            updateHand();
        });

        viewUnitsButton.setOnAction(Event -> {
            //view units
        });

        overlayTextArea.setVisible(false);
        overlayTextArea.setOnMouseClicked(Event -> {
            overlayTextArea.setVisible(false);
        });

        updateHand();
        updateRecipeArea();
    }


    public void updateHand() {
        //update the hand
        handFlowPane.getChildren().clear(); //clear hand, add the card images

        List<Card> hand = game.getHand();
        Platform.runLater(() -> {for (int i = 0; i < hand.size(); i++) {
            handFlowPane.getChildren().add(getImageViewFromCard(hand.get(i), game.isCardSelected(hand.get(i))));
            //System.out.println(hand.get(i).cardName);
        }});
        //handFlowPane.requestLayout();

    }

    public void updateRecipeArea() {
        //update recipe area with able recipes
        String recipeText = "";
        List<Recipe> recipes = game.getRecipes();
        for (int i = 0; i < recipes.size(); i++) {
            recipeText = recipeText + recipes.get(i).getTextOfRecipe() + "\n";
        }
        System.out.println(recipeText);
        recipeTextArea.setText(recipeText);
    }
    public void updateShopArea() {
        //update each shop label with random shop item
    }
    public void updateQuestArea() {
        //update each quest label with random quest
    }
    public void showDeck() {
        String overlayText = "";
        overlayTextArea.setText(overlayText);
        //set text to current deck
        List<Card> deck = game.getDeck();
        for (int i = 0; i < deck.size(); i++) {
            overlayText = overlayText + deck.get(i).getCardName() + "\n";
        }
        overlayTextArea.setText(overlayText);
        overlayTextArea.setVisible(true);
    }

    public void showUnits() {
        overlayTextArea.setText("");
        //set text to current army
    }

    public ImageView getImageViewFromCard(Card card, boolean isSelected) {
        //add effects, and get correct card image
        ImageView cardImage = new ImageView();
        cardImage.setImage(new Image(Card.class.getResourceAsStream(getImageFromCard(card))));

        //toggle selected card on click
        cardImage.setOnMouseClicked(Event -> {
            game.selectCard(card);
            updateHand();
        });

        //card size
        cardImage.setFitHeight(80);
        cardImage.setFitWidth(80);
        /*image effects:
        All have dropshadow unless toggled
        double gets bloom effect:
        golden gets SepiaTone
        glass gets reflection
        */
        DropShadow dropshadow = new DropShadow();
        if (!(isSelected)) {
            dropshadow.setColor(Color.color(0,0,0));
        }
        else {
            dropshadow.setColor(Color.color(0.255, 0.255, 0));
        }
        dropshadow.setRadius(30);
        dropshadow.setWidth(30);
        dropshadow.setHeight(30);
        cardImage.setEffect(dropshadow);

        if (card.cardName.contains("Shiny")) {
            Bloom bloom = new Bloom();
            bloom.setThreshold(0);
            cardImage.setEffect(bloom);
        }
        if (card.cardName.contains("Golden")) {
            SepiaTone sepia = new SepiaTone();
            sepia.setLevel(1);
            cardImage.setEffect(sepia);
        }
        if (card.cardName.contains("Glass")) {
            Reflection reflection = new Reflection();
            reflection.setFraction(0.75);
            reflection.setBottomOpacity(0);
            reflection.setTopOpacity(0.5);
            cardImage.setEffect(reflection);
        }
        return(cardImage);
    }

    public String getImageFromCard(Card card) {
        if (card.cardName.contains("Wheat")) {
            return("images/cardWheat.png");
        }
        if (card.cardName.contains("Fire")) {
            return("images/cardFire.png");
        }
        if (card.cardName.contains("Water")) {
            return("images/cardWater.png");
        }
        if (card.cardName.contains("Wood")) {
            return("images/cardWood.png");
        }
        if (card.cardName.contains("Stone")) {
            return("images/cardStone.png");
        }
        if (card.cardName.contains("Crystal")) {
            return("images/cardCrystal.png");
        }
        return("images/cardGold.png");
    }
}