package com.example.cardgameproject.adapter;

import com.example.cardgameproject.observerAndBuilder.Army;

public class Quest {
    String questDescription;
    Army enemyArmy;
    int goldReward;

    public Quest(String questDescription, Army army, int goldReward) {
        this.questDescription = questDescription;
        this.enemyArmy = army;
        this.goldReward = goldReward;
    }


    public String getDescription() {
        return (questDescription + " \n Reward: " + goldReward + " gold");
    }

    public Army getEnemyArmy() {
        return enemyArmy;
    }

    public int getGoldReward() {
        return goldReward;
    }
}
