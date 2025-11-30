package com.example.cardgameproject;

/**
 * Filename: Unit.java
 * Purpose: Represents a combat unit with stats (HP, attack, abilities)
 *          Units participate in battles, can observe when other units die, and trigger
 *          special effects
 *
 * Design Patterns:
 *      - Observer: Units observe deaths to trigger on-death abilities
 *      - Builder: Units must be constructed using UnitBuilder
 *
 * Author: [author]
 * Date:   [date]
 *
 */

public class Unit implements Observer {
    // Core stats
    private String name;        // Display name of the unit
    private int baseHP;         // Starting HP before any modifiers
    private int hp;             // Current HP (dies when <= 0)
    private int attack;         // Damage dealt to enemies

    // Abilities
    private String ability;     // Special ability description
    private String onDeath;     // Effect that triggers when this unit dies
    private boolean hasOnDeath; // Boolean flag: does this unit have an on death effect?

    private Army army;          // The army this unit belongs to


    // Constructor - Units must be created via UnitBuilder
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

    // Change or set which army this unit belongs to
    public void setArmy(Army army) {
        this.army = army;
    }

    // Observer pattern: called when any unit in the army dies, updates the army list, checks effects, notifies observers
    @Override
    public void update(Unit deadUnit){
        if (!hasOnDeath) {return;}
        if (deadUnit != this){return;}

        System.out.println(name + " triggers their on-death ability: " + onDeath);

        // TODO: Check that on-death effects are executed
    }

    // Deletes a unit when it dies
    public void death(){
        System.out.println(name + " died.");
        if (army != null){
            army.unitDeath(this);
        }
    }

    // new methods for BattleManager system

    public String getName() {
        return name;
    }

    // Applies damage to unit, checks for death condition, triggers death
    public void takeDamage(int damage){
        this.hp -= damage;
        if (this.hp <= 0){
            death();
        }
    }

    public int getAttack() {return this.attack;}
    public int getHP() {return this.hp;}

    public boolean isAlive() {return this.hp > 0;}
}
