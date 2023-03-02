package org.example.patterns.builder;

import org.example.model.clothes.Skirt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkirtsBuilderTest {

    @Test
    void shouldAlterAttributeValues() {
        String testString = "TestString";
        SkirtsBuilder skirtsBuilder = new SkirtsBuilder();
        Skirt testSkirt;
        testSkirt = skirtsBuilder
                .setSize(testString)
                .setMaterial(testString)
                .setPattern(testString)
                .setWaistline(testString)
                .build();
        boolean alike = testSkirt.isBuilding();
        if(!(testSkirt.getSize() == testString))
            alike = false;
        if(!(testSkirt.getMaterial() == testString))
            alike = false;
        if(!(testSkirt.getPattern() == testString))
            alike = false;
        if(!(testSkirt.getWaistline() == testString))
            alike = false;
        assertTrue(alike);
    }
}