package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class RegisterPane extends Pane {
    private Label emailLabel;
    private Label addressLabel;
    private TextField emailText;
    private TextField addressText;
    private Button addFromMapButt;
    private Label usernameLabel;
    private Label passwordLabel;
    private Button enterButton;
    private TextField usernameText;
    private PasswordField passwordText;


    public Button getEnterButton() { return enterButton; }
    public TextField getUsernameText() { return usernameText; }
    public PasswordField getPasswordText() { return passwordText; }
    public TextField getAddressText() { return addressText; }
    public Button getAddFromMapButt() { return addFromMapButt; }
    public TextField getEmailText() { return emailText; }

    public RegisterPane() {
        usernameLabel = new Label("Username:");
        usernameLabel.relocate(100, 140);
        usernameLabel.setStyle("-fx-font: 16 arial; ");

        usernameText = new TextField();
        usernameText.relocate(200, 140);
        usernameText.setStyle("-fx-background-color: lightblue ;");

        passwordLabel = new Label("Password:");
        passwordLabel.relocate(100, 200);
        passwordLabel.setStyle("-fx-font: 16 arial; ");

        passwordText = new PasswordField();
        passwordText.relocate(200, 200);
        passwordText.setStyle("-fx-background-color: lightblue ;");

        enterButton = new Button("Sign Up");
        enterButton.relocate(350, 400);
        enterButton.setPrefSize(80, 30);
        enterButton.setStyle("-fx-background-color: lightblue ;");


        emailLabel  = new Label("Email:");
        emailLabel.relocate(400, 140);
        emailLabel.setStyle("-fx-font: 16 arial; ");

        emailText = new TextField();
        emailText.relocate(500, 140);
        emailText.setStyle("-fx-background-color: lightblue ;");


        addressLabel = new Label("Address:");
        addressLabel.relocate(400, 200);
        addressLabel.setStyle("-fx-font: 16 arial; ");

        addressText = new TextField();
        addressText.relocate(500, 200);
        addressText.setStyle("-fx-background-color: lightblue ;");

        addFromMapButt = new Button("Choose on map");
        addFromMapButt.relocate(653, 200);
        addFromMapButt.resize(80, 30);
        addFromMapButt.setStyle("-fx-font: 8 arial; ");
        addFromMapButt.setStyle("-fx-background-color: lightblue ;");


        getChildren().addAll(usernameLabel, passwordLabel, enterButton, passwordText, usernameText, emailLabel, addressLabel, emailText, addressText, addFromMapButt);

    }
}
