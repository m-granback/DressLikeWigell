package org.example.patterns.command;

import org.example.model.clothes.Pants;
import org.example.model.clothes.Skirt;
import org.example.model.clothes.TShirt;

import java.util.ArrayList;

public class FactorizePipeline {
    private ArrayList<FactorizeCommand> pipeline = new ArrayList<>();

    public FactorizePipeline() {
    }

    public void addFactorizeCommand(FactorizeCommand factorizeCommand) {
        pipeline.add(factorizeCommand);
    }

    public Pants performAction(Pants pants) {
        Pants result = pants;
        for (FactorizeCommand factorizeCommand : pipeline) {
            result = factorizeCommand.performAction(result);
        }
        result.setBuilding(false);
        return result;
    }

    public Skirt performAction(Skirt skirt) {
        Skirt result = skirt;
        for (FactorizeCommand factorizeCommand : pipeline) {
            result = factorizeCommand.performAction(result);
        }
        result.setBuilding(false);
        return result;
    }
    public TShirt performAction(TShirt tShirt) {
        TShirt result = tShirt;
        for (FactorizeCommand factorizeCommand : pipeline) {
            result = factorizeCommand.performAction(tShirt);
        }
        result.setBuilding(false);
        return result;
    }

    public ArrayList<FactorizeCommand> getPipeline() {
        return pipeline;
    }

    public void setPipeline(ArrayList<FactorizeCommand> pipeline) {
        this.pipeline = pipeline;
    }
}