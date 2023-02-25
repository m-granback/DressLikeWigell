package org.example.model.clothes;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Pants {
    private int id;
    private String name = "Pants";
    private String type;
    private int size;
    private double prize;
    private String material;
    private String color;
    private String fit;
    private String length;
    private PropertyChangeSupport propertyChangeSupport;

    public Pants() {
        propertyChangeSupport = new PropertyChangeSupport(this);
        propertyChangeSupport.firePropertyChange("Pants are being prepared",null,null);
    }

    public Pants(int id, String name, String type, int size, double prize, String material, String color, String fit, String length) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.size = size;
        this.prize = prize;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
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
}
