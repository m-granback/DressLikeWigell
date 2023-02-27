package org.example.controller;

import org.example.model.Customer;
import org.example.patterns.builder.PantsBuilder;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ControllerGUI implements PropertyChangeListener {
    private Customer currentCustomer;

//    private View myViewer = new View();
    private int customerId = 0;
//    private ObservableList<Customer> registeredCustomers = FXCollections.observableArrayList();

    public ControllerGUI(){
        // Dummy data
//        Customer customer1 = new Customer(1,"David","Matforsvägen 22 85655 Matfors", "david@gmail.com");
//        Customer customer2 = new Customer(2,"Robert","Timråvägen 56 85788 Timrå", "robert@aol.com");
//        registeredCustomers.add(customer1);
//        registeredCustomers.add(customer2);
/*        Size size = Size.medium;
        if(size == Size.medium)
            System.out.println("hej");
        List<Size> availableSizes = Arrays.asList(Size.values());
        for(Size s : availableSizes){
            System.out.println(s);
        }*/
    }

/*    public ObservableList<Customer> getRegisteredCustomers() {
        return registeredCustomers;
    }*/


/*    public void setMyViewer(View myViewer) {
        this.myViewer = myViewer;
    }*/
    public void customerOrder(String clothes){
        switch(clothes){
            case "pants":
                PantsBuilder pantsBuilder = new PantsBuilder();
                break;
            case "tshirt":
                break;
            case "skirt":
                break;
            default:
                break;
        }
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        currentCustomer.setId(customerId++);
        this.currentCustomer = currentCustomer;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
