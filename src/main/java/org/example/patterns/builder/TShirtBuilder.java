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
        return tShirt;
    }

    public TShirt gettShirt() {
        return tShirt;
    }

    public void settShirt(TShirt tShirt) {
        this.tShirt = tShirt;
    }
}
