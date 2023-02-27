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
        System.out.println("\033[0;36mPants has been cut to desired length of " + length + "\033[0m");
        return pants;
    }

    @Override
    public Skirt performAction(Skirt skirt) {
        System.out.println("\033[0;36mSkirts can't be cut" + length + "\033[0m");
        return skirt;
    }

    @Override
    public TShirt performAction(TShirt tShirt) {
        System.out.println("\033[0;36mTShirts can't be cut" + "\033[0m");
        return tShirt;
    }
}
