package org.example.patterns.command;

import org.example.model.clothes.Pants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorizePipelineTest {

    @Test
    void addFactorizeCommand() {
        FactorizePipeline factorizePipeline = new FactorizePipeline();
        int sizeBeforeAdding = factorizePipeline.getPipeline().size();
        factorizePipeline.addFactorizeCommand(new ColorCommand());
        assertNotEquals(sizeBeforeAdding, factorizePipeline.getPipeline().size());
    }

    @Test
    void performAction() {
        FactorizePipeline factorizePipeline = new FactorizePipeline();
        Pants pants = new Pants();
        String testString = "TestString";
        factorizePipeline.addFactorizeCommand(new ColorCommand(testString));
        assertNotEquals(testString, pants.getColor());
        pants = factorizePipeline.performAction(pants);
        assertEquals(testString, pants.getColor());
    }

}