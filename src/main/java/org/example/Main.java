package org.example;

import org.example.controller.Controller;
import org.example.controller.ControllerConsole;
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
        ControllerConsole controllerConsole = new ControllerConsole();
        controllerConsole.createCustomer();
        controllerConsole.chooseGarment();

    }
}