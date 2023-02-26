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
import org.example.patterns.observer.CEOObserver;

import java.util.Scanner;

public class ControllerConsole {

    private CEOObserver ceoObserver = new CEOObserver();
    private Customer customer;
    public ControllerConsole() {

    }
    private void chooseGarment(){
        Scanner scanner = new Scanner(System.in);
        System.out.print(
                "Please select garment\n" +
                "[a] Pants\n" +
                "[b] Skirt\n" +
                "[c] TShirt\n" +
                "Choice: ");
        String garment = scanner.nextLine();
        System.out.print(
                "Please select size\n" +
                        "[a] Small\n" +
                        "[b] Large\n" +
                        "Choice: ");
        String size = scanner.nextLine();
        System.out.print(
                "Please select material\n" +
                        "[a] Leather\n" +
                        "[b] Cotton\n" +
                        "Choice: ");
        String material = scanner.nextLine();
        System.out.print(
                "Please select color\n" +
                        "[a] White\n" +
                        "[b] Black\n" +
                        "Choice: ");
        String color = scanner.nextLine();
        switch (garment){
            case "a":
                pantsSpecifics(size, material,color);
                break;
            case "b":
                skirtSpecifics(size, material, color);
                break;
            case "c":
                tShirtSpecifics(size, material, color);
                break;
            default:
                break;
        }
    }

    private void tShirtSpecifics(String size, String material, String color) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(
                "Please select sleeves\n" +
                        "[a] Long\n" +
                        "[b] Three quarters\n" +
                        "[c] Short\n" +
                        "Choice: ");
        String sleeves = scanner.nextLine();
        System.out.print(
                "Please select neck\n" +
                        "[a] Tight\n" +
                        "[b] Regular\n" +
                        "[c] Loose\n" +
                        "Choice: ");
        String neck = scanner.nextLine();
        makeTShirt(size, material, color, sleeves, neck);
    }

    private void makeTShirt(String size, String material, String color, String sleeves, String neck) {
        TShirtBuilder tShirtBuilder = new TShirtBuilder();
        tShirtBuilder.gettShirt().addPropertyChangeListener(ceoObserver);
        tShirtBuilder.gettShirt().setBuilding(true);
        TShirt uniqueTShirt = tShirtBuilder.setSize(size).setMaterial(material).setSleeves(sleeves).setNeck(neck).build();
        FactorizePipeline factorizePipeline = new FactorizePipeline();
        factorizePipeline.addFactorizeCommand(new ColorCommand(color));
        uniqueTShirt = factorizePipeline.performAction(uniqueTShirt);
        uniqueTShirt.setBuilding(false);
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
        skirtsBuilder.getSkirt().addPropertyChangeListener(ceoObserver);
        Skirt uniqueSkirt = skirtsBuilder.setSize(size).setMaterial(material).setWaistline(waistline).setPattern(pattern).build();
        FactorizePipeline factorizePipeline = new FactorizePipeline();
        factorizePipeline.addFactorizeCommand(new ColorCommand(color));
        uniqueSkirt = factorizePipeline.performAction(uniqueSkirt);
        uniqueSkirt.setBuilding(false);
        //--------------------------------------------------------------------------------------------------> Plagg klart
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
                        "[c] Extra long (folded up)" +
                        "Choice: ");
        String length = scanner.nextLine();
        System.out.println(
                "Please select type\n" +
                "[a] Bootcut" +
                "[b] Wide-leg" +
                "[c] Straight-leg");
        String type = scanner.nextLine();
        makePants(size, material, color, type, fit, length);
    }

    private void makePants(String size, String material, String color, String type, String fit, String length) {
        PantsBuilder pantsBuilder = new PantsBuilder();
        pantsBuilder.getPants().addPropertyChangeListener(ceoObserver);
        Pants uniquePants = pantsBuilder.setSize(size).setMaterial(material).setType(type).setFit(fit).build();
        FactorizePipeline factorizePipeline = new FactorizePipeline();
        factorizePipeline.addFactorizeCommand(new LengthCutCommand(length));
        factorizePipeline.addFactorizeCommand(new ColorCommand(color));
        uniquePants = factorizePipeline.performAction(uniquePants);
        uniquePants.setBuilding(false);
    }


    public void newCustomerOrder(){
        String fullname = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Wigells clothing factory\nNew user\nEnter your full name: ");
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
        chooseGarment();
    }
}
