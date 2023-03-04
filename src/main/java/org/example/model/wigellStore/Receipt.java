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
                    "╟◄Manufact► #" + pants.getId() + "\033[1;32m\t" + pants.getName() + "\033[0;34m\n" +
                    "║\n" +
                    "╟─◄Material►\t\033[0;32m" + pants.getMaterial() + "\033[0;34m\n" +
                    "╟─◄Size►\t\t\033[0;32m" + pants.getSize() + "\033[0;34m\n" +
                    "╟─◄Type►\t\t\033[0;32m" + pants.getType() + "\033[0;34m\n" +
                    "╟─◄Color►\t\t\033[0;32m" + pants.getColor() + "\033[0;34m\n" +
                    "╟─◄Fit►\t\t\t\033[0;32m" + pants.getFit() + "\033[0;34m\n" +
                    "╟─◄Length►\t\t\033[0;32m" + pants.getLength() + "\033[0;34m\n" +
                    "╟─◄Price►\t\t\033[0;32m$" + pants.getPrice() + "\033[0;34m\n"
            );
        }
        for(Skirt skirt: currentOrder.getSkirtsSpecifications()){
            price += skirt.getPrice();
            System.out.println("╟───────────────────────────────────────────────₩");
            System.out.print(
                    "╟◄Manufact► #" + skirt.getId() + "\033[1;32m\t" + skirt.getName() + "\033[0;34m\n" +
                    "║\n" +
                    "╟─◄Material►\t\033[0;32m" + skirt.getMaterial() + "\033[0;34m\n" +
                    "╟─◄Size►\t\t\033[0;32m" + skirt.getSize() + "\033[0;34m\n" +
                    "╟─◄Color►\t\t\033[0;32m" + skirt.getColor() + "\033[0;34m\n" +
                    "╟─◄Waistline►\t\033[0;32m" + skirt.getWaistline() + "\033[0;34m\n" +
                    "╟─◄Pattern►\t\t\033[0;32m" + skirt.getPattern() + "\033[0;34m\n" +
                    "╟─◄Price►\t\t\033[0;32m$" + skirt.getPrice() + "\033[0;34m\n"
            );
        }
        for(TShirt tShirt: currentOrder.gettShirtsSpecifications()){
            price += tShirt.getPrice();
            System.out.println("╟───────────────────────────────────────────────₩");
            System.out.print(
                    "╟◄Manufact► #" + tShirt.getId() + "\033[1;32m\t" + tShirt.getName() +"\033[0;34m\n" +
                    "║\n" +
                    "╟─◄Material►\t\033[0;32m" + tShirt.getMaterial() + "\033[0;34m\n" +
                    "╟─◄Size►\t\t\033[0;32m" + tShirt.getSize() + "\033[0;34m\n" +
                    "╟─◄Color►\t\t\033[0;32m" + tShirt.getColor() + "\033[0;34m\n" +
                    "╟─◄Sleeves►\t\t\033[0;32m" + tShirt.getSleeves() + "\033[0;34m\n" +
                    "╟─◄Neck►\t\t\033[0;32m" + tShirt.getNeck() + "\033[0;34m\n" +
                    "╟─◄Price►\t\t\033[0;32m$" + tShirt.getPrice() + "\033[0;34m\n"
            );
        }
        System.out.println("╟───────────────────────────────────────────────₩");
        System.out.printf("╟─◄Price total►\t\033[0;31m$%.2f\033[0;34m\n", price);
        System.out.print("╟───────────────────────────────────────────────₩\n" +
                "╟◄Shipping address►\n" +
                "╟─◄Name►\033[1;33m\t\t" + currentCustomer.getName() + "\033[0;34m\n" +
                "╟─◄Address►\033[1;33m\t\t" + currentCustomer.getAddress() + "\033[0;34m\n" +
                "╟─◄Email►\033[1;33m\t\t" + currentCustomer.getEmail() + "\033[0;34m\n" +
                "╚════════════════════════════════════════════════\n");
    }
}
