package org.example.patterns.builder;

import org.example.model.clothes.Skirt;
import org.example.model.clothes.TShirt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TShirtBuilderTest {

    @Test
    void shouldAlterAttributeValues() {
        /**
         *  This test verifies that the strings fed to the builder are
         *  being applied to the object.
         */
        String testString = "TestString";
        TShirtBuilder tShirtBuilder = new TShirtBuilder();
        TShirt testtShirt = new TShirt();
        assertNotEquals(testtShirt.getSize(), testString);
        assertNotEquals(testtShirt.getMaterial(), testString);
        assertNotEquals(testtShirt.getSleeves(), testString);
        assertNotEquals(testtShirt.getNeck(), testString);
        testtShirt = tShirtBuilder
                .setSize(testString)
                .setMaterial(testString)
                .setSleeves(testString)
                .setNeck(testString)
                .build();
        assertEquals(testtShirt.getSize(), testString);
        assertEquals(testtShirt.getMaterial(), testString);
        assertEquals(testtShirt.getSleeves(), testString);
        assertEquals(testtShirt.getNeck(), testString);
    }
    /**
     *  No testing needed for incoming strings to be correct, they are taken from Mappings class.
     */
    @Test
    void shouldThrowRuntimeExceptionWhenMissingNeckComponent() {
        TShirtBuilder tShirtBuilder = new TShirtBuilder();
        assertThrows(RuntimeException.class, () -> tShirtBuilder.setSize("size").setSleeves("sleeves").setMaterial("material").build());
    }
    @Test
    void shouldThrowRuntimeExceptionWhenMissingMaterialComponent() {
        TShirtBuilder tShirtBuilder = new TShirtBuilder();
        assertThrows(RuntimeException.class, ()-> tShirtBuilder.setSize("size").setSleeves("sleeves").setNeck("neck").build());
    }
    @Test
    void shouldThrowRuntimeExceptionWhenMissingSleevesComponent(){
        TShirtBuilder tShirtBuilder = new TShirtBuilder();
        assertThrows(RuntimeException.class, ()-> tShirtBuilder.setSize("size").setNeck("neck").setMaterial("material").build());
    }
    @Test
    void shouldThrowRuntimeExceptionWhenMissingSizeComponent() {
        TShirtBuilder tShirtBuilder = new TShirtBuilder();
        assertThrows(RuntimeException.class, ()-> tShirtBuilder.setNeck("neck").setSleeves("sleeves").setMaterial("material").build());
    }
}