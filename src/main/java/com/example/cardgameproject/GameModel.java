package com.example.cardgameproject;

import java.util.ArrayList;
import java.util.List;

public class GameModel {
    //This is the client class that connects to other classes to make a working game

    private Deck deck = new Deck();
    private Hand hand = new Hand();

    private Army army = new Army();

    private List<Recipe> recipes;

    private int handSize = 5;



    public void gameInitialize() {
        //Make starting deck
        makeStartingDeck();

        //ToDO
        //make starting army

        //Get list of recipes
        getPossibleRecipes();

    }





    public void drawHand(int handSize) {
        //draw X cards to hand from deck
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
