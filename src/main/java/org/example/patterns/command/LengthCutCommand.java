package org.example.patterns.command;

import org.example.model.clothes.Pants;
import org.example.model.clothes.Skirt;
import org.example.model.clothes.TShirt;

public class LengthCutCommand implements FactorizeCommand{
    String length;
    public LengthCutCommand(String length){
        this.length = length;
    }
    @Override
    public Pants performAction(Pants pants) {
        pants.setLength(length);
        System.out.println("Pants has been cut to desired length of " + length);
        return pants;
    }

    @Override
    public Skirt performAction(Skirt skirt) {
        System.out.println("Skirts can't be cut");
        return skirt;
    }

    @Override
    public TShirt performAction(TShirt tShirt) {
        System.out.println("TShirts can't be cut");
        return tShirt;
    }
}
