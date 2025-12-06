package com.example.cardgameproject;

/**
 * Filename:    UnitBuilder.java
 * Purpose:     Implements the Builder pattern for creating Unit objects.
 *              Provides a fluent interface for setting unit properties
 *              and handles validation and army registration.
 *
 * Design Pattern:
 * - Builder: simplifies complex Unit construction
 *
 *
 * Usage Example:
 * Unit knight = new UnitBuilder()
 *              .setName("Knight")
 *              .setBaseHP(100)
 *              .setAttack(15)
 *              .setArmy(playerArmy)
 *              .build();
 *
 * Author:      [jlg-repo]
 * Date:        [11/28/2025]
 */

public class UnitBuilder {
    // Builder fields - collect data before creating Unit
    private String name;
    private int baseHP;
    private int attack;
    private String ability;
    private String onDeath;
    private Army army;

    //Constructor: initializes builder with defaults

    public UnitBuilder() {
        this.baseHP = 1;
        this.attack = 0;
        this.ability = "";
        this.onDeath = "";
        this.army = null;

    }

    //Setter methods

    // Name
    public UnitBuilder setName(String name) {
        this.name = name;
        return this;
    }

    //BaseHP
    public UnitBuilder setBaseHP(int baseHP) {
        this.baseHP = baseHP;
        return this;
    }

    //Attack power
    public UnitBuilder setAttack(int attack) {
        this.attack = attack;
        return this;
    }

    //Abilities (if any)
    public UnitBuilder setAbility(String ability) {
        this.ability = ability;
        return this;
    }

    // Set an on death effect (if any)
    public UnitBuilder setOnDeath(String onDeath) {
        this.onDeath = onDeath;
        return this;
    }

    //Set the army this unit belongs to
    public UnitBuilder setArmy(Army army) {
        this.army = army;
        return this;

    }

    //Build method
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
    public String getName() {return name;}
    public int getBaseHP() {return baseHP;}
    public int getAttack(){return attack;}
    public String getAbility() {return ability;}
    public String getOnDeath() {return onDeath;}
    public Army getArmy() {return army;}


}