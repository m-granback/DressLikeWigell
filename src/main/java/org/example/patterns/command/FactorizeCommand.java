package org.example.patterns.command;

import org.example.model.clothes.Pants;
import org.example.model.clothes.Skirt;
import org.example.model.clothes.TShirt;

public interface FactorizeCommand {
    Pants performAction(Pants pants);
    Skirt performAction(Skirt skirt);
    TShirt performAction(TShirt tShirt);
}
