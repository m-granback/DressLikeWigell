package org.example.patterns.command;

import org.example.model.clothes.Pants;
import org.example.model.clothes.Skirt;
import org.example.model.clothes.TShirt;

public class ColorCommand implements FactorizeCommand{
    String decorate;
    public ColorCommand(String decorate){
        this.decorate = decorate;
    }

    @Override
    public Pants performAction(Pants pants) {
        pants.setColor(decorate);
        System.out.println("\033[0;36m[Pants has been colored " + decorate + "]\033[0m");
        return pants;
    }

    @Override
    public Skirt performAction(Skirt skirt) {
        skirt.setColor(decorate);
        System.out.println("\033[0;36m[Skirt has been colored " + decorate + "]\033[0m");
        return skirt;
    }

    @Override
    public TShirt performAction(TShirt tShirt) {
        tShirt.setColor(decorate);
        System.out.println("\033[0;36m[TShirt has been colored " + decorate + "]\033[0m");
        return tShirt;
    }
}
