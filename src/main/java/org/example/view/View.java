package org.example.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.MotionBlur;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.example.controller.Controller;
import org.example.model.Customer;

public class View extends Application {
    private Controller myController = new Controller();
    private final double WIDTH = 700;
    private final double HEIGHT = 400;
    private AnchorPane content;
    private Pane loginPane, leftPane, rightPane, pantsPane, tShirtsPane, skirtsPane;
//    private TableView<Customer> customerListView;


    public View() {
    }

    public View(Controller myController) {
        this.myController = myController;
//        myController.setMyViewer(this);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Dress like Wigell");
        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);
        stage.setResizable(false);
        content = new AnchorPane();
        loginPane = new Pane();
        leftPane = new Pane();
        pantsPane = new Pane();
        tShirtsPane = new Pane();
        skirtsPane = new Pane();
        RadioButton sizeSmallRadioButton = new RadioButton("small");
        RadioButton sizeMediumRadioButton = new RadioButton("medium");
        RadioButton sizeLargeRadioButton = new RadioButton("large");
        ToggleGroup pantsSizeGroup = new ToggleGroup();
        sizeSmallRadioButton.setToggleGroup(pantsSizeGroup);
        sizeMediumRadioButton.setToggleGroup(pantsSizeGroup);
        sizeLargeRadioButton.setToggleGroup(pantsSizeGroup);
        VBox leftPaneVBox = new VBox(20);
        Label newUserLabel = new Label("New user");
        Separator newUserSeparator = new Separator(Orientation.HORIZONTAL);
        Label nameLabel = new Label("Full name");
        Label addressLabel = new Label("Address");
        Label emailLabel = new Label("Email");
        Label pantsSizeLabel = new Label("Size");
        Label pantsTypeLabel = new Label("Type");
        Label pantsPriceLabel = new Label("Price");
        Label pantsMaterialLabel = new Label("Material");
        Label pantsColorLabel = new Label("Color");
        Label pantsFitLabel = new Label("Fit");
        Label pantsLengthLabel = new Label("Length");
        pantsSizeLabel.setLayoutX(50);
        pantsSizeLabel.setLayoutY(50);
        sizeSmallRadioButton.setLayoutX(50);
        sizeSmallRadioButton.setLayoutY(70);
        sizeMediumRadioButton.setLayoutX(130);
        sizeMediumRadioButton.setLayoutY(70);
        sizeLargeRadioButton.setLayoutX(210);
        sizeLargeRadioButton.setLayoutY(70);
        pantsTypeLabel.setLayoutX(50);
        pantsTypeLabel.setLayoutY(100);
        pantsPriceLabel.setLayoutX(50);
        pantsPriceLabel.setLayoutY(150);
        pantsMaterialLabel.setLayoutX(50);
        pantsMaterialLabel.setLayoutY(200);
        TextField nameTextField = new TextField();
        TextField addressTextField = new TextField();
        TextField emailTextField = new TextField();
        Button goShopButton = new Button("Go shop");
        Button pantsOrderButton = new Button("Order");
        pantsOrderButton.setLayoutX(250);
        pantsOrderButton.setLayoutY(250);
//        TableColumn<Customer, String> namesColumn = new TableColumn<>("Customer");
        RadioButton pantsRadioButton = new RadioButton("Pants");
        RadioButton tShirtsRadioButton = new RadioButton("TShirts");
        RadioButton skirtsRadioButton = new RadioButton("Skirts");
//        customerListView = new TableView<>();
        Scene scene = new Scene(content);

        content.getChildren().addAll(leftPane, pantsPane, loginPane);
        pantsPane.getChildren().addAll(
                pantsSizeLabel,
                sizeSmallRadioButton,
                sizeMediumRadioButton,
                sizeLargeRadioButton,
                pantsTypeLabel,
                pantsMaterialLabel,
                pantsColorLabel,
                pantsFitLabel,
                pantsLengthLabel,
                pantsPriceLabel,
                pantsOrderButton);
        loginPane.getChildren().addAll(
                newUserLabel,
                newUserSeparator,
                nameLabel,
                nameTextField,
                addressLabel,
                addressTextField,
                emailLabel,
                emailTextField,
                goShopButton);
        leftPane.getChildren().add(leftPaneVBox);
        leftPaneVBox.getChildren().addAll(pantsRadioButton, skirtsRadioButton, tShirtsRadioButton);
//        customerListView.getColumns().add(namesColumn);

