package org.example;

import org.example.controller.ControllerConsole;
import org.example.model.Customer;

public class Main {
    private static Customer customer;
    public static void main(String[] args) {
//        new View(new Controller()).run(args);
        ControllerConsole controllerConsole = new ControllerConsole();
        controllerConsole.newCustomerOrder();

    }
}