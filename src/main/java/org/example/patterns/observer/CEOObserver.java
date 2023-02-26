package org.example.patterns.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

public class CEOObserver implements PropertyChangeListener {


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Message to CEO: " + evt.getPropertyName() + " " + evt.getNewValue());
    }
}
