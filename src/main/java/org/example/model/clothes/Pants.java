package org.example.model.clothes;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Pants {
    private int id;
    private String name = "Pants";
    private String type;
    private String size;
    private double price = 59.99d;
    private String material;
    private String color;
    private String fit;
    private String length;
    private boolean building = false;
    private PropertyChangeSupport propertyChangeSupport;

    public Pants() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public Pants(int id, String name, String type, String size, double price, String material, String color, String fit, String length) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.size = size;
        this.price = price;
        this.material = material;
        this.color = color;
        this.fit = fit;
        this.length = length;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        propertyChangeSupport.addPropertyChangeListener(listener);
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public boolean isBuilding() {
        return building;
    }

    public void setBuilding(boolean building) {
        boolean oldValue = this.building;
        this.building = building;
        propertyChangeSupport.firePropertyChange("Pants build attribute changed", oldValue,this.building);
        this.building = building;
    }
}
