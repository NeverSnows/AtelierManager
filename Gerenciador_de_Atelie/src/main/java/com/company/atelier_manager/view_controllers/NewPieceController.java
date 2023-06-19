package com.company.atelier_manager.view_controllers;

import com.company.atelier_manager.AtelieManagerApplication;
import com.company.atelier_manager.DatabaseManager;
import com.company.atelier_manager.structure.Piece;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NewPieceController {

    @FXML
    private Button cancelBtn;

    @FXML
    private Button createPieceBtn;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    void savePiece(ActionEvent event) {
        String name = nameTextField.getText();
        String price = priceTextField.getText();

        if(!name.isBlank() && !price.isBlank()){
            try{
                priceTextField.setText("");
                double priceDouble = Double.parseDouble(price);

                Piece piece = new Piece(name, priceDouble);
                DatabaseManager.registerPiece(piece);
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
