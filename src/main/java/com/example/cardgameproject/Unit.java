package com.example.cardgameproject;

public class Unit implements Observer {
        private String name;
        private int baseHP;
        private int hp;
        private int attack;
        private String ability;
        private String onDeath;
        private boolean hasOnDeath;
        private Army army;

    //TODO: finish private constructor with builder code
    //private Unit(UnitBuilder builder) {}


    public void setArmy(Army army) {
        this.army = army;
    }




    @Override
    public void update(Unit deadUnit){
        if (!hasOnDeath) {return;}

        if (deadUnit != this){return;}

        System.out.println(name + " triggers their on-death ability: " + onDeath);
    }



    public void death(){
        System.out.println(name + " died.");
        if (army != null){
            army.unitDeath(this);
        }
    }

}


