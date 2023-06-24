package com.company.atelier_manager.view_controllers;

import com.company.atelier_manager.AtelieManagerApplication;
import com.company.atelier_manager.CurrentSessionSingleton;
import com.company.atelier_manager.DatabaseManager;
import com.company.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RecoveryEmailController {

    @FXML
    private TextField emailTextField;

    @FXML
    void returnToLogin(ActionEvent event) {
        emailTextField.setText("");
        AtelieManagerApplication.swapToLogIn();
    }

    @FXML
    void submitInfo(ActionEvent event) {
        String email = emailTextField.getText();
        if(!email.isBlank()){
            if(DatabaseManager.sendRecoveryCode(email)){
                CurrentSessionSingleton.getInstance().loggedUser = new User("", email, "");
                emailTextField.setText("");
                AtelieManagerApplication.swapToRecoveryCode();
            }
        }
    }
}
