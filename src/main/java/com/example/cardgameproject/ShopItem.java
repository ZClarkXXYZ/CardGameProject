package com.example.cardgameproject;

public class ShopItem {
    int goldCost;
    String description;
    String reward;


    public ShopItem(int goldCost, String description, String reward) {
        this.goldCost = goldCost;
        this.description = description;
        this.reward = reward;
    }

    public int getGoldCost() {
        return goldCost;
    }
    public String getDescription() {
        return description;
    }



    /*
    * rewardCode:
    * C:W, ect [card]
    * p,d [+1 play, +1 discard]
    * C:W[decorator] [gold: g, glass : s, shiny : y]
    * [decorator] [modify a card with effect]
    * +1/+1 [units in army gain +1/+1]
    * */

    public String getReward() {
        return reward;
    }
}
