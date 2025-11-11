package com.example.cardgameproject;

public class Recipe {
    String recipeName;
    String recipeCode;
    String rewardCode;

    /*
    * Reward Code: lowercase + extra values
    * g[Number] : +gold based on number
    * c[CardCode]...c[CardCode] : see CardCode in Card class, adds cards
    * m[ModifyCode] : modifies the deck in some way
    * u[a/b/c] : gives unit, with a/b stats, with c effect
    * */


    //Constructor
    Recipe(String recipeName, String recipeCode, String rewardCode) {
        this.recipeName = recipeName;
        this.recipeCode = recipeCode;
        this.rewardCode = rewardCode;
    }



}
