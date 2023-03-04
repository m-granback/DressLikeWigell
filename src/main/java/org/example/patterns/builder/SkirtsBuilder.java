package org.example.patterns.builder;

import org.example.model.clothes.Skirt;

public class SkirtsBuilder {
    private Skirt skirt = new Skirt();
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
        if(skirt.getSize() == null)
            throw new RuntimeException("Size component missing, check builder pattern");
        if(skirt.getMaterial() == null)
            throw new RuntimeException("Material component missing, check builder pattern");
        if(skirt.getWaistline() == null)
            throw new RuntimeException("Waistline component missing, check builder pattern");
        if(skirt.getPattern() == null)
            throw new RuntimeException("Pattern component missing, check builder pattern");
        skirt.setBuilding(true);
        return skirt;
    }

    public Skirt getSkirt() {
        return skirt;
    }

    public void setSkirt(Skirt skirt) {
        this.skirt = skirt;
    }

}
