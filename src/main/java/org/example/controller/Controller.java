package org.example.controller;

import org.example.model.Customer;
import org.example.model.clothes.Pants;
import org.example.model.clothes.Skirt;
import org.example.model.clothes.TShirt;
import org.example.model.wigellStore.Order;
import org.example.patterns.builder.PantsBuilder;
import org.example.patterns.builder.SkirtsBuilder;
import org.example.patterns.builder.TShirtBuilder;
import org.example.patterns.command.ColorCommand;
import org.example.patterns.command.FactorizePipeline;
import org.example.patterns.command.LengthCutCommand;
import org.example.patterns.observer.CEO;
import org.example.utils.Mappings;

import java.util.HashMap;
import java.util.Scanner;

public class Controller {
    private int wigellOrderId = 1000;
    private int wigellCustomerId = 25000;
    private CEO ceo = new CEO();
    private Customer currentCustomer;
    private Order currentOrder;
    private Mappings mappings = new Mappings();
    public Controller() {
    }
    private void showMenuFor(HashMap<Integer, String> hashMap){
        for(int i: hashMap.keySet()){
            System.out.println("[" + i + "] " + hashMap.get(i));
        }
        System.out.print("Choice: ");
    }
    private void askUserIfDoneShopping(){
        Scanner scanner = new Scanner(System.in);
        drawSeparator();
        System.out.println("Done shopping?\n[1] Yes\n[2] No, I want to shop more\n");
        if(scanner.nextInt() == 1)
            checkout();
        else
            productSpecification();
    }
    private void checkout(){
        for(Pants pants: currentOrder.getPantsSpecifications()){
         makePants(pants.getSize(), pants.getMaterial(), pants.getColor(), pants.getType(), pants.getFit(), pants.getLength());
        }
        for(Skirt skirt: currentOrder.getSkirtsSpecifications()){
            makeSkirt(skirt.getSize(), skirt.getMaterial(), skirt.getColor(), skirt.getWaistline(), skirt.getPattern());
        }
        for(TShirt tShirt: currentOrder.gettShirtsSpecifications()){
            makeTShirt(tShirt.getSize(), tShirt.getMaterial(), tShirt.getColor(),tShirt.getSleeves(),tShirt.getNeck());
        }
        showReceipt();
    }
    private void productSpecification(){
        Scanner scanner = new Scanner(System.in);
        drawSeparator();
        System.out.println("Please select garment:");
        showMenuFor(mappings.getGarmentMapping());
        String garment = mappings.getGarmentMapping().get(scanner.nextInt());
        drawSeparator();
        System.out.println("Please select size: ");
        showMenuFor(mappings.getSizeMapping());
        String size = mappings.getSizeMapping().get(scanner.nextInt());
        drawSeparator();
        System.out.println("Please select material: ");
        showMenuFor(mappings.getMaterialMapping());
        String material = mappings.getMaterialMapping().get(scanner.nextInt());
        drawSeparator();
        System.out.println("Please select color: ");
        showMenuFor(mappings.getColorMapping());
        String color = mappings.getColorMapping().get(scanner.nextInt());
        switch (garment){
            case "Pants":
                pantsSpecifics(size, material,color);
                break;
            case "Skirt":
                skirtSpecifics(size, material, color);
                break;
            case "T-Shirt":
                tShirtSpecifics(size, material, color);
                break;
            default:
                break;
        }
    }

    private void tShirtSpecifics(String size, String material, String color) {
        Scanner scanner = new Scanner(System.in);
        drawSeparator();
        System.out.println("Please select sleeves: ");
        showMenuFor(mappings.getSleevesMapping());
        String sleeves = mappings.getSleevesMapping().get(scanner.nextInt());
        drawSeparator();
        System.out.println("Please select neck");
        showMenuFor(mappings.getNeckMapping());
        String neck = mappings.getNeckMapping().get(scanner.nextInt());
        currentOrder.addToOrder(new TShirt(size, material, color, sleeves, neck));
        askUserIfDoneShopping();
//        makeTShirt(size, material, color, sleeves, neck);
    }

    private void makeTShirt(String size, String material, String color, String sleeves, String neck) {
        TShirtBuilder tShirtBuilder = new TShirtBuilder();
        tShirtBuilder.gettShirt().addPropertyChangeListener(ceo);
        tShirtBuilder.gettShirt().setBuilding(true);
        TShirt uniqueTShirt = tShirtBuilder.setSize(size).setMaterial(material).setSleeves(sleeves).setNeck(neck).build();
        FactorizePipeline factorizePipeline = new FactorizePipeline();
        factorizePipeline.addFactorizeCommand(new ColorCommand(color));
        uniqueTShirt = factorizePipeline.performAction(uniqueTShirt);
        uniqueTShirt.setId(wigellOrderId++);
        uniqueTShirt.setBuilding(false);
//        showReceipt(uniqueTShirt);
    }

