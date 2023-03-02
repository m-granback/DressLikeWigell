package org.example.patterns.builder;

import org.example.model.clothes.Skirt;
import org.example.model.clothes.TShirt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TShirtBuilderTest {

    @Test
    void shouldAlterAttributeValues() {
        String testString = "TestString";
        TShirtBuilder tShirtBuilder = new TShirtBuilder();
        TShirt testtShirt;
        testtShirt = tShirtBuilder
                .setSize(testString)
                .setMaterial(testString)
                .setSleeves(testString)
                .setNeck(testString)
                .build();
        boolean alike = testtShirt.isBuilding();
        if(!(testtShirt.getSize() == testString))
            alike = false;
        if(!(testtShirt.getMaterial() == testString))
            alike = false;
        if(!(testtShirt.getSleeves() == testString))
            alike = false;
        if(!(testtShirt.getNeck() == testString))
            alike = false;
        assertTrue(alike);
    }
}