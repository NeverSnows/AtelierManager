package com.company.atelier_manager.view_controllers;

import com.company.atelier_manager.AtelieManagerApplication;
import com.company.atelier_manager.CurrentSessionSingleton;
import com.company.atelier_manager.DatabaseManager;
import com.company.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.util.Optional;

public class ViewModelController {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    void saveModel(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Modify Model?");
        alert.setContentText("Do you wish to modify this model?");
        alert.setHeaderText(alert.getTitle());

        String name = nameTextField.getText();
        String price = priceTextField.getText();
        Model selectedModel = CurrentSessionSingleton.getInstance().observableModels.get(CurrentSessionSingleton.getInstance().selectedTableIndex);

        if(!name.isBlank() && !price.isBlank()){
            try{
                priceTextField.setText("");
                double priceDouble = Double.parseDouble(price);
                Optional<ButtonType> result = alert.showAndWait();
                if(result.isPresent() && result.get() == ButtonType.OK){
                    selectedModel.setNome(name);
                    selectedModel.setPreco(priceDouble);

                    DatabaseManager.registerModel(selectedModel);
                    AtelieManagerApplication.swapToMain();
                }
            }catch (NumberFormatException ignored){}
        }
    }

    @FXML
    void swapToMain(ActionEvent event) {
        AtelieManagerApplication.swapToMain();
    }

    public void updateModelInfo() throws IndexOutOfBoundsException{
        Model selectedModel = CurrentSessionSingleton.getInstance().observableModels.get(CurrentSessionSingleton.getInstance().selectedTableIndex);
        nameTextField.setText(selectedModel.getNome());
        priceTextField.setText(String.valueOf(selectedModel.getPreco()));
    }
}
