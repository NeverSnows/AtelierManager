package com.company.atelier_manager.view_controllers;

import com.company.atelier_manager.AtelieManagerApplication;
import com.company.atelier_manager.DatabaseManager;
import com.company.atelier_manager.structure.Fabric;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NewFabricController {

    @FXML
    private Button cancelBtn;

    @FXML
    private Button createFabricBtn;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    void saveFabric(ActionEvent event) {
        String name = nameTextField.getText();
        String price = priceTextField.getText();

        if(!name.isBlank() && !price.isBlank()){
            try{
                priceTextField.setText("");
                double priceDouble = Double.parseDouble(price);

                Fabric fabric = new Fabric(name, priceDouble);
                DatabaseManager.registerFabric(fabric);
                nameTextField.setText("");
                AtelieManagerApplication.swapToMain();
            }catch(NumberFormatException ignored){}
        }
    }

    @FXML
    void swapToMain(ActionEvent event) {
        AtelieManagerApplication.swapToMain();
    }
}
