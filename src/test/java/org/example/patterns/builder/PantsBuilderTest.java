package org.example.patterns.builder;

import org.example.model.clothes.Pants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PantsBuilderTest {

    @Test
    void shouldReturnEqualAttributeValues() {
        String testString1 = "aaaaa";
        String testString2 = "bbbbb";
        String testString3 = "ccccc";
        String testString4 = "ddddd";
        PantsBuilder pantsBuilder = new PantsBuilder();
        Pants testPants;
        testPants = pantsBuilder
                .setSize(testString1)
                .setMaterial(testString2)
                .setFit(testString3)
                .setType(testString4)
                .build();
        boolean alike = testPants.isBuilding();
        if(!(testPants.getSize() == testString1))
            alike = false;
        if(!(testPants.getMaterial() == testString2))
            alike = false;
        if(!(testPants.getFit() == testString3))
            alike = false;
        if(!(testPants.getType() == testString4))
            alike = false;
        assertTrue(alike);
    }
}