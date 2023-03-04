package org.example.patterns.builder;

import org.example.model.clothes.TShirt;

public class TShirtBuilder {
    private TShirt tShirt = new TShirt();
    public TShirtBuilder setMaterial(String material){
        tShirt.setMaterial(material);
        return this;
    }
    public TShirtBuilder setSleeves(String sleeves){
        tShirt.setSleeves(sleeves);
        return this;
    }
    public TShirtBuilder setNeck(String neck){
        tShirt.setNeck(neck);
        return this;
    }
    public TShirtBuilder setSize(String size){
        tShirt.setSize(size);
        return this;
    }
    public TShirt build(){
        if(tShirt.getSize() == null)
            throw new RuntimeException("Size component missing, check builder pattern");
        if(tShirt.getMaterial() == null)
            throw new RuntimeException("Material component missing, check builder pattern");
        if(tShirt.getNeck() == null)
            throw new RuntimeException("Neck component missing, check builder pattern");
        if(tShirt.getSleeves() == null)
            throw new RuntimeException("Sleeves component missing, check builder pattern");
        tShirt.setBuilding(true);
        return tShirt;
    }

    public TShirt getTShirt() {
        return tShirt;
    }

    public void setTShirt(TShirt tShirt) {
        this.tShirt = tShirt;
    }

}
