package com.example.cardgameproject;

public class Recipe {
    String recipeName;
    String recipeCode;

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
        return(convertCodeToText(this.recipeCode) + "   Unit: " + recipeName + "   stats: " + baseHP + "/" + attack);
    }
}
