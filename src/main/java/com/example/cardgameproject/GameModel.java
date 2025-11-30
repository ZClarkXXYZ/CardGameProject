package com.example.cardgameproject;

import java.util.ArrayList;
import java.util.List;

public class GameModel {
    //This is the client class that connects to other classes to make a working game

    //private static instance of GameModel
    private static GameModel game;

    private GameModel() {
        //do nothing
    }
    public static GameModel getInstance() {
        if (game == null) {
            game = new GameModel();
        }
        return(game);
    }


    private Deck deck = new Deck();
    private Hand hand = new Hand();

    private Army army = new Army();

    private List<Recipe> recipes;

    private Quest quest;
    private QuestGiver questGiver= new QuestGiver();

    private int handSize;
    private int maxPlays;
    private int playsLeft;
    private int maxDiscards;
    private int discardsLeft;

    private int gold;
    private int round;

    private ButtonInvoker buttonInvoker = new ButtonInvoker();


    public void gameInitialize() {
        //set starting variables
        handSize = 5;
        maxPlays = 3;
        maxDiscards = 2;

        discardsLeft = maxDiscards;
        playsLeft = maxPlays;

        gold = 0;
        round = 1;

        //Make starting deck
        makeStartingDeck();

        //make starting army
        makeStartingArmy();

        //Get list of recipes
        intializeRecipes();

        drawHand();
    }


    public void drawHand() {
        //draw X cards to hand from deck
        while (hand.getHand().size() < handSize) {
            hand.addCard(deck.drawCard());
        }
        //hand.printHand(); //testing print
    }


    public List<CardInterface> getHand() {
        return(hand.getHand());
    }

    public Hand getHandObject() {
        return(hand);
    }

    public boolean isCardSelected(CardInterface card) {
        return(hand.isSelected(card));
    }

    public void selectCard(CardInterface card) {
        hand.toggleSelectedCard(card);
        System.out.println("Toggled: " + card.getCardName());
    }

    public void playSelectedCards() {
        System.out.println("Play!!");
        if (playsLeft > 0 && hand.getSelectedCards().size() != 0) {
            playsLeft = playsLeft - 1;

            buttonInvoker.setCommand(new PlayButtonCommand(new PlayReceiver()));
            buttonInvoker.executeCommand();
        }
    }

    public void discardSelectedCards() {
        System.out.println("Discard!!");
        if (discardsLeft > 0 && hand.getSelectedCards().size() != 0) {
            discardsLeft = discardsLeft - 1;

            buttonInvoker.setCommand(new DiscardButtonCommand(new DiscardReceiver()));
            buttonInvoker.executeCommand();
        }
    }

    public void intializeRecipes() {
        RecipeAdapter adapter = new RecipeAdapter();
        recipes = adapter.getRecipes();
    }
    public List<Recipe> getRecipes() {
        return(recipes);
    }

    public void resetMain() {
        discardsLeft = maxDiscards;
        playsLeft = maxPlays;
        for (Unit unit : army.getArmy()) {
            unit.resetHealth();
        }
    }


    public List<CardInterface> getDeck() {
        return(deck.getDeck());
    }

    public List<Unit> getArmy() {
        return(army.getArmy());
    }


    public void makeStartingDeck() {
        for (int i = 0; i < 4; i++)
            deck.addCard(new Card("W", "Wheat"));
        for (int i = 0; i < 3; i++) {
            deck.addCard(new Card("S", "Stone"));
        }
        for (int i = 0; i < 2; i++) {
            deck.addCard(new Card("L", "Wood"));
        }
        for (int i = 0; i < 1; i++) {
            deck.addCard(new Card("F", "Fire"));
        }
        for (int i = 0; i < 1; i++) {
            deck.addCard(new Card("A", "Water"));
        }
        deck.shuffleDeck();
    }

    public void makeStartingArmy() {
        UnitBuilderInterface builder = new UnitBuilder();
        builder.setName("Man");
        builder.setAttack(2);
        builder.setBaseHP(2);
        builder.setAbility("n");
        army.addUnit(builder.build());
        army.addUnit(builder.build());
        army.addUnit(builder.build());
    }

    public void addGold(int moreGold) {
        gold = gold + moreGold;
    }
    public void resetGold() {
        gold = 0;
    }
    public int getGold() {
        return gold;
    }

    public int getPlaysLeft() {
        return playsLeft;
    }

    public int getDiscardsLeft() {
        return discardsLeft;
    }

    public void removeCardFromDeck(CardInterface card) {
        deck.removeCard(card);
    }

    public void buffAllUnits() {
        army.buffAllUnits();
    }

    public void increaseMaxPlays() {
        maxPlays = maxPlays + 1;
    }
    public void increaseMaxDiscards() {
        maxDiscards = maxDiscards + 1;
    }

    public void increaseHandSize() {
        handSize = handSize + 1;
    }

    public void addCardToDeck(CardInterface card) {
        deck.addCard(card);
    }

    public void addUnitToArmy(Unit unit) {
        army.addUnit(unit);
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public List<Quest> getNextQuests() {
        return questGiver.getNextQuests(round);
    }

    public boolean activateQuest() {
        return true;
    }

    public String getCardNameFromCode(String code) {
        if (code.equals("W")) {
            return("Wheat");
        }
        if (code.equals("S")) {
            return("Stone");
        }
        if (code.equals("F")) {
            return("Fire");
        }
        if (code.equals("A")) {
            return("Water");
        }
        if (code.equals("C")) {
            return("Crystal");
        }
        if (code.equals("L")) {
            return("Wood");
        }
        return "";
    }
}
