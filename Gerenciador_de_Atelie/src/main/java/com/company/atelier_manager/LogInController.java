package com.company.atelier_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LogInController {

    @FXML
    private Button checkInBtn;

    @FXML
    private TextField emailTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signInBtn;

    @FXML
    void checkInInfo(ActionEvent event) {
        System.out.println(event.getEventType());
        System.out.println("Email: " + emailTextField.getText() + "\nPassword: " + passwordField.getText());

        if(DatabaseManager.validateUser(emailTextField.getText(), passwordField.getText())){
            AtelieManagerApplication.swapToMain();
        }
    }
    @FXML
    void swapToSignIn(ActionEvent event) {
        AtelieManagerApplication.swapToSignIn();
    }

}
