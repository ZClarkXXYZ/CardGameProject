package com.example.cardgameproject;

import java.util.ArrayList;
import java.util.List;

public class QuestGiver {
    UnitBuilder unitBuilder = new UnitBuilder();

    public List<Quest> getNextQuests(int round) {
        Army enemyArmy1 = new Army();
        Army enemyArmy2 = new Army();
        Army enemyArmy3 = new Army();
        List<Quest> quests = new ArrayList<Quest>();

        if (round == 1) {
            //quest 1-1
            unitBuilder.setBaseHP(7);
            unitBuilder.setAttack(4);
            unitBuilder.setName("Monkey");
            unitBuilder.setArmy(enemyArmy1);
            for (int i = 0; i < 3; i++) {
            enemyArmy1.addUnit(unitBuilder.build()); }
            quests.add(new Quest("Band of Monkeys \n 3x 4/7 Monkey", enemyArmy1, 7));

            //quest 1-2
            unitBuilder.setBaseHP(13);
            unitBuilder.setAttack(13);
            unitBuilder.setName("Troll");
            unitBuilder.setArmy(enemyArmy2);
            enemyArmy2.addUnit(unitBuilder.build());
            quests.add(new Quest("Troll \n 13/13 Troll", enemyArmy2, 13));

            //quest 1-3
            unitBuilder.setBaseHP(1);
            unitBuilder.setAttack(8);
            unitBuilder.setName("Glass Kannon");
            unitBuilder.setArmy(enemyArmy3);
            for (int i = 0; i < 8; i++) {
                enemyArmy3.addUnit(unitBuilder.build()); }
            quests.add(new Quest("Glass Kannons \n x8 8/1 Glass Kannon", enemyArmy3, 50));
            return(quests);
        }
        if (round == 2) {

        }
        if (round == 3) {

        }

        //final boss example
        unitBuilder.setBaseHP(100);
        unitBuilder.setAttack(20);
        unitBuilder.setName("Dragon");
        unitBuilder.setArmy(enemyArmy1);
        enemyArmy1.addUnit(unitBuilder.build());
        quests.add(new Quest("Final Boss, The Dragon! \n 20/100 Dragon", enemyArmy1, 100));
        return(quests);
     }

}
