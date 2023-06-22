package com.company.atelier_manager.view_controllers;

import com.company.atelier_manager.AtelieManagerApplication;
import com.company.atelier_manager.CurrentSessionSingleton;
import com.company.atelier_manager.DatabaseManager;
import com.company.model.*;
import com.company.model.MeasureCliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ViewCustomerController implements Initializable {

    @FXML
    private Button addMeasureBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button deleteMeasureBtn;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField measureNameTextField;

    @FXML
    private TextField measureValueTextField;

    @FXML
    private ComboBox<MeasureCliente> measuresComboBox;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private Button saveBtn;

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
    void saveCustomer(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Modify Customer?");
        alert.setContentText("Do you wish to modify this customer?");
        alert.setHeaderText(alert.getTitle());

        String name = nameTextField.getText();
        String phone = phoneTextField.getText();
        String email = emailTextField.getText();
        List<MeasureCliente> measures = measuresComboBox.getItems();
        Customer selectedCustomer = CurrentSessionSingleton.getInstance().observableCustomers.get(CurrentSessionSingleton.getInstance().selectedTableIndex);

        if(!name.isBlank() && !phone.isBlank() && !email.isBlank() && !measures.isEmpty()){
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent() && result.get() == ButtonType.OK){
                selectedCustomer.setNome(name);
                selectedCustomer.setTelefone(phone);
                selectedCustomer.setEmail(email);
                selectedCustomer.setMedidas(measures);

                DatabaseManager.registerCustomer(selectedCustomer);
                AtelieManagerApplication.swapToMain();
            }
        }
    }

    @FXML
    void swapToMain(ActionEvent event) {
        AtelieManagerApplication.swapToMain();
    }

    public void updateCustomerInfo() throws IndexOutOfBoundsException{
        Customer selectedCustomer = CurrentSessionSingleton.getInstance().observableCustomers.get(CurrentSessionSingleton.getInstance().selectedTableIndex);
        nameTextField.setText(selectedCustomer.getNome());
        phoneTextField.setText(selectedCustomer.getTelefone());
        emailTextField.setText(selectedCustomer.getEmail());
        measuresComboBox.setItems(FXCollections.observableArrayList(selectedCustomer.getMedidas()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        measuresComboBox.setConverter(new StringConverter<MeasureCliente>() {
            @Override
            public String toString(MeasureCliente measure) {
                return measure.getNome() + ": " + measure.getTamanho();
            }
            @Override
            public MeasureCliente fromString(String s){return null;}
        });
    }
}
