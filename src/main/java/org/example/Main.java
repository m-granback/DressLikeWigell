package org.example;

import org.example.controller.Controller;
import org.example.view.View;

public class Main {
    public static void main(String[] args) {
        new Controller();
        new View().run(args);
    }
}