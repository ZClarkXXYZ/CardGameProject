package com.example.cardgameproject;

import java.util.ArrayList;
import java.util.List;

public class QuestGiver {

    private UnitBuilder unitBuilder = new UnitBuilder();
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
        String description = "";

        for (String[] row : enemyRows){
            String diff = row[0].trim();
            String type = row[1].trim();
            int atk = Integer.parseInt(row[2].trim());
            int hp = Integer.parseInt(row[3].trim());

            if (!diff.equals(difficulty)) {
                continue;
            }

            unitBuilder.setName(type)
                    .setAttack(atk)
                    .setBaseHP(hp)
                    .setArmy(army)
                    .build();

            description = "Quest: " + difficulty +
                    "\n Type: " + type +
                    "\n Attack/HP: " + atk + "/" + hp +
                    "\n Gold: " + gold;
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
}
