package com.example.cardgameproject;

public class UnitBuilder implements UnitBuilderInterface {
    private String name;
    private int baseHP;
    private int attack;
    private String ability;
    private Army army;

    public UnitBuilder() {
        this.baseHP = 1;
        this.attack = 0;
        this.ability = "";
        this.army = null;
        //some defaults

    }

    //Setter methods

    @Override
    public UnitBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public UnitBuilder setBaseHP(int baseHP) {
        this.baseHP = baseHP;
        return this;
    }

    @Override
    public UnitBuilder setAttack(int attack) {
        this.attack = attack;
        return this;
    }

    @Override
    public UnitBuilder setAbility(String ability) {
        this.ability = ability;
        return this;
    }


    @Override
    public UnitBuilder setArmy(Army army) {
        this.army = army;
        return this;

    }

    //Build method
    @Override
    public Unit build() {
        if (name == null || name.isEmpty()) {

            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (baseHP <= 0) {
            throw new IllegalArgumentException("Base HP must be positive");
        }
        if (attack < 0) {
            throw new IllegalArgumentException("Attack must be positive");
        }

        //Create the unit using its constructor
        Unit unit = new Unit(this);

        //Register unit with army
        if (army != null) {
            army.addUnit(unit);
            army.addObserver(unit); // Observer connection
            unit.setArmy(army); // So unit knows its army
        }
        return unit;
    }

    //Getter methods for Unit constructor
    public String getName() {
        return name;
    }

    public int getBaseHP() {
        return baseHP;
    }

    public int getAttack() {
        return attack;
    }

    public String getAbility() {
        return ability;
    }

}