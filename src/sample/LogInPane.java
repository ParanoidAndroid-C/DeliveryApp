package sample;

import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.*;

public class LogInPane extends Pane {
    private Label usernameLabel;
    private Label passwordLabel;
    private Button enterButton;
    private Label createAccount;
    private TextField usernameText;
    private PasswordField passwordText;

    public Button getEnterButton() { return enterButton; }

    public Label getCreateAccount() { return createAccount; }

    public TextField getUsernameText() { return usernameText; }

    public PasswordField getPasswordText() { return passwordText; }

    public LogInPane() {

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

        enterButton = new Button("Sign In");
        enterButton.relocate(350, 400);
        enterButton.setPrefSize(80, 30);
        enterButton.setStyle("-fx-background-color: lightblue ;");

        createAccount = new Label("Don't have an account? Click here to create one!");
        createAccount.relocate(280, 435);


        getChildren().addAll(usernameLabel, passwordLabel, enterButton, createAccount, passwordText, usernameText);
    }

}
