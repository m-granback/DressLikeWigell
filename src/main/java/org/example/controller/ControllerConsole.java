package org.example.controller;

import org.example.model.Customer;
import org.example.model.clothes.Pants;
import org.example.model.clothes.Skirt;
import org.example.model.clothes.TShirt;
import org.example.patterns.builder.PantsBuilder;
import org.example.patterns.builder.SkirtsBuilder;
import org.example.patterns.builder.TShirtBuilder;
import org.example.patterns.command.ColorCommand;
import org.example.patterns.command.FactorizePipeline;
import org.example.patterns.command.LengthCutCommand;
import org.example.patterns.observer.CEO;

import java.util.HashMap;
import java.util.Scanner;

public class ControllerConsole {
    private int wigellOrderId = 1000;
    private HashMap<Integer, String> garmentMapping = new HashMap<>(){{
        put(1,"Pants");
        put(2,"Skirt");
        put(3,"T-Shirt");
    }};
    private HashMap<Integer, String> sizeMapping = new HashMap<>(){{
        put(1,"Small");
        put(2,"Large");
    }};
    private HashMap<Integer, String> materialMapping = new HashMap<>(){{
        put(1, "Leather");
        put(2, "Cotton");
    }};
    private HashMap<Integer, String> colorMapping = new HashMap<>(){{
        put(1, "White");
        put(2, "Black");
    }};
    private HashMap<Integer, String> sleevesMapping = new HashMap<>(){{
        put(1, "Long");
        put(2, "Three quarters");
        put(3, "Short");
    }};
    private HashMap<Integer, String> neckMapping = new HashMap<>(){{
        put(1, "Tight");
        put(2, "Regular");
        put(3, "Loose");
    }};
    private CEO ceo = new CEO();
    private Customer customer;
    public ControllerConsole() {

    }
    private void showMenuFor(HashMap<Integer, String> hashMap){
        for(int i: hashMap.keySet()){
            System.out.println("[" + i + "] " + hashMap.get(i));
        }
        System.out.print("Choice: ");
    }
    private void productSpecification(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select garment:");
        showMenuFor(garmentMapping);
        String garment = garmentMapping.get(scanner.nextInt());
        System.out.println("Please select size: ");
        showMenuFor(sizeMapping);
        String size = sizeMapping.get(scanner.nextInt());
        System.out.println("Please select material: ");
        showMenuFor(materialMapping);
        String material = materialMapping.get(scanner.nextInt());
        System.out.println("Please select color: ");
        showMenuFor(colorMapping);
        String color = colorMapping.get(scanner.nextInt());
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
        System.out.print("Please select sleeves: ");
        showMenuFor(sleevesMapping);
        String sleeves = scanner.nextLine();
        System.out.print("Please select neck");
        showMenuFor(neckMapping);
        String neck = neckMapping.get(scanner.nextInt());
        makeTShirt(size, material, color, sleeves, neck);
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
        showReceipt(uniqueTShirt);
    }

    private void skirtSpecifics(String size, String material, String color) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(
                "Please select waistline\n" +
                        "[a] Extra low cut\n" +
                        "[b] Low cut\n" +
                        "[c] Over belly\n" +
                        "Choice: ");
        String waistline = scanner.nextLine();
        System.out.print(
                "Please select pattern\n" +
                        "[a] Dots\n" +
                        "[b] Stripes\n" +
                        "[c] Solid color\n" +
                        "Choice: ");
        String pattern = scanner.nextLine();
        makeSkirt(size, material, color, waistline, pattern);
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
        //--------------------------------------------------------------------------------------------------> Plagg klart
        showReceipt(uniqueSkirt);
    }


    private void pantsSpecifics(String size, String material, String color) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(
                "Please select fit\n" +
                        "[a] Slim fit\n" +
                        "[b] Tight\n" +
                        "[c] Loose\n" +
                        "Choice: ");
        String fit = scanner.nextLine();
        System.out.print(
                "Please select length\n" +
                        "[a] Shorts length\n" +
                        "[b] Full length\n" +
                        "[c] Extra long (folded up)\n" +
                        "Choice: ");
        String length = scanner.nextLine();
        System.out.print(
                "Please select type\n" +
                "[a] Bootcut\n" +
                "[b] Wide-leg\n" +
                "[c] Straight-leg\n" +
                "Choice: ");
        String type = scanner.nextLine();
        makePants(size, material, color, type, fit, length);
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
        showReceipt(uniquePants);
    }


    public void newCustomerOrder(){
        String fullname = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("[--Wigells clothing factory--]\n\n[New user]\nEnter your full name: ");
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
        customer = new Customer(fullname, address, email);
        productSpecification();
    }
    private void showReceipt(Pants pants){
        System.out.print(
                "Receipt for customer order " +
                pants.getId() + "\n" +
                pants.getMaterial() + " " +
                pants.getName().toLowerCase() + "\n" +
                "* Size " + pants.getSize() + "\n" +
                "* Type " + pants.getType() + "\n" +
                "* Color " + pants.getColor() + "\n" +
                "* Fit " + pants.getFit() + "\n" +
                "* Length " + pants.getLength());
    }
    private void showReceipt(TShirt tShirt){

    }
    private void showReceipt(Skirt skirt){

    }

    public int getWigellOrderId() {
        return wigellOrderId;
    }

    public void setWigellOrderId(int wigellOrderId) {
        this.wigellOrderId = wigellOrderId;
    }
}
