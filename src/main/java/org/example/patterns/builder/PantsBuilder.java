package org.example.patterns.builder;

import org.example.model.clothes.Pants;

import java.beans.PropertyChangeSupport;

public class PantsBuilder {
    private Pants pants = new Pants();
    public PantsBuilder setSize(String size){
        pants.setSize(size);
        return this;
    }
    public PantsBuilder setMaterial(String material){
        pants.setMaterial(material);
        return this;
    }
    public PantsBuilder setType(String type){
        pants.setType(type);
        return this;
    }
    public PantsBuilder setFit(String fit){
        pants.setFit(fit);
        return this;
    }
    public Pants build(){
        // Check whether all data needed is set
        return pants;
    }

    public Pants getPants() {
        return pants;
    }

    public void setPants(Pants pants) {
        this.pants = pants;
    }
}
