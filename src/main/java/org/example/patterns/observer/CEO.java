package org.example.patterns.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CEO implements PropertyChangeListener {
    public CEO() {
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.print("\033[0;31mCEO <--> Message received: ");
        if((boolean)evt.getNewValue())
            System.out.println("\033[0;32mManufacturing " + evt.getPropertyName().toLowerCase() + "has been started.\033[0m");
        else
            System.out.println("\033[0;32mManufacturing " + evt.getPropertyName().toLowerCase() + "is done and ready for shipping\033[0m");
    }
}
