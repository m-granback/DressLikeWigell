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
    private int getUserInput(HashMap<Integer, String> hashMap){
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;
        boolean validInput = false;
        while(!validInput){
            try {
                userInput = scanner.nextInt();
                validInput = hashMap.containsKey(userInput);
            if(!validInput)
                System.out.println("Invalid choice.");
            } catch (Exception e){
                System.out.println("Invalid input, expected an integer.");
                scanner = new Scanner(System.in);
            }
        }
        return userInput;
    }
    private void selectionFromMapping(HashMap<Integer, String> hashMap){
        for(int i: hashMap.keySet()){
            System.out.println("[" + i + "] " + hashMap.get(i));
        }
        System.out.print("Choice: ");
    }
    private boolean askUserIfDoneShopping(){
        drawSeparator();
        System.out.println("\033[0;31mDone shopping?\033[0;33m");
        selectionFromMapping(mappings.getYesNoMapping());
        return mappings.getYesNoMapping().get(getUserInput(mappings.getYesNoMapping())).equals("Yes");
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
        drawSeparator();
        System.out.println("\033[0;93mPlease select garment:\033[0;33m");
        selectionFromMapping(mappings.getGarmentMapping());
        String garment = mappings.getGarmentMapping().get(getUserInput(mappings.getGarmentMapping()));
        drawSeparator();
        System.out.println("\033[0;93mPlease select size:\033[0;33m");
        selectionFromMapping(mappings.getSizeMapping());
        String size = mappings.getSizeMapping().get(getUserInput(mappings.getSizeMapping()));
        drawSeparator();
        System.out.println("\033[0;93mPlease select material:\033[0;33m");
        selectionFromMapping(mappings.getMaterialMapping());
        String material = mappings.getMaterialMapping().get(getUserInput(mappings.getMaterialMapping()));
        drawSeparator();
        System.out.println("\033[0;93mPlease select color:\033[0;33m");
        selectionFromMapping(mappings.getColorMapping());
        String color = mappings.getColorMapping().get(getUserInput(mappings.getColorMapping()));
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
                throw new RuntimeException("An error occurred when fetching mappings.");
        }
    }
    private void tShirtSpecifics(String size, String material, String color) {
        drawSeparator();
        System.out.println("\033[0;93mPlease select sleeves:\033[0;33m");
        selectionFromMapping(mappings.getSleevesMapping());
        String sleeves = mappings.getSleevesMapping().get(getUserInput(mappings.getSleevesMapping()));
        drawSeparator();
        System.out.println("\033[0;93mPlease select neck:\033[0;33m");
        selectionFromMapping(mappings.getNeckMapping());
        String neck = mappings.getNeckMapping().get(getUserInput(mappings.getNeckMapping()));
        TShirt tShirtTemplate = new TShirt(size, material, color, sleeves, neck);
        templateStorage.addToTemplates(tShirtTemplate);
    }
    private void makeTShirt(String size, String material, String color, String sleeves, String neck) {
        TShirtBuilder tShirtBuilder = new TShirtBuilder();
        tShirtBuilder.getTShirt().addPropertyChangeListener(ceo);
        TShirt uniqueTShirt = tShirtBuilder.setSize(size).setMaterial(material).setSleeves(sleeves).setNeck(neck).build();
        FactorizePipeline factorizePipeline = new FactorizePipeline();
        factorizePipeline.addFactorizeCommand(new ColorCommand(color));
        uniqueTShirt = factorizePipeline.performAction(uniqueTShirt);
        uniqueTShirt.setId(garmentId++);
        currentOrder.addToOrder(uniqueTShirt);
    }
    private void skirtSpecifics(String size, String material, String color) {
        drawSeparator();
        System.out.println("\033[0;93mPlease select waistline:\033[0;33m");
        selectionFromMapping(mappings.getWaistlineMapping());
        String waistline = mappings.getWaistlineMapping().get(getUserInput(mappings.getWaistlineMapping()));
        drawSeparator();
        System.out.println("\033[0;93mPlease select pattern:\033[0;33m");
        selectionFromMapping(mappings.getPatternMapping());
        String pattern = mappings.getPatternMapping().get(getUserInput(mappings.getPatternMapping()));
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
        drawSeparator();
        System.out.println("\033[0;93mPlease select fit:\033[0;33m");
        selectionFromMapping(mappings.getFitMapping());
        String fit = mappings.getFitMapping().get(getUserInput(mappings.getFitMapping()));
        drawSeparator();
        System.out.println("\033[0;93mPlease select length:\033[0;33m");
        selectionFromMapping(mappings.getLengthMapping());
        String length = mappings.getLengthMapping().get(getUserInput(mappings.getLengthMapping()));
        drawSeparator();
        System.out.println("\033[0;93mPlease select type:\033[0;33m");
        selectionFromMapping(mappings.getTypeMapping());
        String type = mappings.getTypeMapping().get(getUserInput(mappings.getTypeMapping()));
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
        System.out.println("\t\t\t\t\033[1;33m╔══════════════════════════╗");
        System.out.println("\t\t\t\t║ \033[1;95mWigells clothing factory\033[1;33m ║");
        System.out.println("\t\t\t\t╚══╤═══════════════════════╝");
        System.out.println("\t\t\t\t   └─►Clothes-on-demand");
    }
    private void drawSeparator(){
        System.out.println("───────────────────────────────────────₩");
    }
    private String stringCheck(String name){
        if(name.split(" ").length >= 2)
            return name;
        throw new RuntimeException("Name format incorrect");
    }
    private String getValidFullName(){
        Scanner scanner = new Scanner(System.in);
        String fullName = "";
        boolean validFullName = false;
        while (!validFullName){
            fullName = scanner.nextLine();
            validFullName = validFullNameCheck(fullName);
            if(!validFullName)
                System.out.print("That can't be your full name, try again\nFull name:\t\t");
        }
        return fullName;
    }
    private boolean validFullNameCheck(String fullName){
        return fullName.split(" ").length >= 2;
    }
    private String getValidEmail(){
        Scanner scanner = new Scanner(System.in);
        String email = "";
        boolean validEmail = false;
        while (!validEmail){
            email = scanner.nextLine();
            validEmail = validEmailCheck(email);
            if(!validEmail)
                System.out.print("Invalid format, try again\nYour email:\t\t");
        }
        return email;
    }
    private boolean validEmailCheck(String email){
        return email.split("@").length == 2 && email.split("@")[1].split("\\.").length >= 2;
    }
    public void newCustomerOrder(){
        Scanner scanner = new Scanner(System.in);
        wigellsLogoSign();
        System.out.print("\033[0;93m\nEnter your shipping address\033[0;33m\n\nFull name:\t\t");
        String fullname = getValidFullName();
        System.out.print("Your address:\t");
        String address = scanner.nextLine();
        System.out.print("Your email:\t\t");
        String email = getValidEmail();
        currentCustomer = new Customer(wigellCustomerId++, fullname, address, email);
        currentOrder = new Order(wigellOrderId++, currentCustomer);
    }

}