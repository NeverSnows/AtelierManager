package com.company.atelier_manager.view_controllers;

import com.company.atelier_manager.AtelieManagerApplication;
import com.company.atelier_manager.DatabaseManager;
import com.company.atelier_manager.structure.User;
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
        String email = emailTextField.getText();
        String password = passwordField.getText();
        User user = new User("", email, password);

        if(!email.isBlank() && !password.isBlank() && DatabaseManager.validateUser(user)){
            AtelieManagerApplication.swapToMain();
            resetFields();
        }
    }
    @FXML
    void swapToSignIn(ActionEvent event) {
        AtelieManagerApplication.swapToSignIn();
        resetFields();
    }
    public void resetFields(){
        emailTextField.setText("");
        passwordField.setText("");
    }
}
