package org.example.patterns.command;

import org.example.model.clothes.Pants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthCutCommandTest {

    @Test
    void performAction() {
        FactorizePipeline factorizePipeline = new FactorizePipeline();
        Pants pants = new Pants();
        String testString = "TestString";
        assertNotEquals(pants.getLength(), testString);
        factorizePipeline.addFactorizeCommand(new LengthCutCommand(testString));
        pants = factorizePipeline.performAction(pants);
        assertEquals(pants.getLength(), testString);
    }
}