package com.company.atelier_manager.view_controllers;

import com.company.atelier_manager.AtelieManagerApplication;
import com.company.atelier_manager.DatabaseManager;
import com.company.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NewModelController {

    @FXML
    private Button cancelBtn;

    @FXML
    private Button createModelBtn;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    void saveModel(ActionEvent event) {
        String name = nameTextField.getText();
        String price = priceTextField.getText();

        if(!name.isBlank() && !price.isBlank()){
            try{
                priceTextField.setText("");
                double priceDouble = Double.parseDouble(price);

                Model model = new Model(name, priceDouble);
                DatabaseManager.registerModel(model);
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
