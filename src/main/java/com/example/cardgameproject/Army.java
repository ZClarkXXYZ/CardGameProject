package com.example.cardgameproject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Army {
    private List<Unit> units;
    private List<Observer> observers;



    public Army() {
        this.units = new ArrayList<>();
        this.observers = new ArrayList<>();
    }



    public void addUnit(Unit unit) {
        this.units.add(unit);
        unit.setArmy(this);
        if (!(unit.getAbility().equals("n"))) {
            addObserver(unit);
        }
    }

    public List<Unit> getArmy() {
        return(units);
    }


    public void unitDeath(Unit unit) {
        units.remove(unit);
        removeObserver(unit);
        notifyDeath();
    }


    public void addObserver(Observer observer) {
        observers.add(observer);
    }



    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }


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
    public boolean hasUnits() {
        return !units.isEmpty();
    }

    public int getUnitCount() {
        return units.size();
    }


    public void buffAllUnits() {
        for (int i = 0; i < units.size(); i++) {
            units.get(i).buffUnit(1);
        }
    }
}
