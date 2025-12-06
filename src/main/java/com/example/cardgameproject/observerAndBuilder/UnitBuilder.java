package com.example.cardgameproject.observerAndBuilder;

/**
 * Filename:    UnitBuilder.java
 * Purpose:     Implements the Builder pattern for creating Unit objects.
 *              Provides a fluent interface for setting unit properties
 *              and handles validation and army registration.
 *              Implements UnitBuilderInterface for flexibility and extensibility.
 *
 * Design Pattern: Builder - simplifies complex Unit construction with method chaining
 *
 * Usage Example:
 *   Unit knight = new UnitBuilder()
 *                .setName("Knight")
 *                .setBaseHP(100)
 *                .setAttack(15)
 *                .setAbility("a")  // "n"=none, "a"=+attack, "b"=heal, "c"=+hp, "d"=double attack
 *                .setArmy(playerArmy)
 *                .build();
 *
 * Note: setAbility() takes ability codes, not descriptions.
 *       Units are automatically registered as observers if they have abilities.
 *
 * Author:      Jason (jlg-repo)
 */

public class UnitBuilder implements UnitBuilderInterface {

    // Base stats
    private String name;
    private int baseHP;
    private int attack;
    private String ability; // ability codes, ie. "a", "b", etc.
    private Army army;

    // Constructor: initializes builder with default values
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