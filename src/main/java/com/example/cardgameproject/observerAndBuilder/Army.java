package com.example.cardgameproject.observerAndBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *  * Filename:    Army.java
 *  * Purpose:     Manages a collection of Units and implements the Observer pattern to notify observers
 *  *              when units die. Used for both player and enemy armies during combat.
 *  *
 *  * Design Pattern: Subject in Observer pattern - maintains list of observers and notifies them
 *  *                 when any unit dies (no specific unit information passed)
 *  *
 *  * Key Methods:
 *  * - addUnit(): Adds unit and auto-registers as observer if it has abilities
 *  * - notifyDeath(): Notifies all observers (no parameters - observers don't know which unit died)
 *  * - buffAllUnits(): Applies +1/+1 to all units (used by shop system)
 *  *
 *  * Author: ZC, jlg-repo (docs)
 *  */


public class Army {
    private List<Unit> units; // Collection of units in this army
    private List<Observer> observers; // Observers watching for unit deaths



    // Constructor: initializes empty army with no units or observers
    public Army() {
        this.units = new ArrayList<>();
        this.observers = new ArrayList<>();
    }


    // Add a unit to the army, and register unit as observer if it has an ability
    public void addUnit(Unit unit) {
        this.units.add(unit);
        unit.setArmy(this);
        if (!(unit.getAbility().equals("n"))) {
            addObserver(unit);
        }
    }

    // Return list of all units
    public List<Unit> getArmy() {
        return(units);
    }

    // Handle unit death: remove dead unit from unit & observer lists and notify
    public void unitDeath(Unit unit) {
        units.remove(unit);
        removeObserver(unit);
        notifyDeath();
    }

    // Observer: register observer to be notified when any unit dies
    public void addObserver(Observer observer) {
        observers.add(observer);
    }


    // Observer: removes observer from notification list
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Observer: notify all observers when any unit dies
    public void notifyDeath() {
        for (Observer observer : observers) {
            observer.update();
        }
    }


    // these methods are for the BattleManager system
    public Unit getRandomUnit() {
        if (units.isEmpty()) {
            return null;
        }
        Random random = new Random(); // create RNG object
        return units.get(random.nextInt(units.size())); // return a random unit using the RNG object

    }
    //Check if army has any units remaining
    public boolean hasUnits() {
        return !units.isEmpty();
    }

    // Return count of units in army
    public int getUnitCount() {
        return units.size();
    }


    // Applies +1/+1 buff to all units, you can buy this in the shop
    public void buffAllUnits() {
        for (int i = 0; i < units.size(); i++) {
            units.get(i).buffUnit(1);
        }
    }
}
