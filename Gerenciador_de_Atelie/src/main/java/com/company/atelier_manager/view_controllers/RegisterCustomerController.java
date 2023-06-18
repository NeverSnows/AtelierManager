package com.company.atelier_manager.view_controllers;

import com.company.atelier_manager.AtelieManagerApplication;
import com.company.atelier_manager.structure.Customer;
import com.company.atelier_manager.DatabaseManager;
import com.company.atelier_manager.structure.Measure;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class RegisterCustomerController {

    @FXML
    private Button addMeasureBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button deleteMeasureBtn;

    @FXML
    private TextField emailTextField;

    @FXML
    private ComboBox<String> measuresComboBox;

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
    private final List<Measure> measures = new ArrayList<>();
    @FXML
    void addMeasure(ActionEvent event) {
        String name = measureNameTextField.getText();
        String value = measureValueTextField.getText();

        if(!name.isBlank() && !value.isBlank()){
            Measure measure = new Measure(name, value);
            measures.add(measure);
            measuresComboBox.getItems().add(measure.getName() + ": " + measure.getSize());
            measureNameTextField.setText("");
            measureValueTextField.setText("");
        }
    }

    @FXML
    void deleteMeasure(ActionEvent event) {
        try{
            measures.remove(measuresComboBox.getSelectionModel().getSelectedIndex());
            measuresComboBox.getItems().remove(measuresComboBox.getSelectionModel().getSelectedIndex());
        }catch (IndexOutOfBoundsException exception){
            System.out.println("No measures to be deleted.");
        }
    }

    @FXML
    void swapSelectedMeasure(ActionEvent event) {

    }

    @FXML
    void register(ActionEvent event) {
        String name = nameTextField.getText();
        String phone = phoneTextField.getText();
        String email = emailTextField.getText();
        Customer customer = new Customer(name, phone, email, measures);

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

}
