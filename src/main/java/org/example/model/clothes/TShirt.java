package org.example.model.clothes;

public class TShirt {
    private int id;
    private String name;
    private String size;
    private double prize;
    private String material;
    private String color;
    private boolean sleeves;
    private boolean neck;

    public TShirt() {
    }

    public TShirt(int id, String name, String size, double prize, String material, String color, boolean sleeves, boolean neck) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.prize = prize;
        this.material = material;
        this.color = color;
        this.sleeves = sleeves;
        this.neck = neck;
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

    public boolean isSleeves() {
        return sleeves;
    }

    public void setSleeves(boolean sleeves) {
        this.sleeves = sleeves;
    }

    public boolean isNeck() {
        return neck;
    }

    public void setNeck(boolean neck) {
        this.neck = neck;
    }
}
