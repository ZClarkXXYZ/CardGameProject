package com.example.cardgameproject;

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
        return questDescription;
    }

    public Army getEnemyArmy() {
        return enemyArmy;
    }

    public int getGoldReward() {
        return goldReward;
    }
}
