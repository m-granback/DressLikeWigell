package org.example.controller;

import org.example.model.Customer;
import org.example.model.clothes.Skirt;
import org.example.model.clothes.TShirt;
import org.example.patterns.builder.SkirtsBuilder;
import org.example.patterns.builder.TShirtBuilder;
import org.example.patterns.command.ColorCommand;
import org.example.patterns.command.FactorizePipeline;
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
                        "[b] Short\n" +
                        "Choice: ");
        String sleeves = scanner.nextLine();
        System.out.print(
                "Please select neck\n" +
                        "[a] Tight\n" +
                        "[b] Loose\n" +
                        "Choice: ");
        String neck = scanner.nextLine();
        makeTShirt(size, material, color, sleeves, neck);
    }

    private void makeTShirt(String size, String material, String color, String sleeves, String neck) {
        TShirtBuilder tShirtBuilder = new TShirtBuilder();
        TShirt tShirt = tShirtBuilder.setMaterial(material).setSleeves(sleeves).setNeck(neck).build();
    }

    private void skirtSpecifics(String size, String material, String color) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(
                "Please select waistline\n" +
                        "[a] Low cut\n" +
                        "[b] Over belly\n" +
                        "Choice: ");
        String waistline = scanner.nextLine();
        System.out.print(
                "Please select pattern\n" +
                        "[a] Dots\n" +
                        "[b] Stripes\n" +
                        "Choice: ");
        String pattern = scanner.nextLine();
        makeSkirt(size, material, color, waistline, pattern);
    }

    private void makeSkirt(String size, String material, String color, String waistline, String pattern) {
        // All information necessary for the garment is gathered
        SkirtsBuilder skirtsBuilder = new SkirtsBuilder();
        Skirt uniqueSkirt = skirtsBuilder.setMaterial(material).setWaistline(waistline).setPattern(pattern).build();
        FactorizePipeline factorizePipeline = new FactorizePipeline();
        factorizePipeline.addFactorizeCommand(new ColorCommand(color));
        uniqueSkirt = factorizePipeline.performAction(uniqueSkirt);
        //--------------------------------------------------------------------------------------------------> Plagg klart
    }


    private void pantsSpecifics(String size, String material, String color) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(
                "Please select fit\n" +
                        "[a] Slim fit\n" +
                        "[b] Loose\n" +
                        "Choice: ");
        String fit = scanner.nextLine();
        System.out.print(
                "Please select length\n" +
                        "[a] Shorts\n" +
                        "[b] Full length\n" +
                        "Choice: ");
        String length = scanner.nextLine();
        makePants(size, material, color, fit, length);
    }

    private void makePants(String size, String material, String color, String fit, String length) {
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
