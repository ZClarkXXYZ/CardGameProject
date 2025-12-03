package com.example.cardgameproject;

/**
 *  * Filename:    Quest.java
 *  * Purpose:     Represents a quest/battle encounter. Quests define enemy armies
 *  *              to fight and rewards for victory. Players select quests to
 *  *              initiate battles.
 *  *
 *  * Quest Code Format: (describes enemy army composition)
 *  *   Format: "[count]x[attack]/[hp]-[name]"
 *  *   Example: "3x1/4-Goblin" = 3 Goblins with 1 attack and 4 HP each
 *  *   Multiple: "2x1/4-Goblin,1x5/10-Troll" = mixed enemy types
 *  *
 *  * Reward Code Format: (same as Recipe rewards)
 *  *   g[Number]   : Gold reward
 *  *   c[Code]     : Card reward
 *  *   m[Modify]   : Deck modification
 *  *   u[stats]    : Unit reward
 *  *
 *  * Author:      [author]
 *  * Date:        [date]
 */

public class Quest {
    String questDescription;    // Text description for the user
    String questCode;           // Enemy army composition code
    String rewardCode;          // Reward for completing quest
}
