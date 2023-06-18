package com.company.atelier_manager.view_controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class ViewFabricController {

    @FXML
    private CheckBox editDataChk;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    private Button returnBtn;

    @FXML
    private Button saveFabricBtn;

    @FXML
    void saveFabric(ActionEvent event) {

    }

    @FXML
    void swapToMain(ActionEvent event) {

    }

    @FXML
    void toggleEditData(ActionEvent event) {
        nameTextField.setDisable(false);
        priceTextField.setDisable(false);
    }

}
