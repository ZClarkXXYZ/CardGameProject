package com.example.cardgameproject;

/**
 * Filename:    ShopItem.java
 * Purpose:     Represents an item available for purchase in the shop.
 *              Contains cost, description, and reward code for Shop to parse.
 *
 * Design Pattern: None - data class
 *
 * Reward Code Examples:
 * - "W" = Wheat card
 * - "Wg" = Golden wheat card
 * - "p" = +1 play
 * - "1" = +1/+1 to all units
 *
 * Author:      ZC, jlg-repo (docs)
 * Date:        12/2024
 */

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
        return (description + " \n cost: " + goldCost);
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
