package org.example.patterns.command;

import org.example.model.clothes.Pants;
import org.example.model.clothes.Skirt;
import org.example.model.clothes.TShirt;

public class ColorCommand implements FactorizeCommand{
    String color;

    public ColorCommand() {
    }

    public ColorCommand(String color){
        this.color = color;
    }
    @Override
    public Pants performAction(Pants pants) {
        pants.setColor(color);
        System.out.println("\033[0;36m[Pants has been colored " + color + "]\033[0m");
        return pants;
    }
    @Override
    public Skirt performAction(Skirt skirt) {
        skirt.setColor(color);
        System.out.println("\033[0;36m[Skirt has been colored " + color + "]\033[0m");
        return skirt;
    }
    @Override
    public TShirt performAction(TShirt tShirt) {
        tShirt.setColor(color);
        System.out.println("\033[0;36m[TShirt has been colored " + color + "]\033[0m");
        return tShirt;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}
