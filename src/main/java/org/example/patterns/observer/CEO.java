package org.example.patterns.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CEO implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.print("CEO <--> Message received: ");
        if((boolean)evt.getNewValue())
            System.out.println("Manufacturing " + evt.getPropertyName().toLowerCase() + " being started.");
        else
            System.out.println("Manufacturing " + evt.getPropertyName().toLowerCase() + " done and ready for shipping");
    }
}
