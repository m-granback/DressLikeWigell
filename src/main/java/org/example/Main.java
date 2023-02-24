package org.example;

import org.example.controller.Controller;
import org.example.model.Customer;
import org.example.model.clothes.Pants;
import org.example.model.clothes.Skirt;
import org.example.model.clothes.TShirt;
import org.example.patterns.builder.PantsBuilder;
import org.example.patterns.builder.SkirtsBuilder;
import org.example.patterns.builder.TShirtBuilder;
import org.example.view.View;

import java.util.Scanner;

public class Main {
    private static Customer customer;
    public static void main(String[] args) {
//        new View(new Controller()).run(args);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Wigells clothing factory\nNew user\nEnter your full name: ");
        String fullname = scanner.nextLine();
        System.out.print("Your address: ");
        String address = scanner.nextLine();
        System.out.print("Your email: ");
        String email = scanner.nextLine();
        System.out.print(
                "1. Pants\n" +
                "2. TShirt\n" +
                "3. Skirt\n");
        customer = new Customer(fullname, address, email);
        String choice = scanner.nextLine();
        switch(choice){
            case "1":
                PantsBuilder pantsBuilder = new PantsBuilder(new Pants()).addMaterial("sd").setFit("asd");
                System.out.println("Pants");
                break;
            case "2":
                TShirtBuilder tShirtBuilder = new TShirtBuilder(new TShirt());
                System.out.println("TShirt");
                break;
            case "3":
                SkirtsBuilder skirtsBuilder = new SkirtsBuilder(new Skirt());
                System.out.println("Skirt");
                break;
            default:
                break;
        }
    }
}