package org.example.model.clothes;

public class Skirt {
    private int id;
    private String name;
    private String size;
    private double prize;
    private String material;
    private String color;
    private int waistline;
    private String pattern;

    public Skirt() {
    }

    public Skirt(int id, String name, String size, double prize, String material, String color, int waistline, String pattern) {
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

    public int getWaistline() {
        return waistline;
    }

    public void setWaistline(int waistline) {
        this.waistline = waistline;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
