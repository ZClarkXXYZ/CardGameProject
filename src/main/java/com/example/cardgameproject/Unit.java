package com.example.cardgameproject;

public class Unit implements Observer {
        private String name;
        private int baseHP;
        private int hp;
        private int attack;
        private String ability;
        private Army army;


    Unit(UnitBuilder builder) {
        // Extract data from the builder
        this.name = builder.getName();
        this.baseHP = builder.getBaseHP();
        this.hp = builder.getBaseHP();
        this.attack = builder.getAttack();
        this.ability = builder.getAbility();

    }

    public void setArmy(Army army) {
        this.army = army;
    }

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
            hp = baseHP;
        }
        else if (ability.equals("c")) {
            baseHP = baseHP + 1;
            hp = hp + 1;
        }
        else if (ability.equals("d")) {
            attack = attack*attack;
        }
    }

    public String getAbility() {
        return ability;
    }

    public void resetHealth() {
        hp = baseHP;
    }

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


