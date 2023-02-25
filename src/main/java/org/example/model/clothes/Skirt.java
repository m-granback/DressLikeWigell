package org.example.model.clothes;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Skirt {
    private int id;
    private String name = "Skirt";
    private String size;
    private double prize;
    private String material;
    private String color;
    private String waistline;
    private String pattern;
    private boolean done;
    private PropertyChangeSupport propertyChangeSupport;

    public Skirt() {
        this.propertyChangeSupport = new PropertyChangeSupport(this); // är det här han menar att man behöver en boolean ?
    }
    public void addPropertyChangeListener(PropertyChangeListener listener){
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public Skirt(int id, String name, String size, double prize, String material, String color, String waistline, String pattern) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.prize = prize;
        this.material = material;
        this.color = color;
        this.waistline = waistline;
        this.pattern = pattern;
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

    public String getWaistline() {
        return waistline;
    }

    public void setWaistline(String waistline) {
        this.waistline = waistline;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.propertyChangeSupport.firePropertyChange("done", -1 ,0);
        this.done = done;
    }
}
