package sample;

import javafx.collections.FXCollections;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import static javafx.collections.FXCollections.*;

public class GeneralMenuPane extends Pane {
    private Button desserts;
    private Button mainDishes;
    private Button fastFood;
    private Button vegetarian;
    private Button alcoholicDrinks;
    private Button nonalDrinks;
    private Label eat;
    private Label drinks;
    private Label myList;
    private ListView<Product> listView;
    private ArrayList<Product> products;
    private Label total;
    private Label address;
    private Button checkout;
    private Label eta;
    private Label deliveryFee;
    private double tot;
    private Button signout;
    private Button remove;
    private Button changeAddress;




    public Button getDesserts() { return desserts; }
    public Button getMainDishes() {return mainDishes; }
    public Button getFastFood() { return fastFood; }
    public Button getVegetarian() { return vegetarian; }
    public Button getAlcoholicDrinks() { return alcoholicDrinks; }
    public Button getNonalDrinks() { return nonalDrinks; }
    public ListView<Product> getListView() { return listView; }
    public Button getSignout() { return signout; }
    public Label getAddress() { return address; }
    public ArrayList<Product> getProducts() { return products; }
    public void setProducts(ArrayList<Product> products) { this.products = products; }
    public Label getTotal() { return total; }
    public Button getCheckout() { return checkout; }
    public Label getEta() { return eta; }
    public Label getDeliveryFee() { return deliveryFee; }
    public Button getRemove() { return remove; }
    public void setTot(double tot) {
        this.tot = tot;
    }
    public double getTot() { return tot; }

    public Button getChangeAddress() { return changeAddress; }

    public GeneralMenuPane() {
        int X = 100, Y = 60;

        eat = new Label("What do you want to eat today?");
        eat.relocate(70, 20);
        eat.setStyle("-fx-font: 16 arial; ");

        mainDishes = new Button(" Main\nDishes");
        mainDishes.relocate(X, Y);
        mainDishes.setPrefSize(120,80);
        mainDishes.setStyle("-fx-background-color: lightblue ;");

        desserts = new Button("Desserts");
        desserts.setPrefSize(120,80);
        desserts.relocate(X, Y+120);
        desserts.setStyle("-fx-background-color: lightblue ;");

        vegetarian = new Button("Vegetarian");
        vegetarian.setPrefSize(120, 80);
        vegetarian.relocate(X + 160, Y);
        vegetarian.setStyle("-fx-background-color: lightblue ;");

        fastFood = new Button("Fast\nFood");
        fastFood.setPrefSize(120, 80);
        fastFood.relocate(X+160, Y + 120);
        fastFood.setStyle("-fx-background-color: lightblue ;");

        drinks = new Label("Hmm any drinks?");
        drinks.setStyle("-fx-font: 16 arial; ");
        drinks.relocate(70, Y+ 230);

        nonalDrinks = new Button("Non Alcoholic\n    Drinks");
        nonalDrinks.setPrefSize(120, 80);
        nonalDrinks.relocate(X, Y + 265);
        nonalDrinks.setStyle("-fx-background-color: lightblue ;");

        alcoholicDrinks = new Button("Alcoholic\n  Drinks");
        alcoholicDrinks.setPrefSize(120,80);
        alcoholicDrinks.relocate(X+160, Y+265);
        alcoholicDrinks.setStyle("-fx-background-color: lightblue ;");

        myList = new Label("My order:");
        myList.setStyle("-fx-font: 16 arial; ");
        myList.relocate(450,20);

        products = new ArrayList<Product>();
        listView = new ListView<Product>();
        listView.relocate(450, 50);
        listView.setPrefSize(300, 355);

        checkout = new Button("Proceed To Checkout");
        checkout.resize(100, 30);
        checkout.relocate(listView.getLayoutX()+ 180, 460);
        checkout.setDisable(true);
        checkout.setStyle("-fx-background-color: lightblue ;");

        total = new Label("Total: 0.00$");
        total.relocate(listView.getLayoutX(), 410);

        address = new Label();
        address.relocate(total.getLayoutX(), 425);

        eta = new Label("Estimated time of arrival: ");
        eta.relocate(address.getLayoutX(), 440);

        deliveryFee = new Label("Delivery Fee:");
        deliveryFee.relocate(address.getLayoutX(), 455);

        signout = new Button("Sign Out");
        signout.relocate(10, 460);
        signout.setStyle("-fx-background-color: lightblue ;");

        remove = new Button("Remove from order");
        remove.resize(100, 30);
        remove.relocate(listView.getLayoutX()+ 180, 410);
        remove.setDisable(true);
        remove.setStyle("-fx-background-color: lightblue ;");

        changeAddress = new Button("Change Delivery Address");
        changeAddress.setStyle("-fx-font: 10 arial; ");
        changeAddress.relocate(address.getLayoutX(), 470);
        changeAddress.setStyle("-fx-background-color: lightblue ;");


        getChildren().addAll(desserts, mainDishes, vegetarian, fastFood, eat, drinks,nonalDrinks,alcoholicDrinks, myList,listView, checkout, total, address, eta, deliveryFee, signout, remove, changeAddress);
    }

    public void addToCart(Product p) {
        //System.out.println(p);
        tot += p.getPrice();
        total.setText("Total: " + String.format("%.2f$",tot));
        products.add(p);

        listView.setItems(FXCollections.observableArrayList(products));
        checkout.setDisable(false);
    }

    public void removeFromCart(Product p) {
        products.remove(p);
        listView.setItems(FXCollections.observableArrayList(products));
        tot -= p.getPrice();
        total.setText("Total: " + String.format("%.2f$",tot));
        if (products.isEmpty()) {
            checkout.setDisable(true);
            remove.setDisable(true);
        }
    }

}
