package com.example.cardgameproject;
import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Unit> units;
    private List<Observer> observers;



    public Army() {
        this.units = new ArrayList<>();
        this.observers = new ArrayList<>();
    }



    public void addUnit(Unit unit) {
        this.units.add(unit);
    }



    public void unitDeath(Unit unit) {
        units.remove(unit);
        notifyDeath(unit);
    }


    public void addObserver(Observer observer) {
        observers.add(observer);
    }



    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }


    public void notifyDeath(Unit deadUnit) {
        for (Observer observer : observers) {
            observer.update(deadUnit);
        }
    }

    public void buffAllUnits() {
        for (int i = 0; i < units.size(); i++) {
            units.get(i).buffUnit(1);
        }
    }
}
