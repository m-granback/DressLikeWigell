package org.example.model.wigellStore;

import org.example.model.clothes.Pants;
import org.example.model.clothes.Skirt;
import org.example.model.clothes.TShirt;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TemplateStorage {

    public TemplateStorage() {
    }
    private Queue<Pants> pantsTemplates = new ConcurrentLinkedQueue<>();
    private Queue<Skirt> skirtTemplates = new ConcurrentLinkedQueue<>();
    private Queue<TShirt> tShirtTemplates = new ConcurrentLinkedQueue<>();

    public void addToTemplates(Pants template){
        pantsTemplates.add(template);
    }
    public void addToTemplates(Skirt skirt){
        skirtTemplates.add(skirt);
    }
    public void addToTemplates(TShirt tShirt){
        tShirtTemplates.add(tShirt);
    }

    public Queue<Pants> getPantsTemplates() {
        return pantsTemplates;
    }

    public void setPantsTemplates(Queue<Pants> pantsTemplates) {
        this.pantsTemplates = pantsTemplates;
    }

    public Queue<Skirt> getSkirtTemplates() {
        return skirtTemplates;
    }

    public void setSkirtTemplates(Queue<Skirt> skirtTemplates) {
        this.skirtTemplates = skirtTemplates;
    }

    public Queue<TShirt> gettShirtTemplates() {
        return tShirtTemplates;
    }

    public void settShirtTemplates(Queue<TShirt> tShirtTemplates) {
        this.tShirtTemplates = tShirtTemplates;
    }
}
