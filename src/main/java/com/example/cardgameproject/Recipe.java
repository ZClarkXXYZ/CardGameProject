package com.example.cardgameproject;

/**
 *  * Filename:    Recipe.java
 *  * Purpose:     Represents a crafting recipe that combines cards to create rewards.
 *  *              Recipes are checked when cards are played to determine if the
 *  *              player has created a valid combination.
 *  *
 *  * Recipe Code Format: (describes what cards are needed)
 *  *   Examples: "FFF" = 3 Fire cards, "WSG" = Water, Stone, Gold
 *  *
 *  * Reward Code Format: (describes what player receives)
 *  *   g[Number]        : Add gold (e.g., "g4" = +4 gold)
 *  *   c[CardCode]...   : Add cards (e.g., "cF" = add Fire card)
 *  *   m[ModifyCode]    : Modify deck (e.g., "m-glass-2" = make 2 cards glass)
 *  *   u[a/b/c]         : Give unit with a attack, b hp, c effect
 *  *
 *  * Author:      [author]
 *  * Date:        [date]
 */

public class Recipe {
    String recipeName;  // Display name: eg. Fire Sword
    String recipeCode;  // Card combination needed, ie. FFF
    String rewardCode;  // Reward to grant, ie. g4 = 4 gold

    /*
    * Reward Code: lowercase + extra values
    * g[Number] : +gold based on number
    * c[CardCode]...c[CardCode] : see CardCode in Card class, adds cards
    * m[ModifyCode] : modifies the deck in some way
    * u[a/b/c] : gives unit, with a/b stats, with c effect
    * */


    //Constructor - creates a recipe, with a name, requirements, and rewards
    Recipe(String recipeName, String recipeCode, String rewardCode) {
        this.recipeName = recipeName;
        this.recipeCode = recipeCode;
        this.rewardCode = rewardCode;
    }



}
