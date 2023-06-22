package com.company.atelier_manager.view_controllers;

import com.company.atelier_manager.AtelieManagerApplication;
import com.company.atelier_manager.CurrentSessionSingleton;
import com.company.atelier_manager.DatabaseManager;
import com.company.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Invalid information");
        alert.setHeaderText(alert.getTitle());
        if(!name.isBlank() && !email.isBlank() && !password.isBlank()){
            if(DatabaseManager.registerUser(user)){
                CurrentSessionSingleton.getInstance().loggedUser = DatabaseManager.getUserByEmail(email);
                AtelieManagerApplication.swapToMain();
                resetFields();
            }else{
                alert.setTitle("User already exists.");
            }
        }else{
            alert.setContentText("Fields must not be blank.");
            alert.showAndWait();
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
