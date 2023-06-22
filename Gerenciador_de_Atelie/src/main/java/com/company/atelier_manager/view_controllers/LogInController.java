package com.company.atelier_manager.view_controllers;

import com.company.atelier_manager.AtelieManagerApplication;
import com.company.atelier_manager.CurrentSessionSingleton;
import com.company.atelier_manager.DatabaseManager;
import com.company.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LogInController {
    @FXML
    private TextField emailTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void changePassword(){

    }

    @FXML
    void checkInInfo(ActionEvent event) {
        String email = emailTextField.getText();
        String password = passwordField.getText();
        User user = new User(null, email, password);

        if(!email.isBlank() && !password.isBlank() && DatabaseManager.validateUser(user)){
            CurrentSessionSingleton.getInstance().loggedUser = DatabaseManager.getUserByEmail(email);
            AtelieManagerApplication.swapToMain();
            resetFields();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Invalid information");
            alert.setContentText("Invalid username/password.");
            alert.setHeaderText(alert.getTitle());
            alert.showAndWait();
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
