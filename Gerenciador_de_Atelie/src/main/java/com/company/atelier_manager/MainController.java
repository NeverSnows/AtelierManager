package com.company.atelier_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {

    @FXML
    private Button logOutBtn;

    @FXML
    void logOut(ActionEvent event) {
        AtelieManagerApplication.swapToLogIn();
    }

}
