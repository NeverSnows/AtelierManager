package com.company.atelier_manager.view_controllers;

import com.company.atelier_manager.AtelieManagerApplication;
import com.company.atelier_manager.CurrentSessionSingleton;
import com.company.atelier_manager.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

public class RecoverPasswordController {

    @FXML
    private PasswordField passwordField;

    @FXML
    void returnToRecoveryCode(ActionEvent event) {
        passwordField.setText("");
        AtelieManagerApplication.swapToRecoveryCode();
    }

    @FXML
    void submitInfo(ActionEvent event) {
        String password = passwordField.getText();
        if(!password.isBlank()){
            if(DatabaseManager.changePassword(CurrentSessionSingleton.getInstance().loggedUser.getEmail(), password)){
                CurrentSessionSingleton.getInstance().loggedUser = null;
                passwordField.setText("");
                AtelieManagerApplication.swapToLogIn();
            }
        }
    }
}
