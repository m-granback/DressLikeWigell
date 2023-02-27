package org.example;

import org.example.controller.Controller;
import org.example.model.Customer;

public class Main {
    private static Customer customer;
    public static void main(String[] args) {
//        new View(new Controller()).run(args);
        Controller controller = new Controller();
        controller.newCustomerOrder();

    }
}