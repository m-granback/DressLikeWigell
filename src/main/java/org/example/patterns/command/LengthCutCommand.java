package org.example.patterns.command;

import org.example.model.clothes.Pants;
import org.example.model.clothes.Skirt;
import org.example.model.clothes.TShirt;

public class LengthCutCommand implements FactorizeCommand{
    String length;

    public LengthCutCommand() {
    }

    public LengthCutCommand(String length){
        this.length = length;
    }
    @Override
    public Pants performAction(Pants pants) {
        pants.setLength(length);
        System.out.println("\033[0;36m[Pants has been cut to desired length of " + length.toLowerCase() + "]\033[0m");
        return pants;
    }

    @Override
    public Skirt performAction(Skirt skirt) {
        System.out.println("\033[0;36m[Skirt has been cut to desired length of " + length.toLowerCase() + "]\033[0m");
        return skirt;
    }

    @Override
    public TShirt performAction(TShirt tShirt) {
        System.out.println("\033[0;36m[T-Shirt has been cut to desired length of " + length.toLowerCase() + "]\033[0m");
        return tShirt;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
