package com.company.atelier_manager.view_controllers;

import com.company.atelier_manager.AtelieManagerApplication;
import com.company.atelier_manager.CurrentSessionSingleton;
import com.company.atelier_manager.DatabaseManager;
import com.company.model.Fabric;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

public class ViewFabricController {
    @FXML
    private TextField nameTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    private Button returnBtn;

    @FXML
    private Button saveFabricBtn;

    @FXML
    void saveFabric(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Modify Fabric?");
        alert.setContentText("Do you wish to modify this fabric?");
        alert.setHeaderText(alert.getTitle());

        String name = nameTextField.getText();
        String value = priceTextField.getText();
        Fabric selectedFabric = CurrentSessionSingleton.getInstance().observableFabrics.get(CurrentSessionSingleton.getInstance().selectedTableIndex);

        if(!name.isBlank() && !value.isBlank()){
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent() && result.get() == ButtonType.OK ){
                try{
                    priceTextField.setText("");
                    double valueDouble = Double.parseDouble(value);
                    selectedFabric.setName(name);
                    selectedFabric.setValue(valueDouble);

                    DatabaseManager.registerFabric(selectedFabric);
                    AtelieManagerApplication.swapToMain();
                }catch (NumberFormatException ignored){}
            }
        }
    }

    public void updateFabricInfo() throws IndexOutOfBoundsException{
        Fabric selectedFabric = CurrentSessionSingleton.getInstance().observableFabrics.get(CurrentSessionSingleton.getInstance().selectedTableIndex);
        nameTextField.setText(selectedFabric.getName());
        priceTextField.setText(String.valueOf(selectedFabric.getValue()));
    }

    @FXML
    void swapToMain(ActionEvent event) {
        AtelieManagerApplication.swapToMain();
    }
}
