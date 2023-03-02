package org.example.patterns.builder;

import org.example.model.clothes.Pants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PantsBuilderTest {

    @Test
    void shouldAlterAttributeValues() {
        String testString = "TestString";
        PantsBuilder pantsBuilder = new PantsBuilder();
        Pants testPants;
        testPants = pantsBuilder
                .setSize(testString)
                .setMaterial(testString)
                .setFit(testString)
                .setType(testString)
                .build();
        boolean alike = testPants.isBuilding();
        if(!(testPants.getSize() == testString))
            alike = false;
        if(!(testPants.getMaterial() == testString))
            alike = false;
        if(!(testPants.getFit() == testString))
            alike = false;
        if(!(testPants.getType() == testString))
            alike = false;
        assertTrue(alike);
    }
}