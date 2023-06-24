package com.company.atelier_manager.view_controllers;

import com.company.atelier_manager.AtelieManagerApplication;
import com.company.atelier_manager.DatabaseManager;
import com.company.atelier_manager.CurrentSessionSingleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;
import com.company.model.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class NewPieceController implements Initializable{

    @FXML
    private Button cancelBtn;

    @FXML
    private Button createPieceBtn;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    private TextField measureNameTextField;

    @FXML
    private TextField measureValueTextField;

    @FXML
    private ComboBox<MeasurePeca> measureComboBox;

    @FXML
    private ComboBox<Model> modelComboBox;

    @FXML
    void addMeasure(ActionEvent event) {
        String name = measureNameTextField.getText();
        String value = measureValueTextField.getText();
        if(!name.isBlank() && !value.isBlank()){
            MeasurePeca measure = new MeasurePeca(name, value);
            measureComboBox.getItems().add(measure);
            measureNameTextField.setText("");
            measureValueTextField.setText("");
        }
    }

    @FXML
    void deleteMeasure(ActionEvent event) {
        measureComboBox.getItems().remove(measureComboBox.getSelectionModel().getSelectedIndex());
    }

    @FXML
    void savePiece(ActionEvent event) {
        String name = nameTextField.getText();
        String price = priceTextField.getText();
        List<MeasurePeca> measures = measureComboBox.getItems().stream().toList();
        Model model = modelComboBox.getSelectionModel().getSelectedItem();


        if(!name.isBlank() && !price.isBlank() && !measures.isEmpty() && model != null){
            try{
                priceTextField.setText("");
                double priceDouble = Double.parseDouble(price);

                Piece piece = new Piece(name, priceDouble, measures, model);

                for (MeasurePeca measure : measures) {
                    measure.setPiece(piece);
                }

                DatabaseManager.registerPiece(piece);
                measureComboBox.setItems(null);
                nameTextField.setText("");
                AtelieManagerApplication.swapToMain();
            }catch(NumberFormatException ignored){}
        }
    }

    @FXML
    void swapToMain(ActionEvent event) {
        AtelieManagerApplication.swapToMain();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        modelComboBox.setConverter(new StringConverter<Model>() {
            @Override
            public String toString(Model model) {
                return model.getName();
            }

            @Override
            public Model fromString(String s) {
                return null;
            }
        });
        modelComboBox.setItems(CurrentSessionSingleton.getInstance().observableModels);

        measureComboBox.setConverter(new StringConverter<MeasurePeca>() {
            @Override
            public String toString(MeasurePeca measure) {
                return measure.getNome();
            }

            @Override
            public MeasurePeca fromString(String s) {
                return null;
            }
        });
    }
}
