package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.model.Customer;
import org.example.model.clothes.Size;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Controller {
    private ObservableList<Customer> registeredCustomers = FXCollections.observableArrayList();
    public Controller(){
        // Dummy data
        Customer customer1 = new Customer(1,"David","Matforsvägen 22 85655 Matfors", "david@gmail.com");
        Customer customer2 = new Customer(2,"Robert","Timråvägen 56 85788 Timrå", "robert@aol.com");
        registeredCustomers.add(customer1);
        registeredCustomers.add(customer2);
        Size size = Size.medium;
        if(size == Size.medium)
            System.out.println("hej");
        List<Size> availableSizes = Arrays.asList(Size.values());
        for(Size s : availableSizes){
            System.out.println(s);
        }
    }
    public ObservableList<Customer> getRegisteredCustomers() {
        return registeredCustomers;
    }
}