    private void skirtSpecifics(String size, String material, String color) {
        Scanner scanner = new Scanner(System.in);
        drawSeparator();
        System.out.println("Please select waistline: ");
        showMenuFor(mappings.getWaistlineMapping());
        String waistline = mappings.getWaistlineMapping().get(scanner.nextInt());
        drawSeparator();
        System.out.println("Please select pattern: ");
        showMenuFor(mappings.getPatternMapping());
        String pattern = mappings.getPatternMapping().get(scanner.nextInt());
        currentOrder.addToOrder(new Skirt(size, material, color, waistline, pattern));
        askUserIfDoneShopping();
//        makeSkirt(size, material, color, waistline, pattern);
    }

    private void makeSkirt(String size, String material, String color, String waistline, String pattern) {
        // All information necessary for the garment is gathered
        SkirtsBuilder skirtsBuilder = new SkirtsBuilder();
        skirtsBuilder.getSkirt().addPropertyChangeListener(ceo);
        skirtsBuilder.getSkirt().setBuilding(true);
        Skirt uniqueSkirt = skirtsBuilder.setSize(size).setMaterial(material).setWaistline(waistline).setPattern(pattern).build();
        FactorizePipeline factorizePipeline = new FactorizePipeline();
        factorizePipeline.addFactorizeCommand(new ColorCommand(color));
        uniqueSkirt = factorizePipeline.performAction(uniqueSkirt);
        uniqueSkirt.setId(wigellOrderId++);
        uniqueSkirt.setBuilding(false);
//        showReceipt(uniqueSkirt);
    }


    private void pantsSpecifics(String size, String material, String color) {
        Scanner scanner = new Scanner(System.in);
        drawSeparator();
        System.out.println("Please select fit: ");
        showMenuFor(mappings.getFitMapping());
        String fit = mappings.getFitMapping().get(scanner.nextInt());
        drawSeparator();
        System.out.println("Please select length: ");
        showMenuFor(mappings.getLengthMapping());
        String length = mappings.getLengthMapping().get(scanner.nextInt());
        drawSeparator();
        System.out.println("Please select type: ");
        showMenuFor(mappings.getTypeMappings());
        String type = mappings.getTypeMappings().get(scanner.nextInt());
        currentOrder.addToOrder(new Pants(size, material, color, type, fit, length));
        askUserIfDoneShopping();
//        makePants(size, material, color, type, fit, length);
    }

    private void makePants(String size, String material, String color, String type, String fit, String length) {
        PantsBuilder pantsBuilder = new PantsBuilder();
        pantsBuilder.getPants().addPropertyChangeListener(ceo);
        pantsBuilder.getPants().setBuilding(true);
        Pants uniquePants = pantsBuilder.setSize(size).setMaterial(material).setType(type).setFit(fit).build();
        FactorizePipeline factorizePipeline = new FactorizePipeline();
        factorizePipeline.addFactorizeCommand(new LengthCutCommand(length));
        factorizePipeline.addFactorizeCommand(new ColorCommand(color));
        uniquePants = factorizePipeline.performAction(uniquePants);
        uniquePants.setId(wigellOrderId++);
        uniquePants.setBuilding(false);
//        showReceipt(uniquePants);
    }

