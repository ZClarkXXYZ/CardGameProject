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
    Unit(UnitBuilder builder) {
        // Extract data from the builder
        this.name = builder.getName();
        this.baseHP = builder.getBaseHP();
        this.hp = builder.getBaseHP();
        this.attack = builder.getAttack();
        this.ability = builder.getAbility();
        this.onDeath = builder.getOnDeath();

        // hasOnDeath calculated from state of onDeath
        this.hasOnDeath = (onDeath != null & onDeath.length() > 0);

        this.army = builder.getArmy();
    }

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
