package com.example.cardgameproject;

public interface UnitBuilderInterface {
    UnitBuilder setName(String name);

    UnitBuilder setBaseHP(int baseHP);

    UnitBuilder setAttack(int attack);

    UnitBuilder setAbility(String ability);

    UnitBuilder setOnDeath(String onDeath);

    UnitBuilder setArmy(Army army);

    Unit build();
}
