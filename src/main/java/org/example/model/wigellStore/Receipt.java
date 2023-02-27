package org.example.model.wigellStore;

import org.example.model.Customer;
import org.example.model.clothes.Pants;
import org.example.model.clothes.Skirt;
import org.example.model.clothes.TShirt;

import java.util.Date;

public class Receipt {
    public void showReceipt(Order currentOrder, Customer currentCustomer){
        double price = 0.0d;
        System.out.print(//-------------------------------------------------
                "\033[0;34m╔══════════" + new Date() + "══════════" +
                        "\n║ ₩ Receipt for customer id \033[0;32m" + currentCustomer.getId() +
                        "\033[0;34m, order id \033[0;32m" + currentOrder.getOrderId() + "\033[0;34m\n");
        for(Pants pants: currentOrder.getPantsSpecifications()){
            price += pants.getPrice();
            System.out.println("╟───────────────────────────────────────────────₩");
            System.out.print(
                    "║ Article# " + pants.getId() + "\n" +
                    "║   \033[0;32m" + pants.getName() + "\033[0;34m\n" +
                    "║ ●\033[0;32m Material " + pants.getMaterial() + "\033[0;34m\n" +
                    "║ ●\033[0;32m Size " + pants.getSize() + "\033[0;34m\n" +
                    "║ ●\033[0;32m Type " + pants.getType() + "\033[0;34m\n" +
                    "║ ●\033[0;32m Color " + pants.getColor() + "\033[0;34m\n" +
                    "║ ●\033[0;32m Fit " + pants.getFit() + "\033[0;34m\n" +
                    "║ ●\033[0;32m Length " + pants.getLength() + "\033[0;34m\n" +
                    "║ ●\033[0;32m Price $" + pants.getPrice() + "\033[0;34m\n"
            );
        }
        for(Skirt skirt: currentOrder.getSkirtsSpecifications()){
            price += skirt.getPrice();
            System.out.println("╟───────────────────────────────────────────────₩");
            System.out.print(
                    "║ Article# " + skirt.getId() + "\n" +
                    "║   \033[0;32m" + skirt.getName() + "\033[0;34m\n" +
                    "║ ●\033[0;32m Material " + skirt.getMaterial() + "\033[0;34m\n" +
                    "║ ●\033[0;32m Size " + skirt.getSize() + "\033[0;34m\n" +
                    "║ ●\033[0;32m Color " + skirt.getColor() + "\033[0;34m\n" +
                    "║ ●\033[0;32m Waistline " + skirt.getWaistline() + "\033[0;34m\n" +
                    "║ ●\033[0;32m Pattern " + skirt.getPattern() + "\033[0;34m\n" +
                    "║ ●\033[0;32m Price $" + skirt.getPrice() + "\033[0;34m\n"
            );
        }
        for(TShirt tShirt: currentOrder.gettShirtsSpecifications()){
            price += tShirt.getPrice();
            System.out.println("╟───────────────────────────────────────────────₩");
            System.out.print(
                    "║ Article# " + tShirt.getId() + "\n" +
                    "║   \033[0;32m" + tShirt.getName() + "\033[0;34m\n" +
                    "║ ●\033[0;32m Material " + tShirt.getMaterial() + "\033[0;34m\n" +
                    "║ ●\033[0;32m Size " + tShirt.getSize() + "\033[0;34m\n" +
                    "║ ●\033[0;32m Color " + tShirt.getColor() + "\033[0;34m\n" +
                    "║ ●\033[0;32m Sleeves " + tShirt.getSleeves() + "\033[0;34m\n" +
                    "║ ●\033[0;32m Neck " + tShirt.getNeck() + "\033[0;34m\n" +
                    "║ ●\033[0;32m Price $" + tShirt.getPrice() + "\033[0;34m\n"
            );
        }
        System.out.println("╟───────────────────────────────────────────────₩");
        System.out.println("║ Price Total \033[0;31m$" + price + "\033[0;34m");
        System.out.print("╟───────────────────────────────────────────────₩\n" +
                "║ Shipping address\n" +
                "║ Name: \033[1;33m" + currentCustomer.getName() + "\033[0;34m\n" +
                "║ Address: \033[1;33m" + currentCustomer.getAddress() + "\033[0;34m\n" +
                "║ Email: \033[1;33m" + currentCustomer.getEmail() + "\033[0;34m\n" +
                "╚════════════════════════════════════════════════\n");
    }
}
