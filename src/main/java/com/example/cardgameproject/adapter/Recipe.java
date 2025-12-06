package com.example.cardgameproject.adapter;

/**
 *  * Filename:    Recipe.java
 *  * Purpose:     Represents a crafting recipe that combines cards to create rewards.
 *  *              Recipes are checked when cards are played to determine if the
 *  *              player has created a valid combination.
 *  *
 *  * Recipe Code Format: (describes what cards are needed)
 *  *   Examples: "FFF" = 3 Fire cards, "WSG" = Water, Stone, Gold
 *  *
 *  * Reward Code Format: (describes what Unit player receives)
 *  *   [recipeCode / Name / a/b/c]   : Give unit with a attack, b hp, c effect
 *  *
 *  * Author: ZC
 */

import com.example.cardgameproject.observerAndBuilder.Unit;
import com.example.cardgameproject.observerAndBuilder.UnitBuilder;
import com.example.cardgameproject.observerAndBuilder.UnitBuilderInterface;

import java.util.Arrays;

public class Recipe {
    String recipeName; // Display name: [also the name of the unit that will be given from completing recipe]
    String recipeCode; // Card combination needed, ie. FFF

    //For building Unit
    int attack;
    int baseHP;
    String ability;

    /*
    * [recipeCode / Name / a/b/c] : gives unit, with a/b stats, with c effect
    * */
    //Constructor
    Recipe(String recipeCode, String recipeName, int attack, int hp, String ability) {
        this.recipeCode = recipeCode;
        this.recipeName = recipeName;

        this.baseHP = hp;
        this.attack = attack;
        this.ability = ability;
    }

    // give the unit from the recipe
    public Unit completeRecipe() {
        UnitBuilderInterface buildUnit = new UnitBuilder();
        buildUnit.setName(recipeName);
        buildUnit.setAttack(attack);
        buildUnit.setBaseHP(baseHP);
        buildUnit.setAbility(ability);
        return buildUnit.build();
    }

    public void printRecipe() {
        System.out.println("Code: " +recipeCode + "   Unit: " + recipeName + "   stats: " + baseHP + "/" + attack + "  ability: " + ability);
    }

    // checks if the code given is the same as the recipe (arranges the input string alphabetically)
    public boolean compareCode(String code) {
        char[] array = code.toCharArray();
        Arrays.sort(array);
        String sortedCode = new String(array);

        return(recipeCode.equals(sortedCode));
    }



    /*CardCode: represents both the "value" of the card
    W : Wheat
    F: Fire
    S: Stone
    L: Wood (leaf)
    A: Water (Aqua)
    C : Crystal */
    public String convertCodeToText(String code) {
        String returnString = "";
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == 'W') {
                returnString = returnString + "Wheat ";
            }
            if (code.charAt(i) == 'F') {
                returnString = returnString + "Fire ";
            }
            if (code.charAt(i) == 'S') {
                returnString = returnString + "Stone ";
            }
            if (code.charAt(i) == 'L') {
                returnString = returnString + "Wood ";
            }
            if (code.charAt(i) == 'A') {
                returnString = returnString + "Water ";
            }
            if (code.charAt(i) == 'C') {
                returnString = returnString + "Crystal ";
            }
        }
        return(returnString);
    }


    public String getTextOfRecipe() {
        return(convertCodeToText(this.recipeCode) + "   Unit: " + recipeName + "   stats: " + attack + "/" + baseHP);
    }
}
