package org.example.view;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.example.controller.Controller;
import org.example.model.Customer;

public class View extends Application {
    AnchorPane content;
    Pane loginPane;
    TableView<Customer> customerListView;
    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Dress like Wigell");
        stage.setWidth(900);
        stage.setHeight(700);
        stage.setResizable(false);
        content = new AnchorPane();
        loginPane = new Pane();
        content.getChildren().add(loginPane);
        Label userLabel = new Label("Select user");
        userLabel.setLayoutX(30);
        userLabel.setLayoutY(50);
        customerListView = new TableView<>();
        customerListView.setPrefSize(200,200);
        loadCustomers();
//        TextField userTextField = new TextField();
        customerListView.setLayoutX(30);
        customerListView.setLayoutY(80);
        TableColumn<Customer, String> namesColumn = new TableColumn<>("Customer");
        customerListView.getColumns().add(namesColumn);


/*        customerListView.cellFactoryProperty(new Callback<ListView<Customer>, ListCell<Customer>>() {
            @Override
            public ListCell<Customer> call(ListView<Customer> ignore) {
                ListCell<Customer> cell = new ListCell<>(){
                    @Override
                    public void updateItem(Customer item, boolean empty){
                        super.updateItem(item, empty);
                        setGraphic(item.getName());
                    }
                };
                return cell;
            }
        });*/
//        userTextField.setPromptText("Enter your username");
        loginPane.getChildren().addAll(userLabel, customerListView);
//        upperRegionHBox.getChildren().addAll(userLabel,userTextField);
        Scene scene = new Scene(content);
        stage.setScene(scene);
        stage.show();
    }

    private void loadCustomers() {
        customerListView.setItems(new Controller().getRegisteredCustomers());
    }

    public void run(String[] args){
        launch(args);
    }
}
