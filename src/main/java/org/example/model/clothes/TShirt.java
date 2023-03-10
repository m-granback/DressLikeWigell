package org.example.model.clothes;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TShirt {
    private int id;
    private String name = "TShirt";
    private String size;
    private double price = 29.99d;
    private String material;
    private String color;
    private String sleeves;
    private String neck;
    private boolean building;
    private PropertyChangeSupport propertyChangeSupport;
    public TShirt() {
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }
    public TShirt(String size, String material, String color, String sleeves, String neck) {
        this.size = size;
        this.material = material;
        this.color = color;
        this.sleeves = sleeves;
        this.neck = neck;
    }
    public void addPropertyChangeListener(PropertyChangeListener listener){
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public void setSleeves(String sleeves) {
        this.sleeves = sleeves;
    }

    public String getSleeves() {
        return sleeves;
    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }

    public void setPropertyChangeSupport(PropertyChangeSupport propertyChangeSupport) {
        this.propertyChangeSupport = propertyChangeSupport;
    }

    public boolean isBuilding() {
        return building;
    }

    public void setBuilding(boolean building) {
        boolean oldValue = this.building;
        this.building = building;
        this.propertyChangeSupport.firePropertyChange("of the shirt ", oldValue, this.building);
    }
}
