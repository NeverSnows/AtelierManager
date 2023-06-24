package com.company.atelier_manager.view_controllers;

import com.company.atelier_manager.AtelieManagerApplication;
import com.company.model.*;
import com.company.atelier_manager.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RegisterCustomerController implements Initializable {

    @FXML
    private Button addMeasureBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button deleteMeasureBtn;

    @FXML
    private TextField emailTextField;

    @FXML
    private ComboBox<MeasureCliente> measuresComboBox;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private TextField measureNameTextField;

    @FXML
    private TextField measureValueTextField;

    @FXML
    private Button registerBtn;

    @FXML
    void addMeasure(ActionEvent event) {
        String name = measureNameTextField.getText();
        String value = measureValueTextField.getText();

        if(!name.isBlank() && !value.isBlank()){
            MeasureCliente measure = new MeasureCliente(name, value);
            measuresComboBox.getItems().add(measure);

            measureNameTextField.setText("");
            measureValueTextField.setText("");
        }
    }

    @FXML
    void deleteMeasure(ActionEvent event) {
        try{
            measuresComboBox.getItems().remove(measuresComboBox.getSelectionModel().getSelectedIndex());
        }catch (IndexOutOfBoundsException ignored){}
    }

    @FXML
    void swapSelectedMeasure(ActionEvent event) {

    }

    @FXML
    void register(ActionEvent event) {
        String name = nameTextField.getText();
        String phone = phoneTextField.getText();
        String email = emailTextField.getText();
        List<MeasureCliente> measures = measuresComboBox.getItems();

        Customer customer = new Customer(name, phone, email, measures);

        for (MeasureCliente measure : measures) {
            measure.setCustomer(customer);
        }
        if(!name.isBlank() && !phone.isBlank() && !email.isBlank() && !measures.isEmpty()){
            DatabaseManager.registerCustomer(customer);
            AtelieManagerApplication.swapToMain();
            resetFields();
        }
    }

    @FXML
    void swapToMain(ActionEvent event) {
        AtelieManagerApplication.swapToMain();
        resetFields();
    }

    public void resetFields(){
        nameTextField.setText("");
        phoneTextField.setText("");
        emailTextField.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        measuresComboBox.setConverter(new StringConverter<MeasureCliente>() {
            @Override
            public String toString(MeasureCliente measure) {
                return measure.getNome() + ": " + measure.getTamanho();
            }

            @Override
            public MeasureCliente fromString(String s) {
                return null;
            }
        });
    }
}
