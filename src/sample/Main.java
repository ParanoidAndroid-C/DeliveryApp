package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Toggle;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class Main extends Application {
    User user;
    MapPane mapPane;
    LogInPane logInPane;
    RegisterPane registerPane;
    GeneralMenuPane generalMenuPane;
    Boolean newAddress = true;
    OrderPane orderPane;
    GenerateDeliveryPeople generateDeliveryPeople;
    int time = 0;
    GenerateGraph generateGraph;


    @Override
    public void start(Stage primaryStage) throws Exception {
        mapPane = new MapPane();
        logInPane = new LogInPane();
        registerPane = new RegisterPane();
        generalMenuPane = new GeneralMenuPane();
        orderPane = new OrderPane();
        generateGraph = new GenerateGraph();
        generateDeliveryPeople = new GenerateDeliveryPeople();

        logInPane.setStyle("-fx-background-color: pink;");
        registerPane.setStyle("-fx-background-color: pink;");
        generalMenuPane.setStyle("-fx-background-color: pink;");
        orderPane.setStyle("-fx-background-color: pink;");




        logInPane.getCreateAccount().setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                primaryStage.getScene().setRoot(registerPane);
            }
        });


        // Log in
        logInPane.getEnterButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                LogInAcitivity logInAcitivity = new LogInAcitivity();
                if (logInAcitivity.logInSuc(logInPane.getUsernameText().getText(), logInPane.getPasswordText().getText())) {
                    primaryStage.setTitle("Welcome " + logInPane.getUsernameText().getText() + "!");
                    primaryStage.getScene().setRoot(generalMenuPane);
                    user = new User(logInPane.getUsernameText().getText(), logInPane.getPasswordText().getText(), logInAcitivity.getAdress());
                    generalMenuPane.getAddress().setText("Delivery Address: " + user.getAddress());
                    int address = user.getAddress().charAt(0) - 64;
                    time = FindTime.getTime(generateGraph.getG(), address);
                    generalMenuPane.getEta().setText("ETA: " + time + " minutes");
                    generalMenuPane.getDeliveryFee().setText("Delivery Fee: " + time / 8 + "$");
                    newAddress = false;

                } else {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("Log In Error");
                    alert.setContentText("Password or username is wrong! Please, try again!");
                    alert.showAndWait();
                }
            }
        });

        // Sign up
        registerPane.getEnterButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                RegisterActivity registerActivity = new RegisterActivity();
                try {
                        if ((!(registerPane.getPasswordText().getText().isEmpty() || registerPane.getAddressText().getText().isEmpty() || registerPane.getUsernameText().getText().isEmpty() || registerPane.getEmailText().getText().isEmpty())) && (registerPane.getAddressText().getText().length() == 1 && (registerPane.getAddressText().getText().charAt(0) - 64) <= 10) && (registerActivity.signUp(registerPane.getUsernameText().getText(), registerPane.getPasswordText().getText(), registerPane.getAddressText().getText()))) {
                        primaryStage.setTitle("Welcome " + registerPane.getUsernameText().getText() + "!");
                        primaryStage.getScene().setRoot(generalMenuPane);
                        user = new User(registerPane.getUsernameText().getText(), registerPane.getPasswordText().getText(), registerPane.getAddressText().getText());
                        generalMenuPane.getAddress().setText("Delivery Address: " + user.getAddress());
                        registerPane.getEmailText().setText("");
                        registerPane.getPasswordText().setText("");
                        registerPane.getUsernameText().setText("");
                        registerPane.getAddressText().setText("");
                        int address = user.getAddress().charAt(0) - 64;
                        time = FindTime.getTime(generateGraph.getG(), address);
                        generalMenuPane.getEta().setText("ETA: " + time + " minutes");
                        generalMenuPane.getDeliveryFee().setText("Delivery Fee: " + time / 8 + "$");
                        newAddress = false;
                    } else {
                        if (registerPane.getPasswordText().getText().isEmpty() || registerPane.getAddressText().getText().isEmpty() || registerPane.getUsernameText().getText().isEmpty() || registerPane.getEmailText().getText().isEmpty()) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Error Dialog");
                            alert.setHeaderText("Sign Up Error");
                            alert.setContentText("Please Enter Valid Values");

                            alert.showAndWait();
                        } else {
                            if (registerPane.getAddressText().getText().charAt(0) > 74 || registerPane.getAddressText().getText().length() != 1) {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("Error Dialog");
                                alert.setHeaderText("Sign Up Error");
                                alert.setContentText("Please Enter Valid Address!");
                                alert.showAndWait();
                            } else {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("Error Dialog");
                                alert.setHeaderText("Sign Up Error");
                                alert.setContentText("This username is already taken : ( Please, try again!");

                                alert.showAndWait();
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // Sign out
        generalMenuPane.getSignout().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                generalMenuPane.getListView().getItems().clear();
                generalMenuPane.setProducts(new ArrayList<Product>());
                generalMenuPane.getTotal().setText("Total: 0.00$");
                generalMenuPane.setTot(0);
                logInPane.getPasswordText().setText("");
                logInPane.getUsernameText().setText("");
                primaryStage.getScene().setRoot(logInPane);
                primaryStage.setTitle("Welcome To Duma's Restaurant!");
                registerPane.getAddressText().setText("");
                newAddress = true;
            }
        });


        // Choose address on map
        registerPane.getAddFromMapButt().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                primaryStage.setTitle("Monte Cristo Map");
                primaryStage.getScene().setRoot(mapPane);
            }
        });

        mapPane.getGroup().selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov,
                                Toggle old_toggle, Toggle new_toggle) {
                if (mapPane.getGroup().getSelectedToggle() != null) {
                    String address = mapPane.getGroup().getSelectedToggle().toString();
                    address = String.valueOf(address.charAt(address.length() - 2));
                    registerPane.getAddressText().setText(address);
                    if (newAddress)
                        primaryStage.getScene().setRoot(registerPane);
                    else {
                        primaryStage.getScene().setRoot(generalMenuPane);
                        user.setAddress(address);
                        int address2 = user.getAddress().charAt(0) - 64;
                        time = FindTime.getTime(generateGraph.getG(), address2);
                        generalMenuPane.getEta().setText("ETA: " + time + " minutes");
                        generalMenuPane.getDeliveryFee().setText("Delivery Fee: " + time / 8 + "$");
                        generalMenuPane.getAddress().setText("Delivery Address: " + address);
                    }

                }
            }

        });

        // Menu
        MenuPane menuPane = new MenuPane();
        ArrayList<Product> products = GenerateMenu.generateMenu();

        generalMenuPane.getDesserts().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                menuPane.update(1, products);
                primaryStage.setTitle("Desserts");
                primaryStage.getScene().setRoot(menuPane);
            }
        });

        generalMenuPane.getMainDishes().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                menuPane.update(2, products);
                primaryStage.setTitle("Main Dishes");
                primaryStage.getScene().setRoot(menuPane);
            }
        });

        generalMenuPane.getFastFood().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                menuPane.update(3, products);
                primaryStage.setTitle("Fast Food");
                primaryStage.getScene().setRoot(menuPane);
            }
        });

        generalMenuPane.getVegetarian().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                menuPane.update(4, products);
                primaryStage.setTitle("Vegetarian");
                primaryStage.getScene().setRoot(menuPane);
            }
        });


        generalMenuPane.getNonalDrinks().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                menuPane.update(5, products);
                primaryStage.setTitle("Non Alcoholic Drinks");
                primaryStage.getScene().setRoot(menuPane);
            }
        });

        generalMenuPane.getAlcoholicDrinks().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                menuPane.update(6, products);
                primaryStage.setTitle("Alcoholic Drinks");
                primaryStage.getScene().setRoot(menuPane);
            }
        });

        menuPane.getGoBack().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                primaryStage.getScene().setRoot(generalMenuPane);
                primaryStage.setTitle("Main Menu");
                menuPane.getComboBox().getSelectionModel().selectFirst();

            }
        });

        menuPane.getListView().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                menuPane.getAddToCart().setDisable(false);
            }
        });

        // Add to cart
        menuPane.getAddToCart().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                Product selection = menuPane.getListView().getSelectionModel().getSelectedItem();
                if (selection != null) {
                    if (selection instanceof NonAlcoholicDrinks || selection instanceof Food) {
                        if (!((Temperature) selection).timeEnough(time)) {
                            Alert a = new Alert(Alert.AlertType.INFORMATION);
                            a.setTitle("Informaation alert");
                            a.setHeaderText("This item may get cold in " + ((Temperature) selection).getColdTime() + " minutes.");
                            a.setContentText("Delivery time is greater than it takes for this item to get cold : ( ");
                            a.setResizable(true);
                            a.showAndWait();
                        }
                    }
                    generalMenuPane.addToCart(selection);
                }
            }
        });

        generalMenuPane.getListView().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                Product selection = generalMenuPane.getListView().getSelectionModel().getSelectedItem();
                if (selection != null)
                    generalMenuPane.getRemove().setDisable(false);
            }
        });

        // Remove from cart
        generalMenuPane.getRemove().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                Product selection = generalMenuPane.getListView().getSelectionModel().getSelectedItem();
                if (selection != null) generalMenuPane.removeFromCart(selection);
            }
        });

        // Change address
        generalMenuPane.getChangeAddress().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setTitle("Monte Cristo Map");
                primaryStage.getScene().setRoot(mapPane);

            }
        });

        // Complete order
        generalMenuPane.getCheckout().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                orderPane.update(user.getUsername(), generalMenuPane.getProducts(), generateDeliveryPeople.getP(), generalMenuPane.getEta().getText(), generalMenuPane.getAddress().getText(), generalMenuPane.getTot() + time/8);
                primaryStage.getScene().setRoot(orderPane);
                primaryStage.setTitle("Thanks for ordering at Duma's Restaurant!");
            }
        });

        // Finish order and update courier ratings
        orderPane.getQuitButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                generalMenuPane.getListView().getItems().clear();
                generalMenuPane.setProducts(new ArrayList<Product>());
                generalMenuPane.getTotal().setText("Total: 0.00$");
                generalMenuPane.setTot(0);
                generalMenuPane.getCheckout().setDisable(true);
                try {
                    generateDeliveryPeople.update(generateDeliveryPeople.getP(), orderPane.getComboBox().getSelectionModel().getSelectedIndex() + 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                orderPane.getComboBox().getSelectionModel().selectFirst();
                primaryStage.getScene().setRoot(generalMenuPane);
                primaryStage.setTitle("Main Menu");
            }
        });

        // Sort menu
        menuPane.getComboBox().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String selection = menuPane.getComboBox().getValue().toString();
                menuPane.sortList(menuPane.getDisplayProducts(), selection);

            }
        });


        primaryStage.setTitle("Welcome To Duma's Restaurant!");
        primaryStage.setScene(new Scene(logInPane, 800, 500));
        primaryStage.getScene().getRoot().setStyle("-fx-background-color: pink;");
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
