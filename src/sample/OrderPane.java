package sample;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

import javafx.scene.control.ListView;

import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class OrderPane extends Pane {
    private Label nameLabel;
    private Label orderLabel;
    private ListView orderListView;
    private Label deliveryInfoLabel;
    private Button quitButton;
    private Label rateLabel;
    private ComboBox comboBox;



    public Button getQuitButton() { return quitButton; }
    public ComboBox getComboBox() { return comboBox; }

    public OrderPane() {
        nameLabel = new Label();
        nameLabel.relocate(20, 30);
        nameLabel.setStyle("-fx-font: 16 arial; ");

        orderLabel = new Label("Here is your order:");
        orderLabel.relocate(nameLabel.getLayoutX(), nameLabel.getLayoutY()+25);
        orderLabel.setStyle("-fx-font: 13 arial; ");

        quitButton = new Button("Finish and go back to main menu");
        quitButton.relocate(570, 460);
        quitButton.resize(50,20);
        quitButton.setStyle("-fx-background-color: lightblue ;");

        orderListView = new ListView<Product>();
        orderListView.setPrefSize(300, 355);
        orderListView.relocate(orderLabel.getLayoutX(), orderLabel.getLayoutY()+20);

        Label delivery = new Label("Delievry Information:");
        delivery.setStyle("-fx-font: 18 arial; ");
        delivery.relocate(470, orderLabel.getLayoutY());


        deliveryInfoLabel = new Label("");
        deliveryInfoLabel.relocate(480, delivery.getLayoutY()+ 30);
        deliveryInfoLabel.setStyle("-fx-font: 15 arial; ");

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i <=5; i++) numbers.add(i);
        comboBox = new ComboBox(FXCollections.observableArrayList(numbers));
        comboBox.relocate(480, 335);
        comboBox.getSelectionModel().selectFirst();

        rateLabel = new Label("Please rate your courier");
        rateLabel.relocate(470, 300);
        rateLabel.setStyle("-fx-font: 18 arial; ");

        getChildren().setAll(nameLabel, orderLabel, deliveryInfoLabel, quitButton,orderListView, delivery, comboBox, rateLabel);
    }

    public void update(String name, ArrayList<Product> products, DeliveryPerson d, String time, String address, double total) {
        nameLabel.setText("Hey " + name + "!");
        orderListView.setItems(FXCollections.observableArrayList(products));
        deliveryInfoLabel.setText("Courier name: " + d.getUsername()  + '\n' + '\n' + "Courier ratings: " + String.format("%.2f", d.getRating()) + "/5"  + '\n' + '\n' + time +  '\n' + '\n' +
                address + '\n' + '\n' + "Total: " +  String.format("%.2f$",total));

    }

}
