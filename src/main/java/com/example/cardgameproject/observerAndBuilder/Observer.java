package com.example.cardgameproject.observerAndBuilder;
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
 *  * Author: Chris
 *  *
 */

 // Called to update all observer objects to do something (in this case, when a unit dies, units that are in the list of objects to notify are updated)
public interface Observer {
    public void update();
}
