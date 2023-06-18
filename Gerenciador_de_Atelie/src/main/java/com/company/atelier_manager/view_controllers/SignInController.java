package com.company.atelier_manager.view_controllers;

import com.company.atelier_manager.AtelieManagerApplication;
import com.company.atelier_manager.DatabaseManager;
import com.company.atelier_manager.structure.User;
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
        String name = nameTextField.getText();
        String email = emailTextField.getText();
        String password = passwordField.getText();
        User user = new User(name, email, password);


        if(!name.isBlank() && !email.isBlank() && !password.isBlank() && DatabaseManager.registerUser(user)){
            AtelieManagerApplication.swapToMain();
            resetFields();
        }
    }
    @FXML
    void swapToLogin(ActionEvent event) {
        AtelieManagerApplication.swapToLogIn();
        resetFields();
    }

    public void resetFields(){
        nameTextField.setText("");
        emailTextField.setText("");
        passwordField.setText("");
    }

}