        stage.setScene(scene);
        pantsPane.setVisible(false);
        leftPane.setPrefSize(WIDTH*0.3, HEIGHT);
        leftPane.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(0), new Insets(0))));
        leftPane.setEffect(new MotionBlur());
        pantsPane.setPrefSize(WIDTH*0.7, HEIGHT);
        pantsPane.setLayoutX(WIDTH*0.3);
        VBox.setMargin(pantsRadioButton, new Insets(150,0,0,50)); // top left down right
        VBox.setMargin(tShirtsRadioButton, new Insets(0,0,0,50));
        VBox.setMargin(skirtsRadioButton, new Insets(0,0,0,50));
        newUserLabel.setLayoutX((WIDTH/2)-50);
        newUserLabel.setLayoutY(HEIGHT/4);
        newUserLabel.setFont(new Font("Arial", 16));
        newUserSeparator.setLayoutX((WIDTH/2)-50);
        newUserSeparator.setLayoutY((HEIGHT/4)+20);
        newUserSeparator.setPrefWidth(200);
        nameLabel.setLayoutX((WIDTH/2)-50);
        nameLabel.setLayoutY((HEIGHT/4)+20);
        nameTextField.setLayoutX((WIDTH/2)-50);
        nameTextField.setLayoutY(HEIGHT/3);
        nameTextField.setPrefWidth(200);
        addressLabel.setLayoutX((WIDTH/2)-50);
        addressLabel.setLayoutY((HEIGHT/3)+30);
        addressTextField.setLayoutX((WIDTH/2)-50);
        addressTextField.setLayoutY((HEIGHT/3)+50);
        addressTextField.setPrefWidth(200);
        emailLabel.setLayoutX((WIDTH/2)-50);
        emailLabel.setLayoutY((HEIGHT/3)+80);
        emailTextField.setLayoutX((WIDTH/2)-50);
        emailTextField.setLayoutY((HEIGHT/3)+100);
        emailTextField.setPrefWidth(200);
        goShopButton.setLayoutX((WIDTH/2)-50);
        goShopButton.setLayoutY(HEIGHT/2+60);
        goShopButton.setOnAction(e->{
            storeCustomerInfo(nameTextField.getText(), addressTextField.getText(), emailTextField.getText());
        });
//        namesColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//        namesColumn.setPrefWidth(195);
        ToggleGroup radioButtonGroup = new ToggleGroup();
        pantsRadioButton.setToggleGroup(radioButtonGroup);
        skirtsRadioButton.setToggleGroup(radioButtonGroup);
        tShirtsRadioButton.setToggleGroup(radioButtonGroup);
        pantsRadioButton.setOnAction(e-> {
            System.out.println("Pants selected");
            pantsPane.setVisible(true);
        });
        tShirtsRadioButton.setOnAction(e-> System.out.println("TShirts selected"));
        skirtsRadioButton.setOnAction(e-> System.out.println("Skirts selected"));
//        customerListView.setPrefSize(WIDTH*0.28,HEIGHT*0.4);
//        customerListView.setLayoutX((WIDTH/2)-(customerListView.getPrefWidth()/2));
//        customerListView.setLayoutY((HEIGHT/2)-(customerListView.getPrefHeight()/2));
//        loadCustomers(customerListView);
        stage.show();
    }

    private void storeCustomerInfo(String name, String address, String email) {
        if(!name.equals("") && !address.equals("") && !email.equals("")) {
            leftPane.setEffect(null);
            loginPane.setVisible(false);
            myController.setCurrentCustomer(new Customer(name, address, email));
        }
    }


/*    private void loadCustomers(TableView<Customer> tableView) {
        tableView.setItems(myController.getRegisteredCustomers());
    }*/

    public void run(String[] args){
        launch(args);
    }

    public Controller getMyController() {
        return myController;
    }

    public void setMyController(Controller myController) {
        this.myController = myController;
    }

    public double getWIDTH() {
        return WIDTH;
    }

    public double getHEIGHT() {
        return HEIGHT;
    }

    public AnchorPane getContent() {
        return content;
    }

    public void setContent(AnchorPane content) {
        this.content = content;
    }

    public Pane getLoginPane() {
        return loginPane;
    }

    public void setLoginPane(Pane loginPane) {
        this.loginPane = loginPane;
    }

    public Pane getLeftPane() {
        return leftPane;
    }

    public void setLeftPane(Pane leftPane) {
        this.leftPane = leftPane;
    }

    public Pane getRightPane() {
        return rightPane;
    }

    public void setRightPane(Pane rightPane) {
        this.rightPane = rightPane;
    }
}
