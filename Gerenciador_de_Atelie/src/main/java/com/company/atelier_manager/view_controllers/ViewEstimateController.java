package com.company.atelier_manager.view_controllers;

import com.company.atelier_manager.AtelieManagerApplication;
import com.company.atelier_manager.CurrentSessionSingleton;
import com.company.atelier_manager.DatabaseManager;
import com.company.atelier_manager.structure.*;
import com.company.model.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.*;

public class ViewEstimateController implements Initializable {

    @FXML
    private ComboBox<Color> colorComboBox;

    @FXML
    private ComboBox<Customer> customerComboBox;

    @FXML
    private ComboBox<ExtraRequirement> extraRequirementComboBox;

    @FXML
    private ComboBox<Fabric> fabricComboBox;

    @FXML
    private ComboBox<OrderItem> itemsComboBox;

    @FXML
    private TextArea observationsField;

    @FXML
    private ComboBox<Piece> pieceComboBox;

    @FXML
    private TextField requirementNameTextField;

    @FXML
    private TextField requirementValueTextField;

    @FXML
    private ComboBox<Size> sizeComboBox;

    @FXML
    private TextField totalValueField;

    @FXML
    void addItem() {
        Piece piece = pieceComboBox.getSelectionModel().getSelectedItem();
        Size size = sizeComboBox.getSelectionModel().getSelectedItem();
        Fabric fabric = fabricComboBox.getSelectionModel().getSelectedItem();
        Color color = colorComboBox.getSelectionModel().getSelectedItem();
        List<ExtraRequirement> extraRequirements = extraRequirementComboBox.getItems();

        if(piece != null && size != null && fabric != null && color != null){
            if(extraRequirements == null){
                extraRequirements = new ArrayList<>();
            }
            extraRequirementComboBox.setItems(null);
            OrderItem orderItem = new OrderItem(piece, size, fabric, color, extraRequirements);
            itemsComboBox.getItems().add(orderItem);
        }

        updateTotalDisplay();
    }

    @FXML
    void addRequirement() {
        String name = requirementNameTextField.getText();
        String value = requirementValueTextField.getText();

        if(!name.isBlank() && !value.isBlank()){
            try{
                requirementValueTextField.setText("");
                double valueDouble = Double.parseDouble(value);
                ExtraRequirement extraRequirement = new ExtraRequirement(name, valueDouble);
                extraRequirementComboBox.getItems().add(extraRequirement);
                requirementNameTextField.setText("");

            }catch (NumberFormatException ignored){}
        }
    }

    @FXML
    void deleteItem() {
        try {
            itemsComboBox.getItems().remove(itemsComboBox.getSelectionModel().getSelectedIndex());
            updateTotalDisplay();
        }catch (IndexOutOfBoundsException ignored){}
    }

    @FXML
    void deleteRequirement() {
        try{
            extraRequirementComboBox.getItems().remove(extraRequirementComboBox.getSelectionModel().getSelectedIndex());
        }catch (IndexOutOfBoundsException ignored){}
    }

    @FXML
    void returnToMain() {
        AtelieManagerApplication.swapToMain();
    }

    @FXML
    void saveEstimate() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Modify Estimate?");
        alert.setContentText("Do you wish to modify this estimate?");
        alert.setHeaderText(alert.getTitle());

        Customer customer = customerComboBox.getSelectionModel().getSelectedItem();
        List<OrderItem> items = itemsComboBox.getItems();
        String observations = observationsField.getText();

        Estimate selectedEstimate = CurrentSessionSingleton.getInstance().observableEstimate.get(CurrentSessionSingleton.getInstance().selectedTableIndex);

        if(customer != null && !items.isEmpty()){
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent() && result.get() == ButtonType.OK){
                if(observations.isBlank()){
                    observations = "No Observations";
                }
                selectedEstimate.setCliente(customer);
                selectedEstimate.setItensPedido(items);
                selectedEstimate.setObservacoes(observations);

                DatabaseManager.registerEstimate(selectedEstimate);
                AtelieManagerApplication.swapToMain();
            }
        }
    }

    private void updateTotalDisplay(){
        double outputSum = 0;

        if(itemsComboBox.getItems().isEmpty()){
            totalValueField.setText("0.00");
        }else{
            for(OrderItem item : itemsComboBox.getItems()){
                outputSum += item.getValorItem();
            }
            totalValueField.setText(String.valueOf(outputSum));
        }
    }

    public void updateEstimateInfo() throws IndexOutOfBoundsException{
        Estimate selectedEstimate = CurrentSessionSingleton.getInstance().observableEstimate.get(CurrentSessionSingleton.getInstance().selectedTableIndex);
        customerComboBox.setItems(CurrentSessionSingleton.getInstance().observableCustomers);
        customerComboBox.setValue(selectedEstimate.getCliente());
        itemsComboBox.setItems(FXCollections.observableArrayList(selectedEstimate.getItensPedido()));
        observationsField.setText(selectedEstimate.getObservacoes());
        updateTotalDisplay();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerComboBox.setConverter(new StringConverter<Customer>() {
            @Override
            public String toString(Customer customer) {
                return customer.getNome();
            }

            @Override
            public Customer fromString(String s) {return null;}
        });

        pieceComboBox.setConverter(new StringConverter<Piece>() {
            @Override
            public String toString(Piece piece) {
                return piece.getName();
            }

            @Override
            public Piece fromString(String s) {
                return null;
            }
        });

        sizeComboBox.setConverter(new StringConverter<Size>() {
            @Override
            public String toString(Size size) {
                return size.name();
            }

            @Override
            public Size fromString(String s) {
                return null;
            }
        });

        fabricComboBox.setConverter(new StringConverter<Fabric>() {
            @Override
            public String toString(Fabric fabric) {
                return fabric.getNome();
            }

            @Override
            public Fabric fromString(String s) {
                return null;
            }
        });
        colorComboBox.setConverter(new StringConverter<Color>() {
            @Override
            public String toString(Color color) {
                return color.name();
            }

            @Override
            public Color fromString(String s) {
                return null;
            }
        });
        extraRequirementComboBox.setConverter(new StringConverter<ExtraRequirement>() {
            @Override
            public String toString(ExtraRequirement extraRequirement) {
                return extraRequirement.getNome() + ": " + extraRequirement.getValorAdicional();
            }

            @Override
            public ExtraRequirement fromString(String s) {
                return null;
            }
        });
        itemsComboBox.setConverter(new StringConverter<OrderItem>() {
            @Override
            public String toString(OrderItem orderItem) {
                return "Item Piece: " + orderItem.getPeca().getName();
            }

            @Override
            public OrderItem fromString(String s) {
                return null;
            }
        });

        customerComboBox.setItems(CurrentSessionSingleton.getInstance().observableCustomers);
        sizeComboBox.setItems(CurrentSessionSingleton.getInstance().observableSizes);
        pieceComboBox.setItems(CurrentSessionSingleton.getInstance().observablePieces);
        fabricComboBox.setItems(CurrentSessionSingleton.getInstance().observableFabrics);
        colorComboBox.setItems(FXCollections.observableArrayList(Arrays.asList(Color.values())));

    }
}
