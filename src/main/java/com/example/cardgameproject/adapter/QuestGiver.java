package com.example.cardgameproject.adapter;

/**
 * Filename:    QuestGiver.java
 * Purpose:     Generates quests by reading enemy data from CSV file (enemy.csv).
 *              Creates enemy armies with appropriate difficulty levels (EASY, MEDIUM, HARD).
 *              Uses CSVAdapter to read external data.
 *
 * Design Pattern: Adapter pattern - uses CSVAdapter to adapt file format
 *
 * CSV Format Expected:
 *   Difficulty,Type,Attack,HP
 *   EASY,Goblin,1,2
 *   MEDIUM,Orc,3,5
 *   HARD,Dragon,8,10
 *
 * Author:      ZC, Chris (modified into part of an adapter pattern)
 */

import com.example.cardgameproject.observerAndBuilder.Army;
import com.example.cardgameproject.observerAndBuilder.UnitBuilderInterface;
import com.example.cardgameproject.observerAndBuilder.UnitBuilder;

import java.util.ArrayList;
import java.util.List;

public class QuestGiver {

    private UnitBuilderInterface unitBuilder = new UnitBuilder();
    private CSVAdapter adapter = new CSVAdapter();
    private List<String[]> enemyRows;

    private int easyGold = 5;
    private int mediumGold = 13;
    private int hardGold = 50;

    public QuestGiver() {
        enemyRows = adapter.read("enemy.csv");
    }

    private Quest buildQuest(String difficulty, int gold) {
        Army army = new Army();
        int enemies = 0;
        String description = "Quest: " + difficulty +
                "\n Enemies: ";

        List<String[]> sameDiff = new ArrayList<>();
        for (String[] row : enemyRows) {
            if (row[0].trim().equals(difficulty)) {
                sameDiff.add(row);
            }
        }

        boolean[] used = new boolean[sameDiff.size()];
        java.util.Random rand = new java.util.Random();

        while (enemies < 3){
            int index = rand.nextInt(sameDiff.size());
            String[] row = sameDiff.get(index);
            String diff = row[0].trim();
            String type = row[1].trim();
            int atk = Integer.parseInt(row[2].trim());
            int hp = Integer.parseInt(row[3].trim());

            if (!diff.equals(difficulty)) {
                continue;
            }

            if (rand.nextInt(5) != 0) {
                continue;
            }

            unitBuilder.setName(type)
                    .setAttack(atk)
                    .setBaseHP(hp)
                    .setArmy(army)
                    .build();

            description += "\n -" + type + " (" + atk + "/" + hp + ")";

            enemies++;
            if (enemies < 3){
                continue;
            }
        }
        return new Quest(description, army, gold);
    }

    public List<Quest> getNextQuests(int round) {
        List<Quest> quests = new ArrayList<>();

        quests.add(buildQuest("EASY", easyGold));
        quests.add(buildQuest("MEDIUM", mediumGold));
        quests.add(buildQuest("HARD", hardGold));

        return quests;
    }





















     //old code
     /*
     * UnitBuilder unitBuilder = new UnitBuilder();

    public List<Quest> getNextQuests(int round) {
        Army enemyArmy1 = new Army();
        Army enemyArmy2 = new Army();
        Army enemyArmy3 = new Army();
        List<Quest> quests = new ArrayList<Quest>();

        if (round == 1) {
            //quest 1-1
            unitBuilder.setBaseHP(4);
            unitBuilder.setAttack(3);
            unitBuilder.setName("Monkey");
            unitBuilder.setArmy(enemyArmy1);
            for (int i = 0; i < 3; i++) {
            enemyArmy1.addUnit(unitBuilder.build()); }
            quests.add(new Quest("Band of Monkeys \n 3x 3/4 Monkey", enemyArmy1, 5));

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
     *
     *
     *
     *
     *
     *
     *
     *
     * */
}
