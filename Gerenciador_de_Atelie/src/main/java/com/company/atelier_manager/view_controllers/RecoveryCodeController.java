package com.company.atelier_manager.view_controllers;

import com.company.atelier_manager.AtelieManagerApplication;
import com.company.atelier_manager.CurrentSessionSingleton;
import com.company.atelier_manager.DatabaseManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RecoveryCodeController {

    @FXML
    private TextField codeTextField;

    @FXML
    void returnToRecoveryEmail() {
        codeTextField.setText("");
        AtelieManagerApplication.swapToRecoveryEmail();
    }

    @FXML
    void submitInfo() {
        String code = codeTextField.getText();
        if(!code.isBlank()){
            if(DatabaseManager.checkRecoveryCode(CurrentSessionSingleton.getInstance().loggedUser.getEmail(), code)){
                codeTextField.setText("");
                AtelieManagerApplication.swapToRecoverPassword();
            }
        }
    }
}
