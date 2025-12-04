package com.example.cardgameproject.observerAndBuilder;

public interface UnitBuilderInterface {
    UnitBuilder setName(String name);

    UnitBuilder setBaseHP(int baseHP);

    UnitBuilder setAttack(int attack);

    UnitBuilder setAbility(String ability);

    UnitBuilder setArmy(Army army);

    Unit build();
}
