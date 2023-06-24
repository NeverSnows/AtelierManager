package com.company.atelier_manager.view_controllers;

import com.company.atelier_manager.AtelieManagerApplication;
import com.company.atelier_manager.CurrentSessionSingleton;
import com.company.atelier_manager.DatabaseManager;
import com.company.model.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ViewPieceController implements Initializable {

    @FXML
    private Button addMeasureBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button deleteMeasureBtn;

    @FXML
    private ComboBox<MeasurePeca> measureComboBox;

    @FXML
    private TextField measureNameTextField;

    @FXML
    private TextField measureValueTextField;

    @FXML
    private ComboBox<Model> modelComboBox;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField priceTextField;

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
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Modify Piece?");
        alert.setContentText("Do you wish to modify this piece?");
        alert.setHeaderText(alert.getTitle());

        String name = nameTextField.getText();
        String price = priceTextField.getText();
        Model model = modelComboBox.getValue();
        List<MeasurePeca> measures = measureComboBox.getItems();
        Piece selectedPiece = CurrentSessionSingleton.getInstance().observablePieces.get(CurrentSessionSingleton.getInstance().selectedTableIndex);

        if(!name.isBlank() && !price.isBlank() && !measures.isEmpty() && model != null){
            try{
                double priceDouble = Double.parseDouble(price);
                Optional<ButtonType> result = alert.showAndWait();
                if(result.isPresent() && result.get() == ButtonType.OK){
                    selectedPiece.setName(name);
                    selectedPiece.setValue(priceDouble);
                    selectedPiece.setModel(model);
                    selectedPiece.setMeasures(measures);

                    DatabaseManager.registerPiece(selectedPiece);
                    AtelieManagerApplication.swapToMain();
                }
            }catch(NumberFormatException ignored){}
        }
    }

    @FXML
    void swapToMain(ActionEvent event) {
        AtelieManagerApplication.swapToMain();
    }

    public void updatePieceInfo() throws IndexOutOfBoundsException{
        Piece selectedPiece = CurrentSessionSingleton.getInstance().observablePieces.get(CurrentSessionSingleton.getInstance().selectedTableIndex);
        nameTextField.setText(selectedPiece.getName());
        priceTextField.setText(String.valueOf(selectedPiece.getValue()));
        modelComboBox.setItems(CurrentSessionSingleton.getInstance().observableModels);
        modelComboBox.setValue(selectedPiece.getModel());
        measureComboBox.setItems(FXCollections.observableArrayList(selectedPiece.getMeasures()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        measureComboBox.setConverter(new StringConverter<MeasurePeca>() {
            @Override
            public String toString(MeasurePeca measure) {
                return measure.getNome() + ": " + measure.getTamanho();
            }

            @Override
            public MeasurePeca fromString(String s) {
                return null;
            }
        });
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
    }
}
