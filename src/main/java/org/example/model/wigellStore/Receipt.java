package org.example.model.wigellStore;

import org.example.model.clothes.Pants;
import org.example.model.clothes.Skirt;
import org.example.model.clothes.TShirt;

public class Receipt {
    private Pants pants;
    private Skirt skirt;
    private TShirt tShirt;

    public Receipt(){

    }

    public Receipt(Pants pants) {
        this.pants = pants;
    }

    public Receipt(Skirt skirt) {
        this.skirt = skirt;
    }

    public Receipt(TShirt tShirt) {
        this.tShirt = tShirt;
    }
}
