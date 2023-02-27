package org.example.utils;

import java.util.HashMap;

public class Mappings {
    private HashMap<Integer, String> garmentMapping = new HashMap<>(){{
        put(1,"Pants");
        put(2,"Skirt");
        put(3,"T-Shirt");
    }};
    private HashMap<Integer, String> sizeMapping = new HashMap<>(){{
        put(1,"Small");
        put(2,"Large");
    }};
    private HashMap<Integer, String> materialMapping = new HashMap<>(){{
        put(1, "Leather");
        put(2, "Cotton");
    }};
    private HashMap<Integer, String> colorMapping = new HashMap<>(){{
        put(1, "White");
        put(2, "Black");
    }};
    private HashMap<Integer, String> sleevesMapping = new HashMap<>(){{
        put(1, "Long");
        put(2, "Three quarters");
        put(3, "Short");
    }};
    private HashMap<Integer, String> neckMapping = new HashMap<>(){{
        put(1, "Tight");
        put(2, "Regular");
        put(3, "Loose");
    }};
    private HashMap<Integer, String> waistlineMapping = new HashMap<>(){{
        put(1, "Extra low cut");
        put(2, "Low cut");
        put(3, "Above belly");
    }};
    private HashMap<Integer, String> patternMapping = new HashMap<>(){{
        put(1,"Dots");
        put(2,"Stripes");
        put(3,"Solid");
    }};
    // fit length type
    public HashMap<Integer, String> fitMapping = new HashMap<>(){{
        put(1,"Slim-fit");
        put(2,"Tight");
        put(3,"Loose");
    }};
    public HashMap<Integer, String> lengthMapping = new HashMap<>(){{
        put(1, "Knee length");
        put(2, "Full length");
        put(3, "Extra long (folded up)");
    }};
    public HashMap<Integer, String> typeMappings = new HashMap<>(){{
        put(1, "Regular");
        put(2, "Extra pockets");
        put(3, "No pockets");
    }};


    public HashMap<Integer, String> getGarmentMapping() {
        return garmentMapping;
    }

    public void setGarmentMapping(HashMap<Integer, String> garmentMapping) {
        this.garmentMapping = garmentMapping;
    }

    public HashMap<Integer, String> getSizeMapping() {
        return sizeMapping;
    }

    public void setSizeMapping(HashMap<Integer, String> sizeMapping) {
        this.sizeMapping = sizeMapping;
    }

    public HashMap<Integer, String> getMaterialMapping() {
        return materialMapping;
    }

    public void setMaterialMapping(HashMap<Integer, String> materialMapping) {
        this.materialMapping = materialMapping;
    }

    public HashMap<Integer, String> getColorMapping() {
        return colorMapping;
    }

    public void setColorMapping(HashMap<Integer, String> colorMapping) {
        this.colorMapping = colorMapping;
    }

    public HashMap<Integer, String> getSleevesMapping() {
        return sleevesMapping;
    }

    public void setSleevesMapping(HashMap<Integer, String> sleevesMapping) {
        this.sleevesMapping = sleevesMapping;
    }

    public HashMap<Integer, String> getNeckMapping() {
        return neckMapping;
    }

    public void setNeckMapping(HashMap<Integer, String> neckMapping) {
        this.neckMapping = neckMapping;
    }

    public HashMap<Integer, String> getWaistlineMapping() {
        return waistlineMapping;
    }

    public void setWaistlineMapping(HashMap<Integer, String> waistlineMapping) {
        this.waistlineMapping = waistlineMapping;
    }

    public HashMap<Integer, String> getPatternMapping() {
        return patternMapping;
    }

    public void setPatternMapping(HashMap<Integer, String> patternMapping) {
        this.patternMapping = patternMapping;
    }

    public HashMap<Integer, String> getFitMapping() {
        return fitMapping;
    }

    public void setFitMapping(HashMap<Integer, String> fitMapping) {
        this.fitMapping = fitMapping;
    }

    public HashMap<Integer, String> getLengthMapping() {
        return lengthMapping;
    }

    public void setLengthMapping(HashMap<Integer, String> lengthMapping) {
        this.lengthMapping = lengthMapping;
    }

    public HashMap<Integer, String> getTypeMappings() {
        return typeMappings;
    }

    public void setTypeMappings(HashMap<Integer, String> typeMappings) {
        this.typeMappings = typeMappings;
    }
}
