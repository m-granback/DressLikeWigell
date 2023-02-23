package org.example.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.example.controller.Controller;
import org.example.model.Customer;

import java.beans.JavaBean;

public class View extends Application {
    private final int WIDTH = 700;
    private final int HEIGHT = 500;
    private AnchorPane content;
    private Pane loginPane, leftPane, rightPane;
    private TableView<Customer> customerListView;
    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Dress like Wigell");
        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);
        stage.setResizable(false);
        content = new AnchorPane();
        loginPane = new Pane();
        leftPane = new Pane();
        leftPane.setPrefSize(WIDTH*0.3, HEIGHT);
        leftPane.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(0), new Insets(0))));
        VBox leftPaneVBox = new VBox();
        RadioButton pantsRadioButton = new RadioButton("Pants");
        RadioButton tShirtsRadioButton = new RadioButton("TShirts");
        RadioButton skirtsRadioButton = new RadioButton("Skirts");
        ToggleGroup radioButtonGroup = new ToggleGroup();
        tShirtsRadioButton.setToggleGroup(radioButtonGroup);
        skirtsRadioButton.setToggleGroup(radioButtonGroup);
        pantsRadioButton.setToggleGroup(radioButtonGroup);
        leftPaneVBox.getChildren().addAll(pantsRadioButton, skirtsRadioButton, tShirtsRadioButton);
        leftPane.getChildren().add(leftPaneVBox);
        content.getChildren().addAll(leftPane/*,loginPane*/);
        Label userLabel = new Label("Available accounts");
        userLabel.setLayoutX((WIDTH/2)-50);
        userLabel.setLayoutY(HEIGHT/4);
        customerListView = new TableView<>();
        customerListView.setPrefSize(WIDTH*0.28,HEIGHT*0.4);
        loadCustomers();
        customerListView.setLayoutX((WIDTH/2)-(customerListView.getPrefWidth()/2));
        customerListView.setLayoutY((HEIGHT/2)-(customerListView.getPrefHeight()/2));
        TableColumn<Customer, String> namesColumn = new TableColumn<>("Customer");
        namesColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        namesColumn.setPrefWidth(195);
        customerListView.getColumns().add(namesColumn);
        loginPane.getChildren().addAll(userLabel, customerListView);
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
