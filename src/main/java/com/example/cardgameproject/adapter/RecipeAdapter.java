package com.example.cardgameproject.adapter;

/**
 *  Filename:    RecipeAdapter.java
 *  Purpose:     Adapter that reads recipe data from CSV files and converts
 *               them into Recipe objects for use in the game.
 *
 *  Design Pattern: Adapter - converts CSV data format to Recipe objects
 *  Author: ZC
 */

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter {
    //Takes entries from .cvs file and turns it into recipes to use
    private String cvsProducts = "recipe.csv";
    private FileReader fileReader;
    private String cvsAsString = "";
    private String[] splitString;
    int columns = 5; //columns are set, but rows are not.

    private List<Recipe> recipes= new ArrayList<>();

    public RecipeAdapter() {
        turnCSVFileToString();
        splitCVSString();
        turnSplitStringToRecipes();
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }


    //Take split string, turn into arraylist of Recipes
    private void turnSplitStringToRecipes() {
        for (int i = 0; i < splitString.length/columns; i++) {
            int j = i*columns;
            recipes.add(new Recipe(splitString[j], splitString[j+1], Integer.valueOf(splitString[j+2]),Integer.valueOf(splitString[j+3]), splitString[j+4]));
            //recipes.getLast().printRecipe();
        }
    }




    //Take the string, and turn it into an array
    private void splitCVSString() {
        splitString = cvsAsString.split(",|\n");

        /*for (int i = 0; i < splitString.length; ++i) { //Debug testing print
            System.out.println(splitString[i]);
        }*/
    }



    //Take a CVS, turn into string
    private void turnCSVFileToString() {
        try {
            this.fileReader = new FileReader(cvsProducts);
        } catch (Exception e) {
            System.out.println(e);
        }
        String nextChar;
        try {
            while (fileReader.ready()) {
                try {
                    nextChar = String.valueOf(Character.toChars(fileReader.read()));
                    cvsAsString = cvsAsString + nextChar;
                } catch (Exception e) {
                    System.out.println(e);
                    //
                }
            }
        }
        catch (Exception e) {System.out.println(e);}
        //System.out.println(cvsAsString); //Bug Testing Print
    }
}
