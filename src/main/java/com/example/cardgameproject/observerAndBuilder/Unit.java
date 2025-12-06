package com.example.cardgameproject.observerAndBuilder;

/**
 * Filename:    Unit.java
 * Purpose:     Represents a combat unit with stats (HP, attack, abilities).
 *              Implements Observer pattern to react when ANY unit in army dies.
 *              Created using UnitBuilder.
 *
 * Design Patterns:
 *      - Observer: Units with abilities react to ANY death in their army
 *      - Builder: Units must be constructed using UnitBuilder
 *
 * Ability Codes:
 *      "n" = no ability
 *      "a" = when any unit dies, gain +1 attack
 *      "b" = when any unit dies, heal to full HP
 *      "c" = when any unit dies, gain +1 base HP and +1 current HP
 *      "d" = when any unit dies, double attack power
 *
 * Note: Units react to ANY death in army, not specific deaths. The update()
 *       method is called with no parameters when any unit dies.
 *
 * Author:      Chris, Jason (jlg-repo)
 */

public class Unit implements Observer {
        // Core stats
        private String name;
        private int baseHP;
        private int hp;
        private int attack;
        private String ability;
        private Army army;

    // Constructor - units must be created via unit builder
    Unit(UnitBuilder builder) {
        // Extract data from the builder
        this.name = builder.getName();
        this.baseHP = builder.getBaseHP();
        this.hp = builder.getBaseHP();
        this.attack = builder.getAttack();
        this.ability = builder.getAbility();

    }
    // Sets this unit's army (used by Army.addUnit or UnitBuilder
    public void setArmy(Army army) {
        this.army = army;
    }

    // Observer: called when any unit in army dies
    @Override
    public void update(){
        useAbility();
    }

    /*
    n (none)
    a (when unit dies, get +1 attack)
    b (when unit dies, heal to full)
    c (when unit dies, get +1 base hp, +1 hp
    d (when unit dies, double attack)
     */
    public void useAbility() {
        if (ability.equals("a")) {
            attack = attack+1;
        }
        else if (ability.equals("b")) {
            hp = baseHP; // restore full health
        }
        else if (ability.equals("c")) {
            baseHP = baseHP + 1; // Permanent HP increase
            hp = hp + 1;
        }
        else if (ability.equals("d")) {
            attack = attack*attack; // double attack
        }
    }

    public String getAbility() {
        return ability;
    }

    // reset HP to base value (used after battle ends)
    public void resetHealth() {
        hp = baseHP;
    }

    // Handle unit death output and list
    public void death(){
        System.out.println(name + " died.");
        if (army != null){
            army.unitDeath(this);
        }
    }

    //from shop item
    public void buffUnit(int i) {
        baseHP = baseHP + 1;
        hp = hp + 1;
        attack = attack + 1;
    }


    //methods for BattleManager system
    public String getName() {
        return name;
    }
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


