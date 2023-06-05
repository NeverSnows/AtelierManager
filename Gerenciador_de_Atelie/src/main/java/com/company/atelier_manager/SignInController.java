package com.company.atelier_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignInController {

    @FXML
    private Button createAccountBtn;

    @FXML
    private TextField emailTextField;

    @FXML
    private Button logInBtn;

    @FXML
    private TextField nameTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void createAccount(ActionEvent event) {
        System.out.println("Name: " + nameTextField.getText() + "\nEmail: " + emailTextField.getText() + "\nPassword: " + passwordField.getText());

        if(DatabaseManager.registerUser(nameTextField.getText(), emailTextField.getText(), passwordField.getText())){
            AtelieManagerApplication.swapToMain();
        }

    }
    @FXML
    void swapToLogin(ActionEvent event) {
        AtelieManagerApplication.swapToLogIn();
    }

}
