package com.example.cardgameproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shop {
    List<ShopItem> shopItems = new ArrayList<>();
    GameModel game = GameModel.getInstance();
    Random random = new Random();


    public void restockShop() {
        shopItems.clear();
        makeShopItem1();
        makeShopItem2();
        makeShopItem3();
        makeShopItem4();
    }

    public List<ShopItem> getShopItems() {
        return shopItems;
    }


    //generate a card
    private void makeShopItem1() {
        int baseCost = 2;
        int a = random.nextInt(5);

        if (a == 0) { //wheat
            shopItems.add(new ShopItem(baseCost, "Wheat Card", "W"));
        }
        if (a == 1) { //stone
            shopItems.add(new ShopItem(baseCost, "Stone Card", "S"));
        }
        if (a == 2) {//fire
            shopItems.add(new ShopItem(baseCost+1, "Fire Card", "F"));
        }
        if (a == 3) {//water
            shopItems.add(new ShopItem(baseCost+1, "Water Card", "A"));
        }
        if (a == 4) { //wood
            shopItems.add(new ShopItem(baseCost, "Wood Card", "L"));
        }
    }


    private String getAddedEffect(int b){
        if (b == 0) {
            return("g"); //gold
        }
        if (b == 1) {
            return("s"); //glass
        }
        if (b == 2) {
            return("y"); //shiny
        }
        return("");

    }
    private String getAddedDescription(int b){
        if (b == 0) {
            return("Golden "); //gold
        }
        if (b == 1) {
            return("Glass "); //glass
        }
        if (b == 2) {
            return("Shiny "); //shiny
        }
        return("");

    }


    //decorated card, decorate a card
    private void makeShopItem2() {
        int baseCost = 6;
        int a = random.nextInt(6);
        int b = random.nextInt(3);

        String addedEffect = getAddedEffect(b);
        String addedDescription = getAddedDescription(b);

        if (a == 0) { //wheat
            shopItems.add(new ShopItem(baseCost, addedDescription + "Wheat Card", "W" + addedEffect));
        }
        if (a == 1) { //stone
            shopItems.add(new ShopItem(baseCost, addedDescription + "Stone Card", "S" + addedEffect));
        }
        if (a == 2) {//fire
            shopItems.add(new ShopItem(baseCost+1, addedDescription + "Fire Card", "F" + addedEffect));
        }
        if (a == 3) {//water
            shopItems.add(new ShopItem(baseCost+1, addedDescription + "Water Card", "A" + addedEffect));
        }
        if (a == 4) { //wood
            shopItems.add(new ShopItem(baseCost, addedDescription + "Wood Card", "L" + addedEffect));
        }
        if (a == 5) { //crystal
            shopItems.add(new ShopItem(baseCost, "Crystal Card", "C"));
        }
    }

    //generate a +1 play or +1 discard
    private void makeShopItem3() {
        int baseCost = 3;
        int a = random.nextInt(2);
        if (a == 0) { //play
            shopItems.add(new ShopItem(baseCost + 3, "+1 Play", "p"));
        }
        if (a == 1) { //discard
            shopItems.add(new ShopItem(baseCost, "+1 Discard", "d"));
        }

    }

    private void makeShopItem4() {
        int baseCost = 5;
        shopItems.add(new ShopItem(baseCost, "+1/+1 to units", "1"));
    }


    /*
     * rewardCode:
     * W, ect [card]
     * p,d [+1 play, +1 discard]
     * W[decorator] [gold: g, glass : s, shiny : y]
     * [decorator] [modify a card with effect]
     * +1/+1 [units in army gain +1/+1]
     * */
    public void resolveReward(String rewardCode) {
        if (rewardCode.equals("1")) {
            game.buffAllUnits();
        }
        else if (rewardCode.equals("p")) {
            game.increaseMaxPlays();
        }
        else if (rewardCode.equals("d")) {
            game.increseeMaxDiscards();
        }
        else if (rewardCode.equals("d")) {
            game.increseeMaxDiscards();
        }

        else {
            String cardString = String.valueOf(rewardCode.charAt(0));
            CardInterface card = new Card(cardString, game.getCardNameFromCode(cardString));
            String decoratorString = "";
            if (rewardCode.length() > 1) {
                decoratorString = String.valueOf(rewardCode.charAt(1));
                if (decoratorString.equals("g")) {
                    card = new GoldenDecorator(card);
                }
                if (decoratorString.equals("s")) {

                }
                if (decoratorString.equals("y")) {

                }
            }
            game.addCardToDeck(card);
        }
    }

}
