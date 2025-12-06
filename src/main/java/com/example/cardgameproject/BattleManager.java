package com.example.cardgameproject;

/**
 * Filename:    BattleManager.java
 * Purpose:     Manages turn-based combat between player and enemy armies.
 *              Randomly selects units to attack until one army is eliminated.
 *              Integrates with GameModel for battle logging.
 *
 * Design Pattern: None - utility class for battle logic
 *
 * Author:      Jason (jlg-repo)
 */

import com.example.cardgameproject.observerAndBuilder.Army;
import com.example.cardgameproject.observerAndBuilder.Unit;
import com.example.cardgameproject.singleton.GameModel;

public class BattleManager {
    public boolean fightArmy(Army playerArmy, Army enemyArmy) {
        GameModel game = GameModel.getInstance();
        // Battle will continue while both armies have units
        while (playerArmy.hasUnits() && enemyArmy.hasUnits()) {
            //Player turn
            Unit playerAttacker = playerArmy.getRandomUnit();
            Unit enemyDefender = enemyArmy.getRandomUnit();
            if (playerAttacker != null && enemyDefender != null) {
                int damage = playerAttacker.getAttack();
                enemyDefender.takeDamage(damage);
                // battle log
                //System.out.println(playerAttacker.getName() + " attacks " + enemyDefender.getName() + " for " + damage + " damage");
                game.battleLog(playerAttacker.getName() + " attacks " + enemyDefender.getName() + " for " + damage + " damage");
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
                //System.out.println(enemyAttacker.getName() + " attacks " + playerDefender.getName() + " for " + damage + " damage");
                game.battleLog(enemyAttacker.getName() + " attacks " + playerDefender.getName() + " for " + damage + " damage");
            }
            if (!playerArmy.hasUnits()) {
                return false; //player loses
            }
        }
        return playerArmy.hasUnits(); // final check
    }
}