    private void wigellsLogoSign(){
        System.out.println("\033[1;33m╔══════════════════════════╗");
        System.out.println("║ \033[0;95mWigells clothing factory\033[1;33m ║");
        System.out.println("╚══════════════════════════╝");
    }
    private void drawSeparator(){
        System.out.println("───────────────────────────────────────₩");
    }
    public void newCustomerOrder(){
        String fullname = "";
        Scanner scanner = new Scanner(System.in);
        wigellsLogoSign();
        System.out.print("\033[0;33m\nEnter your full name: ");
        boolean passed = false;
        while (!passed){
            fullname = scanner.nextLine();
            if(fullname.equals(""))
                System.out.println("You must enter something");
            else passed = true;
        }
        System.out.print("Your address: ");
        String address = scanner.nextLine();
        System.out.print("Your email: ");
        String email = scanner.nextLine();
        currentCustomer = new Customer(wigellCustomerId++, fullname, address, email);
        currentOrder = new Order(wigellOrderId++, currentCustomer);
        productSpecification();
    }
    private void showReceipt(){
        System.out.print(
                "╔═══════════════════════════════════════════" +
                        "\n║ ₩ Receipt for customer id " + currentCustomer.getId() +
                        ", order id " + currentOrder.getOrderId());
        for(Pants pants: currentOrder.getPantsSpecifications()){
            drawSeparator();
            System.out.print("║ Product name" + pants.getName() + "\n" +
                            "║ Product # " + pants.getId() + "\n" +
                            "║ ● Material " + pants.getMaterial() + "\n" +
                            "║ ● Size " + pants.getSize() + "\n" +
                            "║ ● Type " + pants.getType() + "\n" +
                            "║ ● Color " + pants.getColor() + "\n" +
                            "║ ● Fit " + pants.getFit() + "\n" +
                            "║ ● Length " + pants.getLength() + "\n"
            );
        }
        for(Skirt skirt: currentOrder.getSkirtsSpecifications()){
            drawSeparator();
            System.out.print("║ Product name" + skirt.getName() + "\n" +
                    "║ Product # " + skirt.getId() + "\n" +
                    "║ ● Material " + skirt.getMaterial() + "\n" +
                    "║ ● Size " + skirt.getSize() + "\n" +
                    "║ ● Color " + skirt.getColor() + "\n" +
                    "║ ● Waistline " + skirt.getWaistline() + "\n" +
                    "║ ● Pattern " + skirt.getPattern() + "\n"
            );
        }
        for(TShirt tShirt: currentOrder.gettShirtsSpecifications()){
            drawSeparator();
            System.out.print("║ Product name" + tShirt.getName() + "\n" +
                    "║ Product # " + tShirt.getId() + "\n" +
                    "║ ● Material " + tShirt.getMaterial() + "\n" +
                    "║ ● Size " + tShirt.getSize() + "\n" +
                    "║ ● Color " + tShirt.getColor() + "\n" +
                    "║ ● Sleeves " + tShirt.getSleeves() + "\n" +
                    "║ ● Neck " + tShirt.getNeck() + "\n"
            );
        }
        System.out.print("╟───────────────────────────────────────────₩\n" +
                "║ Shipping address:\n" +
                "║ Name: " + currentCustomer.getName() + "\n" +
                "║ Address: " + currentCustomer.getAddress() + "\n" +
                "║ Email: " + currentCustomer.getEmail() + "\n" +
                "╚═══════════════════════════════════════════\n");
    }
    private void showReceipt(Pants pants){
        System.out.print(
                "╔═══════════════════════════════════════════" +
                "\n║ ₩ Receipt for customer " + currentCustomer.getId() +
                " order, " + pants.getId() + "\n" +
                "║ " + pants.getMaterial() + " " +
                pants.getName().toLowerCase() + "\n" +
                "║ Size " + pants.getSize() + "\n" +
                "║ Type " + pants.getType() + "\n" +
                "║ Color " + pants.getColor() + "\n" +
                "║ Fit " + pants.getFit() + "\n" +
                "║ Length " + pants.getLength() + "\n" +
                "╟────────────────────────────────────────────\n" +
                "║ Shipping address:\n" +
                "║ Name: " + currentCustomer.getName() + "\n" +
                "║ Address: " + currentCustomer.getAddress() + "\n" +
                "║ Email: " + currentCustomer.getEmail() +
                "\n╚═══════════════════════════════════════════\n");
    }
    private void showReceipt(TShirt tShirt){
        System.out.print(
                "╔═══════════════════════════════════════════" +
                        "\n║ ₩ Receipt for customer " + currentCustomer.getId() +
                        " ,order " + tShirt.getId() + "\n" +
                        "║ " + tShirt.getMaterial() + " " +
                        tShirt.getName().toLowerCase() + "\n" +
                        "║ Size " + tShirt.getSize() + "\n" +
                        "║ Sleeves " + tShirt.getSleeves() + "\n" +
                        "║ Neck " + tShirt.getNeck() + "\n" +
                        "║ Color " + tShirt.getColor() + "\n" +
                        "╟────────────────────────────────────────────\n" +
                        "║ Shipping address:\n" +
                        "║ Name: " + currentCustomer.getName() + "\n" +
                        "║ Address: " + currentCustomer.getAddress() + "\n" +
                        "║ Email: " + currentCustomer.getEmail() +
                        "\n╚═══════════════════════════════════════════\n");
    }
    private void showReceipt(Skirt skirt){
        System.out.print(
                "╔═══════════════════════════════════════════" +
                        "\n║ ₩ Receipt for customer " + currentCustomer.getId() +
                        " ,order " + skirt.getId() + "\n" +
                        "║ " + skirt.getMaterial() + " " +
                        skirt.getName().toLowerCase() + "\n" +
                        "║ " + skirt.getName().toLowerCase() + "\n" +
                        "║ Size " + skirt.getSize() + "\n" +
                        "║ Type " + skirt.getWaistline() + "\n" +
                        "║ Color " + skirt.getColor() + "\n" +
                        "║ Fit " + skirt.getPattern() + "\n" +
                        "╟────────────────────────────────────────────\n" +
                        "║ Shipping address:\n" +
                        "║ Name: " + currentCustomer.getName() + "\n" +
                        "║ Address: " + currentCustomer.getAddress() + "\n" +
                        "║ Email: " + currentCustomer.getEmail() +
                        "\n╚═══════════════════════════════════════════\n");
    }

    public int getWigellOrderId() {
        return wigellOrderId;
    }

    public void setWigellOrderId(int wigellOrderId) {
        this.wigellOrderId = wigellOrderId;
    }
}
