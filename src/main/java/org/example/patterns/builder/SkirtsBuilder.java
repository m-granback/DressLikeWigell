package org.example.patterns.builder;

import org.example.model.clothes.Skirt;

public class SkirtsBuilder {
    Skirt skirt = new Skirt();
    public SkirtsBuilder setMaterial(String material){
        skirt.setMaterial(material);
        return this;
    }
    public SkirtsBuilder setWaistline(String waistline){
        skirt.setWaistline(waistline);
        return this;
    }
    public SkirtsBuilder setPattern(String pattern){
        skirt.setPattern(pattern);
        return this;
    }
    public SkirtsBuilder setSize(String size){
        skirt.setSize(size);
        return this;
    }
    public Skirt build(){
        return skirt;
    }

}
