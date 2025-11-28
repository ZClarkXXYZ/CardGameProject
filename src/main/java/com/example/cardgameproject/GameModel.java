package com.example.cardgameproject;

import java.util.ArrayList;
import java.util.List;

public class GameModel {
    //This is the client class that connects to other classes to make a working game

    private Deck deck = new Deck();
    private Hand hand = new Hand();

    private Army army = new Army();

    private List<Recipe> recipes;

    private int handSize;
    private int maxPlays;
    private int playsLeft;
    private int maxDiscards;
    private int discardsLeft;

    private int gold;



    public void gameInitialize() {
        //set starting variables
        handSize = 5;
        maxPlays = 3;
        maxDiscards = 2;

        discardsLeft = maxDiscards;
        playsLeft = maxPlays;

        gold = 0;

        //Make starting deck
        makeStartingDeck();

        //ToDO
        //make starting army

        //Get list of recipes
        getPossibleRecipes();

        drawHand();
    }





    public void drawHand() {
        //draw X cards to hand from deck
        for (int i = 0; i < handSize; i++) {
            hand.addCard(deck.drawCard());
        }
        hand.printHand(); //testing print
    };



    public void getPossibleRecipes() {
        RecipeAdapter adapter = new RecipeAdapter();
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

}
