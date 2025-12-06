package com.example.cardgameproject.observerAndBuilder;
/**
 * Filename:    UnitBuilderInterface.java
 * Purpose:     Defines the interface for UnitBuilder, allowing for multiple
 *              builder implementations if needed in the future. Ensures all
 *              builders provide consistent interface methods.
 *
 * Design Pattern: Builder pattern interface
 *
 * Methods: All methods return UnitBuilder for method chaining (fluent interface)
 *
 * Author:      Jason (jlg-repo)
 */

public interface UnitBuilderInterface {
    UnitBuilder setName(String name);

    UnitBuilder setBaseHP(int baseHP);

    UnitBuilder setAttack(int attack);

    UnitBuilder setAbility(String ability);

    UnitBuilder setArmy(Army army);

    Unit build();
}
