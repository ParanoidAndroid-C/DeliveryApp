package sample;

import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Collections;

public class MenuPane extends Pane {
    private Button goBack;
    private ListView<Product> listView;
    private Button addToCart;
    private ComboBox comboBox;
    private ArrayList<Product> displayProducts;



    public Button getGoBack() { return goBack; }
    public Button getAddToCart() { return addToCart; }
    public ListView<Product> getListView() { return listView; }
    public ComboBox getComboBox() { return  comboBox; }
    public ArrayList<Product> getDisplayProducts() { return displayProducts; }

    public MenuPane() {

        goBack = new Button("Go back to main menu");
        goBack.resize(120,40);
        goBack.relocate(10,435);
        goBack.setStyle("-fx-background-color: lightblue;");

        listView = new ListView<Product>();
        listView.relocate(40, 40);
        listView.setPrefSize(600,340);

        addToCart = new Button("Add to the cart");
        addToCart.resize(120, 40);
        addToCart.relocate(250, 420);
        addToCart.setDisable(true);
        addToCart.setStyle("-fx-background-color: lightblue;");

        Label label = new Label("Sort By:");
        label.relocate(40, 10);

        ArrayList<String > sortOptions = new ArrayList<String>();
        sortOptions.add("Name");
        sortOptions.add("Calories");
        sortOptions.add("Price");
        sortOptions.add("Ratings");
        comboBox = new ComboBox(FXCollections.observableArrayList(sortOptions));
        comboBox.relocate(100, 10);
        comboBox.getSelectionModel().selectFirst();



        getChildren().addAll(goBack,listView, addToCart, label, comboBox);

    }

    public void update(int a, ArrayList<Product> products) {
        displayProducts = new ArrayList<Product>();

        if (a == 1) {
            // dessert
            for (int i = 0; i < products.size(); i++)
                if  (products.get(i) instanceof Desserts) {
                    displayProducts.add(products.get(i));
                }
            listView.setItems(FXCollections.observableArrayList(displayProducts));
        }

        if (a == 2) {
            // Main dishes
           for (int i =0; i < products.size(); i++)
                if  (products.get(i) instanceof MainDishes) {
                    displayProducts.add(products.get(i));
                }
            listView.setItems(FXCollections.observableArrayList(displayProducts));

        }
        if (a == 3) {
            // fast food
           for (int i = 0; i < products.size(); i++)
                if (products.get(i) instanceof FastFood) {
                    displayProducts.add(products.get(i));
                }

            listView.setItems(FXCollections.observableArrayList(displayProducts));
        }
        if (a == 4) {
            // vegetarian
            for (int i = 0; i < products.size(); i++)
                if (products.get(i) instanceof VegetarianFood) {
                    displayProducts.add(products.get(i));
            }
            listView.setItems(FXCollections.observableArrayList(displayProducts));
        }
        if ( a == 5){
            // non alchoholic
            for (int i = 0; i < products.size(); i++)
                if  (products.get(i) instanceof NonAlcoholicDrinks) {
                    displayProducts.add(products.get(i));
            }
            listView.setItems(FXCollections.observableArrayList(displayProducts));
        }
        if (a == 6) {
            // alcoholic
            for (int i = 0; i < products.size(); i++)
                if (products.get(i) instanceof AlcoholicDrinks) {
                    displayProducts.add(products.get(i));
                }
            listView.setItems(FXCollections.observableArrayList(displayProducts));
        }

        this.setStyle("-fx-background-color: pink;");
    }


    public void sortList(ArrayList<Product> products, String selection) {
        if (selection.equals("Name")) {
            Product.sortStrategy = Product.SORT_BY_NAME;
            Collections.sort(products, Product::compareTo);
        }
        else if (selection.equals("Calories")) {
            Product.sortStrategy = Product.SORT_BY_CALORIES;
            Collections.sort(products, Product::compareTo);
        }
        else if (selection.equals("Price")) {
            Product.sortStrategy = Product.SORT_BY_PRICE;
            Collections.sort(products, Product::compareTo);

        }
        else if (selection.equals("Ratings")) {
            Product.sortStrategy = Product.SORT_BY_RATINGS;
            Collections.sort(products, Product::compareTo);
        }
        listView.setItems(FXCollections.observableArrayList(displayProducts));

    }
}
