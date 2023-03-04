package org.example.patterns.builder;

import org.example.model.clothes.Pants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PantsBuilderTest {

    @Test
    void shouldAlterAttributeValues() {
        /**
         *  This test verifies that the strings fed to the builder are
         *  being applied to the object.
         */
        String testString = "TestString";
        PantsBuilder pantsBuilder = new PantsBuilder();
        Pants testPants = new Pants();
        assertNotEquals(testPants.getSize(), testString);
        assertNotEquals(testPants.getMaterial(), testString);
        assertNotEquals(testPants.getFit(), testString);
        assertNotEquals(testPants.getType(), testString);
        testPants = pantsBuilder
                .setSize(testString)
                .setMaterial(testString)
                .setFit(testString)
                .setType(testString)
                .build();
        assertEquals(testPants.getSize(), testString);
        assertEquals(testPants.getMaterial(), testString);
        assertEquals(testPants.getFit(), testString);
        assertEquals(testPants.getType(), testString);
    }
    /**
     *  No testing needed for incoming strings to be correct, they are taken from Mappings class.
     */
    @Test
    void shouldThrowRuntimeExceptionWhenMissingTypeComponent() {
        PantsBuilder pantsBuilder = new PantsBuilder();
        assertThrows(RuntimeException.class, () -> pantsBuilder.setSize("size").setFit("fit").setMaterial("material").build());
    }
    @Test
    void shouldThrowRuntimeExceptionWhenMissingMaterialComponent() {
        PantsBuilder pantsBuilder = new PantsBuilder();
        assertThrows(RuntimeException.class, ()-> pantsBuilder.setSize("size").setFit("fit").setType("Type").build());
    }
    @Test
    void shouldThrowRuntimeExceptionWhenMissingFitComponent(){
        PantsBuilder pantsBuilder = new PantsBuilder();
        assertThrows(RuntimeException.class, ()-> pantsBuilder.setSize("size").setType("type").setMaterial("material").build());
    }
    @Test
    void shouldThrowRuntimeExceptionWhenMissingSizeComponent() {
        PantsBuilder pantsBuilder = new PantsBuilder();
        assertThrows(RuntimeException.class, ()-> pantsBuilder.setType("type").setFit("fit").setMaterial("material").build());
    }
}