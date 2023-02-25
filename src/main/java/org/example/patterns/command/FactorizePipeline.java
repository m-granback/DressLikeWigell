package org.example.patterns.command;

import org.example.model.clothes.Pants;
import org.example.model.clothes.Skirt;
import org.example.model.clothes.TShirt;

import java.util.ArrayList;

public class FactorizePipeline {
    private ArrayList<FactorizeCommand> pipeline = new ArrayList<>();

    public void addFactorizeCommand(FactorizeCommand factorizeCommand) {
        pipeline.add(factorizeCommand);
    }

    public Pants performAction(Pants pants) {
        Pants result = pants;
        for (FactorizeCommand factorizeCommand : pipeline) {
            result = factorizeCommand.performAction(result);
        }
        return result;
    }

    public Skirt performAction(Skirt skirt) {
        Skirt result = skirt;
        for (FactorizeCommand factorizeCommand : pipeline) {
            result = factorizeCommand.performAction(result);
        }
        return result;
    }
    public TShirt performAction(TShirt tShirt) {
        TShirt result = tShirt;
        for (FactorizeCommand factorizeCommand : pipeline) {
            result = factorizeCommand.performAction(tShirt);
        }
        return result;
    }
}