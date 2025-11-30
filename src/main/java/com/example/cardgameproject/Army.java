package com.example.cardgameproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Filename: Army.java
 * Purpose: Manages a collection of Units and implements the Observer pattern to notify observers
 * when units die. Used for both player and enemy armies during combat.
 *
 * Design Pattern: Subject in Observer pattern - notifies when units die.
 *
 *
 * Author: [author]
 * Date:   [date]
 *
 * */


public class Army {
    private List<Unit> units; // Collection of units in this army
    private List<Observer> observers; // Observers watching for unit deaths


    // Constructor: Initializes empty army with no units or observers
    public Army() {
        this.units = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    // Add a unit to the army
    public void addUnit(Unit unit) {
        this.units.add(unit);
    }

    // Handles unit death: removes dead unit from army,
    // notifies all observers
    public void unitDeath(Unit unit) {
        units.remove(unit);
        notifyDeath(unit);
    }

    // these methods are for the BattleManager system

    // this method returns a random unit from this army
    public Unit getRandomUnit() {
        if (units.isEmpty()) {
            return null;
        }

        Random random = new Random(); // create RNG object
        return units.get(random.nextInt(units.size())); // return a random unit using the RNG object
    }

    // A boolean method to return whether an army is empty
    public boolean hasUnits() {
        return !units.isEmpty();
    }

    // Returns count of the units in the army, used for RNG in BattleManager
    public int getUnitCount() {
        return units.size();
    }

    // Registers an observer to be notified of unit deaths

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Removes observer from the notification list
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Notifies all observers that a unit has died
    public void notifyDeath(Unit deadUnit) {
        for (Observer observer : observers) {
            observer.update(deadUnit);
        }
    }
}