package com.example.cardgameproject;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.image.Image;
import javafx.scene.effect.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GameController implements Initializable{

    @FXML
    private VBox mainVBox;
    @FXML
    private VBox questVBox;
    @FXML
    private VBox shopVBox;

    @FXML
    private VBox selectDeckVBox;
    @FXML
    private Button deckButton1;
    @FXML
    private Button deckButton2;
    @FXML
    private Button deckButton3;


    @FXML
    private TextArea recipeTextArea;

    @FXML
    private FlowPane handFlowPane;

    @FXML
    private TextArea resultTextArea;

    @FXML
    private Button viewDeckButton;

    @FXML
    private ImageView playHandButton;

    @FXML
    private ImageView discardButton;

    @FXML
    private Button viewUnitsButton;

    @FXML
    private Button exitShopButton;

    @FXML
    private FlowPane questFlowPane;

    @FXML
    private FlowPane shopFlowPane;

    @FXML
    private TextArea overlayTextArea;

    @FXML
    private Label goldLabel;

    @FXML
    private Label discardsLabel;

    @FXML
    private Label playsLabel;

    GameModel game = GameModel.getInstance();


    public void initialize(URL url, ResourceBundle resourceBundle) {
        overlayTextArea.setVisible(true);
        overlayTextArea.setText("Choose Starting Deck");
        selectDeckVBox.setVisible(true);


        viewDeckButton.setOnAction(Event -> {
            //view the deck
            showDeck();
        });

        playHandButton.setOnMouseClicked(Event -> {
            //play selected cards in hand
            game.playSelectedCards();
            updatePlaysAndDiscards();
            updateHand();
        });

        discardButton.setOnMouseClicked(Event -> {
            //discard selected cards in hand
            game.discardSelectedCards();
            updatePlaysAndDiscards();
            updateHand();
        });

        viewUnitsButton.setOnAction(Event -> {
            //view units
            showUnits();
        });

        overlayTextArea.setOnMouseClicked(Event -> {
            overlayTextArea.setVisible(false);
        });

        resultTextArea.setOnMouseClicked(Event -> {
            if (resultTextArea.getText().equals("Quest Complete!")) {
                game.resetUnits();
                switchToShop();
            }
            else {
                System.out.println("Game restarted");
                initialize(url, resourceBundle);
            }
            resultTextArea.setVisible(false);
        });

        exitShopButton.setOnAction(Event -> {
            switchToMain();
        });
        deckButton1.setOnAction(Event -> {
            selectDeckVBox.setVisible(false);
            startGame(1);
        });
        deckButton2.setOnAction(Event -> {
            selectDeckVBox.setVisible(false);
            startGame(2);
        });
        deckButton3.setOnAction(Event -> {
            selectDeckVBox.setVisible(false);
            startGame(3);
        });

        }
    public void startGame(int chosenDeck) {
        overlayTextArea.setVisible(false);
        game.gameInitialize(chosenDeck);
        switchToMain();
        updateRecipeArea();
    }

    public void updateHand() {
        //update the hand
        handFlowPane.getChildren().clear(); //clear hand, add the card images

        List<CardInterface> hand = game.getHand();
        Platform.runLater(() -> {for (int i = 0; i < hand.size(); i++) {
            handFlowPane.getChildren().add(getImageViewFromCard(hand.get(i), game.isCardSelected(hand.get(i))));
            //System.out.println(hand.get(i).cardName);
        }});
    }

    public void switchToMain() {
        shopVBox.setVisible(false);
        questVBox.setVisible(false);
        mainVBox.setVisible(true);
        discardsLabel.setVisible(true);
        playsLabel.setVisible(true);
        game.resetMain();
        updateHand();
        updatePlaysAndDiscards();
    }

    public void switchToQuest(){
        mainVBox.setVisible(false);
        questVBox.setVisible(true);
        discardsLabel.setVisible(false);
        playsLabel.setVisible(false);
        updateQuestArea();
    }

    public void switchToShop() {
        questVBox.setVisible(false);
        shopVBox.setVisible(true);
        updateShopArea();
    }

    public void updatePlaysAndDiscards() {
        if (game.getPlaysLeft() == 0) {
            //change to the quest scene
            switchToQuest();
        }
        discardsLabel.setText("Discards left: " + game.getDiscardsLeft());
        playsLabel.setText("Plays left: " + game.getPlaysLeft());

    }


    public void updateRecipeArea() {
        //update recipe area with able recipes
        String recipeText = "Instructions: \n" +
                "Play a hand of up to 5 cards matching a recipe from below. \n" +
                "Glass cards are worth 4x the number of resources. \n" +
                "Be careful! Not matching a recipe will result in a 1/1 creation! \n" +
                "\n" +
                "Recipes: \n";
        List<Recipe> recipes = game.getRecipes();
        for (int i = 0; i < recipes.size(); i++) {
            recipeText = recipeText + recipes.get(i).getTextOfRecipe() + "\n";
        }
        System.out.println(recipeText);
        recipeTextArea.setText(recipeText);
    }
    public void updateShopArea() {
        updateGoldLabel();
        //update each shop label with random shop items
        game.restockShop();
        Shop shop = game.getShop();
        shopFlowPane.getChildren().clear();
        for (int i = 0; i < shop.getShopItems().size(); i++) {
            ShopItem currentShopItem = shop.getShopItems().get(i);
            Button shopButton = new Button(currentShopItem.getDescription());
            shopButton.setPrefHeight(90);
            shopButton.setPrefWidth(164);
            shopButton.setOnAction(Event -> {
                if (game.buyShopItem(currentShopItem)) {
                    shopFlowPane.getChildren().remove(shopButton);
                    updateGoldLabel();
                }
            });
            shopFlowPane.getChildren().add(shopButton);
        }

    }
    public void updateGoldLabel() {
        goldLabel.setText("Gold: " + String.valueOf(game.getGold()));
    }

    public void updateQuestArea() {
        //update each quest label with ["random" (but not random really...)] quest
        List<Quest> quests = game.getNextQuests();
        questFlowPane.getChildren().clear();
        for (int i = 0; i < quests.size(); i++) {
            Button questButton = new Button(quests.get(i).getDescription());
            questButton.setPrefHeight(90);
            questButton.setPrefWidth(164);
            Quest currentQuest = quests.get(i);
            questButton.setOnAction(Event -> {
                game.setQuest(currentQuest);
                activateResultsScreen();
            });
            questFlowPane.getChildren().add(questButton);
        }
    }

    public void activateResultsScreen() {
        boolean result = game.activateQuest();
        String resultText = "";
        if (result) { //won the quest
            resultText = "Quest Complete!";
        }
        else {
            resultText = "Quest failed, Game Over!";
        }
        resultTextArea.setText(resultText);
        resultTextArea.setVisible(true);
    }

    public void showDeck() {
        String overlayText = "";
        overlayTextArea.setText(overlayText);
        //set text to current deck
        List<CardInterface> deck = game.getDeck();
        for (int i = 0; i < deck.size(); i++) {
            overlayText = overlayText + deck.get(i).getCardName() + "\n";
        }
        overlayTextArea.setText(overlayText);
        overlayTextArea.setVisible(true);
    }

    public void showUnits() {
        String overlayText = "";
        overlayTextArea.setText(overlayText);
        //set text to current army
        List<Unit> army = game.getArmy();
        for (int i = 0; i < army.size(); i++) {
            overlayText = overlayText + army.get(i).getName() + " " + army.get(i).getAttack() + "/" + army.get(i).getHP() +  "\n";
        }
        overlayTextArea.setText(overlayText);
        overlayTextArea.setVisible(true);
    }

    public ImageView getImageViewFromCard(CardInterface card, boolean isSelected) {
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

        if (card.getCardName().contains("Shiny")) {
            Bloom bloom = new Bloom();
            bloom.setThreshold(0);
            cardImage.setEffect(bloom);
        }
        if (card.getCardName().contains("Golden")) {
            SepiaTone sepia = new SepiaTone();
            sepia.setLevel(1);
            cardImage.setEffect(sepia);
        }
        if (card.getCardName().contains("Glass")) {
            Reflection reflection = new Reflection();
            reflection.setFraction(0.75);
            reflection.setBottomOpacity(0);
            reflection.setTopOpacity(0.5);
            cardImage.setEffect(reflection);
        }
        return(cardImage);
    }

    public String getImageFromCard(CardInterface card) {
        if (card.getCardName().contains("Wheat")) {
            return("images/cardWheat.png");
        }
        if (card.getCardName().contains("Fire")) {
            return("images/cardFire.png");
        }
        if (card.getCardName().contains("Water")) {
            return("images/cardWater.png");
        }
        if (card.getCardName().contains("Wood")) {
            return("images/cardWood.png");
        }
        if (card.getCardName().contains("Stone")) {
            return("images/cardStone.png");
        }
        if (card.getCardName().contains("Crystal")) {
            return("images/cardCrystal.png");
        }
        return("images/cardGold.png");
    }
}