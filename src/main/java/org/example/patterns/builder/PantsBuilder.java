package org.example.patterns.builder;

import org.example.model.clothes.Pants;

import java.beans.PropertyChangeSupport;

public class PantsBuilder {
    private PropertyChangeSupport propertyChangeSupport;
    private Pants pants;
    public PantsBuilder(){

    }
    public PantsBuilder(Pants pants){
        this.pants = pants;
        propertyChangeSupport = new PropertyChangeSupport(this);
    }
    public PantsBuilder addMaterial(String material){
        pants.setMaterial("sdasdsd");
        return this;
    }
    public PantsBuilder setType(String type){
        return this;
    }
    public PantsBuilder setFit(String fit){
        return this;
    }
    public Pants build(){
        // Check whether all data needed is set
        return pants;
    }
}
