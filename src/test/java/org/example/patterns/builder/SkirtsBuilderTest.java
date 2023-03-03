package org.example.patterns.builder;

import org.example.model.clothes.Skirt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkirtsBuilderTest {

    @Test
    void shouldAlterAttributeValues() {
        /**
         *  This test verifies that the strings fed to the builder are
         *  being applied to the object.
         */
        String testString = "TestString";
        SkirtsBuilder skirtsBuilder = new SkirtsBuilder();
        Skirt testSkirt = new Skirt();
        assertNotEquals(testSkirt.getSize(), testString);
        assertNotEquals(testSkirt.getMaterial(), testString);
        assertNotEquals(testSkirt.getPattern(), testString);
        assertNotEquals(testSkirt.getWaistline(), testString);
        testSkirt = skirtsBuilder
                .setSize(testString)
                .setMaterial(testString)
                .setPattern(testString)
                .setWaistline(testString)
                .build();
        assertEquals(testSkirt.getSize(), testString);
        assertEquals(testSkirt.getMaterial(), testString);
        assertEquals(testSkirt.getPattern(), testString);
        assertEquals(testSkirt.getWaistline(), testString);
    }
}