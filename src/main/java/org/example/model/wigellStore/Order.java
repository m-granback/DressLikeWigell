package org.example.model.wigellStore;

import org.example.model.Customer;
import org.example.model.clothes.Pants;
import org.example.model.clothes.Skirt;
import org.example.model.clothes.TShirt;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private int customerId;
    private List<Pants> pantsSpecifications = new ArrayList<>();
    private List<Skirt> skirtsSpecifications = new ArrayList<>();
    private List<TShirt> tShirtsSpecifications = new ArrayList<>();

    public Order(int orderId, Customer customer){
        this.orderId = orderId;
        this.customerId = customer.getId();
    }
    public void addToOrder(Pants pants){ pantsSpecifications.add(pants); }
    public void addToOrder(Skirt skirt){
        skirtsSpecifications.add(skirt);
    }
    public void addToOrder(TShirt tShirt){
        tShirtsSpecifications.add(tShirt);
    }
    public List<Pants> getPantsSpecifications() {
        return pantsSpecifications;
    }

    public List<Skirt> getSkirtsSpecifications() {
        return skirtsSpecifications;
    }
    public List<TShirt> gettShirtsSpecifications() {
        return tShirtsSpecifications;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setPantsSpecifications(List<Pants> pantsSpecifications) {
        this.pantsSpecifications = pantsSpecifications;
    }

    public void setSkirtsSpecifications(List<Skirt> skirtsSpecifications) {
        this.skirtsSpecifications = skirtsSpecifications;
    }

    public void settShirtsSpecifications(List<TShirt> tShirtsSpecifications) {
        this.tShirtsSpecifications = tShirtsSpecifications;
    }
}
