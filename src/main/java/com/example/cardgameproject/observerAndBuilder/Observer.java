package com.example.cardgameproject.observerAndBuilder;
/**
 *  * Filename:    Observer.java
 *  * Purpose:     Observer interface for the Observer design pattern.
 *  *              Units implement this to react when any unit in their army dies.
 *  *
 *  * Design Pattern: Observer pattern interface
 *  *
 Implementers: Unit (to trigger abilities when any unit dies)
 *  *
 *  * Author: Chris
 *  *
 */

 // Called to update all observer objects to do something (in this case, when a unit dies, units that are in the list of objects to notify are updated)
public interface Observer {
    public void update();
}
