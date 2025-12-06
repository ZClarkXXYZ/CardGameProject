package com.example.cardgameproject.command;
import com.example.cardgameproject.singleton.GameModel;
import com.example.cardgameproject.Hand;
import com.example.cardgameproject.adapter.Recipe;
import com.example.cardgameproject.decorator.CardInterface;
import com.example.cardgameproject.observerAndBuilder.Unit;
import com.example.cardgameproject.observerAndBuilder.UnitBuilder;
import com.example.cardgameproject.observerAndBuilder.UnitBuilderInterface;

import java.util.List;

/**
 *  Filename:    PlayReceiver.java
 *  Purpose:     Receiver in the Command pattern. Contains the actual business
 *               logic for playing cards. Moves cards from hand to the played
 *               pile for recipe matching or other game mechanics.
 *
 *  Design Pattern: Command pattern - Receiver
 *
 *  The receiver knows how to play cards. Commands delegate to this class
 *  to perform the actual work. Playing cards typically triggers recipe
 *  checking and card effects.
 *
 *  Author: Chris (Design pattern), ZC (some slight tweaks to fit rest of project I think)
 */

public class PlayReceiver {
    private Hand hand; // player's hand
    private GameModel game;
    private List<Recipe> recipes; //List of recipes that determine what unit gets added to deck based on selected cards


    public PlayReceiver() {
        this.game = GameModel.getInstance();
        this.hand = game.getHandObject();
        this.recipes = game.getRecipes();


    }

    //Checks to see if there any cards selected
    public void play() {
        //fail-safe check
        if (hand.getSelectedCards().size() == 0) {
            return;
        }
        playSelected();
    }

    // Plays currently selected cards from hand
    public void playSelected() {
        List<CardInterface> selectedCards = hand.getSelectedCards();
        String recipeCode = "";
        for (int i = 0; i < selectedCards.size(); i++) {
            recipeCode = recipeCode + selectedCards.get(i).giveCardValue();
            selectedCards.get(i).additionalPlayedEffects();
        }
        //check each recipe to see if it matches selected cards
        //Add a unit of a matching recipe, or give a 1/1 if no match
        for (int i = 0; i < recipes.size(); i++) {
            if (recipes.get(i).compareCode(recipeCode)) {
                //add unit to play army from the recipe
                game.addUnitToArmy(recipes.get(i).completeRecipe());
                resetHand();
                return;
            }
        }
        //give default 1/1 unit to play army
        game.addUnitToArmy(giveDefaultUnit());
        resetHand();
    }


    //clear selected cards, clear hand, redraw
    public void resetHand() {
        hand.clearSelectedCards();
        hand.discardHand();
        game.drawHand();
    }

    // Calls the UnitBuilder through the Interface to build a default unit if you mess up a recipe
    public Unit giveDefaultUnit() {
        UnitBuilderInterface buildUnit = new UnitBuilder();
        buildUnit.setName("Oops");
        buildUnit.setAttack(1);
        buildUnit.setBaseHP(1);
        buildUnit.setAbility("n");
        return buildUnit.build();
    }

}


