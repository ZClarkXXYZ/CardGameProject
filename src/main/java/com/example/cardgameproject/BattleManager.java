package com.example.cardgameproject;

/**
 * Filename:        BattleManager.java
 * Purpose:         Randomized battle system. Player and Enemy take turns attacking random units
 *                  until only one army is left.
 *
 * Design Pattern:  None, this is a battle backend.
 *
 * Author:          [jlg-repo]
 * Date:            [11/28/2025]
 *
 */

public class BattleManager {

    public boolean fightArmy(Army playerArmy, Army enemyArmy) {
        // Battle will continue while both armies have units
        while (playerArmy.hasUnits() && enemyArmy.hasUnits()) {

            //Player turn
            Unit playerAttacker = playerArmy.getRandomUnit();
            Unit enemyDefender = enemyArmy.getRandomUnit();

            if (playerAttacker != null && enemyDefender != null) {
                int damage = playerAttacker.getAttack();
                enemyDefender.takeDamage(damage);

                // battle log
                System.out.println(playerAttacker.getName() + " attacks " + enemyDefender.getName() + " for " + damage + " damage");
            }

            if (!enemyArmy.hasUnits()) {
                return true; //player wins
            }

            // enemy turn
            Unit enemyAttacker = enemyArmy.getRandomUnit();
            Unit playerDefender = playerArmy.getRandomUnit();

            if (enemyAttacker != null && playerDefender != null) {
                int damage = enemyAttacker.getAttack();
                playerDefender.takeDamage(damage);

                //combat log
                System.out.println(enemyAttacker.getName() + " attacks " + playerDefender.getName() + " for " + damage + " damage");
            }

            if (!playerArmy.hasUnits()) {
                return false; //player loses
            }

        }
        return playerArmy.hasUnits(); // final check
    }
}
