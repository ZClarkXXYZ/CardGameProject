package com.example.cardgameproject;
import java.util.ArrayList;
import java.util.List;

public class PlayReceiver {
    private Hand hand;
    private GameModel game;
    private List<Recipe> recipes;


    public PlayReceiver() {
        this.game = GameModel.getInstance();
        this.hand = game.getHandObject();
        this.recipes = game.getRecipes();


    }


    public void play() {
        //fail-safe check
        if (hand.getSelectedCards().size() == 0) {
            return;
        }
        playSelected();
    }

    public void playSelected() {
        List<CardInterface> selectedCards = hand.getSelectedCards();
        String recipeCode = "";
        for (int i = 0; i < selectedCards.size(); i++) {
            recipeCode = recipeCode + selectedCards.get(i).giveCardValue();
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

    public Unit giveDefaultUnit() {
        UnitBuilderInterface buildUnit = new UnitBuilder();
        buildUnit.setName("Oops");
        buildUnit.setAttack(1);
        buildUnit.setBaseHP(1);
        buildUnit.setAbility("n");
        return buildUnit.build();
    }

}


