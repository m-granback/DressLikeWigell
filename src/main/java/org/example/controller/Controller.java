package org.example.controller;

import org.example.model.Customer;
import org.example.model.clothes.Pants;
import org.example.model.clothes.Skirt;
import org.example.model.clothes.TShirt;
import org.example.model.wigellStore.Order;
import org.example.model.wigellStore.Receipt;
import org.example.model.wigellStore.TemplateStorage;
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
    private int wigellOrderId = 1001;
    private int garmentId = 1;
    private int wigellCustomerId = 25001;
    private CEO ceo = new CEO();
    private Customer currentCustomer;
    private Order currentOrder;
    private TemplateStorage templateStorage = new TemplateStorage();
    private Mappings mappings = new Mappings();
    public Controller() {

    }
    public void run(){
        boolean doneShopping = false;
        newCustomerOrder();
        while (!doneShopping){
            productSpecification();
            doneShopping = askUserIfDoneShopping();
        }
        checkout();
    }
    private void selectionGarmentAttribute(HashMap<Integer, String> hashMap){
        for(int i: hashMap.keySet()){
            System.out.println("[" + i + "] " + hashMap.get(i));
        }
        System.out.print("Choice: ");
    }
    private boolean askUserIfDoneShopping(){
        Scanner scanner = new Scanner(System.in);
        drawSeparator();
        System.out.print("\033[0;31mDone shopping?\033[0;33m\n[1] Yes\n[2] No, I want to shop more\nChoice: ");
        return scanner.nextInt() == 1;
    }
    private void checkout(){
        while(!templateStorage.getPantsTemplates().isEmpty()){
            Pants pantsTemplate = templateStorage.getPantsTemplates().poll();
            makePants(pantsTemplate.getSize(), pantsTemplate.getMaterial(), pantsTemplate.getColor(), pantsTemplate.getType(), pantsTemplate.getFit(), pantsTemplate.getLength());
        }
        while (!templateStorage.getSkirtTemplates().isEmpty()){
            Skirt skirtTemplate = templateStorage.getSkirtTemplates().poll();
            makeSkirt(skirtTemplate.getSize(), skirtTemplate.getMaterial(), skirtTemplate.getColor(), skirtTemplate.getWaistline(), skirtTemplate.getPattern());
        }
        while (!templateStorage.gettShirtTemplates().isEmpty()){
            TShirt tShirtTemplate = templateStorage.gettShirtTemplates().poll();
            makeTShirt(tShirtTemplate.getSize(), tShirtTemplate.getMaterial(), tShirtTemplate.getColor(),tShirtTemplate.getSleeves(),tShirtTemplate.getNeck());
        }
        new Receipt().showReceipt(currentOrder, currentCustomer);
    }
    private void productSpecification(){
        Scanner scanner = new Scanner(System.in);
        drawSeparator();
        System.out.println("\033[0;93mPlease select garment:\033[0;33m");
        selectionGarmentAttribute(mappings.getGarmentMapping());
        String garment = mappings.getGarmentMapping().get(scanner.nextInt());
        drawSeparator();
        System.out.println("\033[0;93mPlease select size:\033[0;33m");
        selectionGarmentAttribute(mappings.getSizeMapping());
        String size = mappings.getSizeMapping().get(scanner.nextInt());
        drawSeparator();
        System.out.println("\033[0;93mPlease select material:\033[0;33m");
        selectionGarmentAttribute(mappings.getMaterialMapping());
        String material = mappings.getMaterialMapping().get(scanner.nextInt());
        drawSeparator();
        System.out.println("\033[0;93mPlease select color:\033[0;33m");
        selectionGarmentAttribute(mappings.getColorMapping());
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
        System.out.println("\033[0;93mPlease select sleeves:\033[0;33m");
        selectionGarmentAttribute(mappings.getSleevesMapping());
        String sleeves = mappings.getSleevesMapping().get(scanner.nextInt());
        drawSeparator();
        System.out.println("\033[0;93mPlease select neck:\033[0;33m");
        selectionGarmentAttribute(mappings.getNeckMapping());
        String neck = mappings.getNeckMapping().get(scanner.nextInt());
        TShirt tShirtTemplate = new TShirt(size, material, color, sleeves, neck);
        templateStorage.addToTemplates(tShirtTemplate);
    }
    private void makeTShirt(String size, String material, String color, String sleeves, String neck) {
        TShirtBuilder tShirtBuilder = new TShirtBuilder();
        tShirtBuilder.gettShirt().addPropertyChangeListener(ceo);
        TShirt uniqueTShirt = tShirtBuilder.setSize(size).setMaterial(material).setSleeves(sleeves).setNeck(neck).build();
        FactorizePipeline factorizePipeline = new FactorizePipeline();
        factorizePipeline.addFactorizeCommand(new ColorCommand(color));
        uniqueTShirt = factorizePipeline.performAction(uniqueTShirt);
        uniqueTShirt.setId(garmentId++);
        currentOrder.addToOrder(uniqueTShirt);
    }
    private void skirtSpecifics(String size, String material, String color) {
        Scanner scanner = new Scanner(System.in);
        drawSeparator();
        System.out.println("\033[0;93mPlease select waistline:\033[0;33m");
        selectionGarmentAttribute(mappings.getWaistlineMapping());
        String waistline = mappings.getWaistlineMapping().get(scanner.nextInt());
        drawSeparator();
        System.out.println("\033[0;93mPlease select pattern:\033[0;33m");
        selectionGarmentAttribute(mappings.getPatternMapping());
        String pattern = mappings.getPatternMapping().get(scanner.nextInt());
        Skirt skirtTemplate = new Skirt(size, material, color, waistline, pattern);
        templateStorage.addToTemplates(skirtTemplate);
    }
    private void makeSkirt(String size, String material, String color, String waistline, String pattern) {
        SkirtsBuilder skirtsBuilder = new SkirtsBuilder();
        skirtsBuilder.getSkirt().addPropertyChangeListener(ceo);
        Skirt uniqueSkirt = skirtsBuilder.setSize(size).setMaterial(material).setWaistline(waistline).setPattern(pattern).build();
        FactorizePipeline factorizePipeline = new FactorizePipeline();
        factorizePipeline.addFactorizeCommand(new ColorCommand(color));
        uniqueSkirt = factorizePipeline.performAction(uniqueSkirt);
        uniqueSkirt.setId(garmentId++);
        currentOrder.addToOrder(uniqueSkirt);
    }
    private void pantsSpecifics(String size, String material, String color) {
        Scanner scanner = new Scanner(System.in);
        drawSeparator();
        System.out.println("\033[0;93mPlease select fit:\033[0;33m");
        selectionGarmentAttribute(mappings.getFitMapping());
        String fit = mappings.getFitMapping().get(scanner.nextInt());
        drawSeparator();
        System.out.println("\033[0;93mPlease select length:\033[0;33m");
        selectionGarmentAttribute(mappings.getLengthMapping());
        String length = mappings.getLengthMapping().get(scanner.nextInt());
        drawSeparator();
        System.out.println("\033[0;93mPlease select type:\033[0;33m");
        selectionGarmentAttribute(mappings.getTypeMappings());
        String type = mappings.getTypeMappings().get(scanner.nextInt());
        Pants pantsTemplate = new Pants(size, material, color, type, fit, length);
        templateStorage.addToTemplates(pantsTemplate);
    }
    private void makePants(String size, String material, String color, String type, String fit, String length) {
        PantsBuilder pantsBuilder = new PantsBuilder();
        pantsBuilder.getPants().addPropertyChangeListener(ceo);
        Pants uniquePants = pantsBuilder.setSize(size).setMaterial(material).setType(type).setFit(fit).build();
        FactorizePipeline factorizePipeline = new FactorizePipeline();
        factorizePipeline.addFactorizeCommand(new LengthCutCommand(length));
        factorizePipeline.addFactorizeCommand(new ColorCommand(color));
        uniquePants = factorizePipeline.performAction(uniquePants);
        uniquePants.setId(garmentId++);
        currentOrder.addToOrder(uniquePants);
    }
    private void wigellsLogoSign(){
        System.out.println("\033[1;33m╔══════════════════════════╗");
        System.out.println("║ \033[1;95mWigells clothing factory\033[1;33m ║─►\033[0;33mClothes-on-demand\033[1;33m");
        System.out.println("╚══════════════════════════╝");
    }
    private void drawSeparator(){
        System.out.println("───────────────────────────────────────₩");
    }
    public void newCustomerOrder(){
        String fullname = "";
        Scanner scanner = new Scanner(System.in);
        wigellsLogoSign();
        System.out.print("\033[0;93m\nEnter your shipping address\033[0;33m\n\nFull name:\t\t");
        boolean passed = false;
        while (!passed){
            fullname = scanner.nextLine();
            if(fullname.equals(""))
                System.out.println("You must enter something");
            else passed = true;
        }
        System.out.print("Your address:\t");
        String address = scanner.nextLine();
        System.out.print("Your email:\t\t");
        String email = scanner.nextLine();
        currentCustomer = new Customer(wigellCustomerId++, fullname, address, email);
        currentOrder = new Order(wigellOrderId++, currentCustomer);
    }

}