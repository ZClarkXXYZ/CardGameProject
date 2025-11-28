package com.example.cardgameproject;

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



    //Take split string, turn into arraylist of Recipes
    private void turnSplitStringToRecipes() {
        for (int i = 0; i < splitString.length/columns; i = i + columns) {
            recipes.add(new Recipe(splitString[i], splitString[i+1], Integer.valueOf(splitString[i+2]),Integer.valueOf(splitString[i+3]), splitString[i+4]));
            recipes.getLast().printRecipe();
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
