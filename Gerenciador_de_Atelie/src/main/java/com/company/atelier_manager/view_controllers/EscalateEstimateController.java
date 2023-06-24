package com.company.atelier_manager.view_controllers;

import com.company.atelier_manager.AtelieManagerApplication;
import com.company.atelier_manager.CurrentSessionSingleton;
import com.company.atelier_manager.DatabaseManager;
import com.company.model.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class EscalateEstimateController implements Initializable {

    @FXML
    private TextField customerNameTextField;

    @FXML
    private CheckBox isPaidOutCheckBox;

    @FXML
    private ComboBox<OrderItem> itemsComboBox;

    @FXML
    private TextArea observationsField;

    @FXML
    private ComboBox<OrderStatus> orderStatusComboBox;

    @FXML
    private DatePicker paymentDatePicker;

    @FXML
    private ComboBox<PaymentOption> paymentOptionComboBox;

    @FXML
    private TextField totalValueField;

    @FXML
    void createOrder() {
        LocalDate localDate = paymentDatePicker.getValue();
        OrderStatus status = orderStatusComboBox.getSelectionModel().getSelectedItem();
        PaymentOption option = paymentOptionComboBox.getSelectionModel().getSelectedItem();
        boolean paidOut = isPaidOutCheckBox.isSelected();
        Date date;

        if(status != null && option != null){
            if(localDate != null){
                date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            }else{
                date = null;
            }
            Order order = new Order(
                    CurrentSessionSingleton.getInstance().observableEstimate.get(CurrentSessionSingleton.getInstance().selectedTableIndex),
                    date,
                    paidOut,
                    option,
                    status);
            paymentDatePicker.setValue(null);
            isPaidOutCheckBox.setSelected(false);
            DatabaseManager.registerOrder(order);
            AtelieManagerApplication.swapToMain();
        }
    }

    @FXML
    void returnToMain() {
        AtelieManagerApplication.swapToMain();
    }

    public void updateEstimateInfo() throws IndexOutOfBoundsException{
        Estimate selectedEstimate = CurrentSessionSingleton.getInstance().observableEstimate.get(CurrentSessionSingleton.getInstance().selectedTableIndex);
        customerNameTextField.setText(selectedEstimate.getCustomer().getName());
        itemsComboBox.setItems(FXCollections.observableArrayList(selectedEstimate.getOrderItems()));
        totalValueField.setText(String.valueOf(selectedEstimate.getTotalPrice()));
        observationsField.setText(selectedEstimate.getObservations());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemsComboBox.setConverter(new StringConverter<OrderItem>() {
            @Override
            public String toString(OrderItem orderItem) {
                return orderItem.getPiece().getName();
            }

            @Override
            public OrderItem fromString(String s) {
                return null;
            }
        });

        orderStatusComboBox.setConverter(new StringConverter<OrderStatus>() {
            @Override
            public String toString(OrderStatus orderStatus) {
                return orderStatus.name();
            }

            @Override
            public OrderStatus fromString(String s) {
                return null;
            }
        });

        paymentOptionComboBox.setConverter(new StringConverter<PaymentOption>() {            @Override
            public String toString(PaymentOption paymentOption) {
                return paymentOption.name();
            }

            @Override
            public PaymentOption fromString(String s) {
                return null;
            }
        });

        orderStatusComboBox.setItems(FXCollections.observableArrayList(Arrays.asList(OrderStatus.values())));
        paymentOptionComboBox.setItems(FXCollections.observableArrayList(Arrays.asList(PaymentOption.values())));
    }
}