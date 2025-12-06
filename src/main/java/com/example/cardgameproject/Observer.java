package com.example.cardgameproject;

/**
 *  * Filename:    Observer.java
 *  * Purpose:     Observer interface for the Observer design pattern.
 *  *              Observers are notified when units die, allowing them to
 *  *              react with on-death abilities or other triggered effects.
 *  *
 *  * Design Pattern: Observer pattern interface
 *  *
 *  * Implementers: Unit (to trigger on-death abilities)
 *  *
 *  * Author:      [author]
 *  * Date:        [date]
 */

public interface Observer {

    // Called when a unit dies. Observers can check if they should react to a unit death
    public void update(Unit deadUnit);
}
