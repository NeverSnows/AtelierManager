package com.company.atelier_manager.view_controllers;

import com.company.atelier_manager.*;
import com.company.atelier_manager.structure.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.List;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    //Deprecate and should not be used
    private List<Estimate> currentEstimates;
    private List<Order> currentOrders;
    private List<Model> currentModels;
    private List<Piece> currentPieces;
    private List<Customer> currentCustomers;
    private List<Fabric> currentFabrics;

    public ObservableList<Estimate> observableEstimate;
    public ObservableList<Order> observableOrders;
    public ObservableList<Model> observableModels;
    public ObservableList<Piece> observablePieces;
    public ObservableList<Customer> observableCustomers;
    public ObservableList<Fabric> observableFabrics;
    //region Estimates
    @FXML
    private TableView<Estimate> estimateTable;

    @FXML
    private TableColumn<Estimate, String> estimateCustomerCol;

    @FXML
    private TableColumn<Estimate, String> estimateDateCol;

    @FXML
    private TableColumn<Estimate, String> estimateObservationsCol;

    @FXML
    private TableColumn<Estimate, String> estimateUserCol;

    @FXML
    private TableColumn<Estimate, Double> estimateValueCol;

    @FXML
    private Button deleteEstimateBtn;

    @FXML
    private Button newEstimateBtn;

    //endregion

    //region Orders
    @FXML
    private TableView<Order> ordersTable;

    @FXML
    private TableColumn<Order, String> orderCustomerNameCol;

    @FXML
    private TableColumn<Order, String> orderCreationDateCol;

    @FXML
    private TableColumn<Order, String> orderTotalValueCol;

    @FXML
    private TableColumn<Order, String> orderStatusCol;

    @FXML
    private TableColumn<Order, String> orderIsPaidCol;

    @FXML
    private Button deleteOrderBtn;


    //endregion

    //region Models
    @FXML
    private TableView<Model> modelsTable;

    @FXML
    private TableColumn<Model, String> modelNameCol;

    @FXML
    private TableColumn<Model, String> modelPriceCol;

    @FXML
    private Button deleteModelBtn;

    @FXML
    private Button newModelBtn;

    //endregion

    //region Pieces
    @FXML
    private TableView<Piece> piecesTable;

    @FXML
    private TableColumn<Piece, String> pieceNameCol;

    @FXML
    private TableColumn<Piece, String> piecePriceCol;

    @FXML
    private Button deletePieceBtn;

    @FXML
    private Button newPieceBtn;

    //endregion

    //region Customers
    @FXML
    private TableView<Customer> customersTable;

    @FXML
    private TableColumn<Customer, String> customerEmailCol;

    @FXML
    private TableColumn<Customer, String> customerNameCol;

    @FXML
    private TableColumn<Customer, String> customerPhoneCol;

    @FXML
    private Button deleteCustomerBtn;

    @FXML
    private Button registerCustomerBtn;


    //endregion

    //region Fabrics
    @FXML
    private TableView<Fabric> fabricsTable;

    @FXML
    private TableColumn<Fabric, String> fabricNameCol;

    @FXML
    private TableColumn<Fabric, String> fabricPriceCol;

    @FXML
    private Button deleteFabricBtn;

    @FXML
    private Button newFabricBtn;

    //endregion

    //region Delete Methods
    @FXML
    void deleteCustomer(ActionEvent event) {
        if (confirmDelete("Delete Customer?", "Are you sure you want to delete this customer?\nThis action is irreversible!")) {
            DatabaseManager.deleteCustomer(customersTable.getSelectionModel().getSelectedItem());
            updateTables();
        }
    }

    @FXML
    void deleteEstimate(ActionEvent event) {
        if (confirmDelete("Delete Estimate?", "Are you sure you want to delete this estimate?\nThis action is irreversible, and will also delete associate orders!")) {
            DatabaseManager.deleteEstimate(estimateTable.getSelectionModel().getSelectedItem());
            updateTables();
        }
    }

    @FXML
    void deleteOrder(ActionEvent event) {
        if (confirmDelete("Delete Order?", "Are you sure you want to delete this order?\nThis action is irreversible!")) {
            DatabaseManager.deleteOrder(ordersTable.getSelectionModel().getSelectedItem());
            updateTables();
        }
    }

    @FXML
    void deleteFabric(ActionEvent event) {
        if (confirmDelete("Delete Fabric?", "Are you sure you want to delete this fabric?\nThis action is irreversible!")) {
            DatabaseManager.deleteFabric(fabricsTable.getSelectionModel().getSelectedItem());
            updateTables();
        }
    }

    @FXML
    void deleteModel(ActionEvent event){
        if (confirmDelete("Delete model?", "Are you sure you want to delete this model?\nThis action is irreversible!")) {
            DatabaseManager.deleteModel(modelsTable.getSelectionModel().getSelectedItem());
            updateTables();
        }
    }

    @FXML
    void deletePiece(ActionEvent event) {
        if (confirmDelete("Delete Piece?", "Are you sure you want to delete this piece?\nThis action is irreversible!")) {
            DatabaseManager.deletePiece(piecesTable.getSelectionModel().getSelectedItem());
            updateTables();
        }
    }

    private boolean confirmDelete(String title, String content){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        Optional<ButtonType> result = alert.showAndWait();

        return result.isPresent() && result.get() == ButtonType.OK;
    }
    //endregion

    //region New Methods
    @FXML
    void newEstimate(ActionEvent event){
    }
    @FXML
    void newFabric(ActionEvent event) {
        AtelieManagerApplication.swapToNewFabric();
    }

    @FXML
    void newModel(ActionEvent event) {
        AtelieManagerApplication.swapToNewModel();
    }

    @FXML
    void newPiece(ActionEvent event) {
        AtelieManagerApplication.swapToNewPiece();
    }

    @FXML
    void registerCustomer(ActionEvent event) {
        AtelieManagerApplication.swapToRegisterCustomer();
    }

    //endregion

    //region View and Edit Methods
    @FXML
    void viewCustomer(ActionEvent event) {

    }

    @FXML
    void viewEstimate(ActionEvent event) {

    }

    @FXML
    void viewOrder(ActionEvent event){

    }

    @FXML
    void viewFabric(ActionEvent event) {

    }

    @FXML
    void viewModelBtn(ActionEvent event) {

    }

    @FXML
    void viewPiece(ActionEvent event) {

    }
    //endregion

    //region Main
    @FXML
    void logOut(ActionEvent event) {
        AtelieManagerApplication.swapToLogIn();
    }

    @FXML
    private Button logOutBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Pepares columns.
        estimateCustomerCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        estimateUserCol.setCellValueFactory(new PropertyValueFactory<>("userName"));
        estimateDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        estimateValueCol.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        estimateObservationsCol.setCellValueFactory(new PropertyValueFactory<>("observations"));

        orderCustomerNameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        orderCreationDateCol.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        orderTotalValueCol.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        orderStatusCol.setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
        orderIsPaidCol.setCellValueFactory(new PropertyValueFactory<>("paidOut"));

        modelNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        modelPriceCol.setCellValueFactory(new PropertyValueFactory<>("value"));

        pieceNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        piecePriceCol.setCellValueFactory(new PropertyValueFactory<>("value"));

        customerNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        customerEmailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        customerPhoneCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        fabricNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        fabricPriceCol.setCellValueFactory(new PropertyValueFactory<>("value"));

        updateTables();

        //Saves data to tables.
        customersTable.setItems(observableCustomers);
        estimateTable.setItems(observableEstimate);
        ordersTable.setItems(observableOrders);
        modelsTable.setItems(observableModels);
        piecesTable.setItems(observablePieces);
        fabricsTable.setItems(observableFabrics);
    }

    public void updateTables(){
        //Gets refference from DB.
        currentEstimates = DatabaseManager.getEstimates();
        currentOrders = DatabaseManager.getOrders();
        currentModels = DatabaseManager.getModels();
        currentPieces = DatabaseManager.getPieces();
        currentCustomers = DatabaseManager.getCustomers();
        currentFabrics = DatabaseManager.getFabrics();

        //turns all table lists into Observable Lists
        observableCustomers = FXCollections.observableArrayList(currentCustomers);
        observableEstimate = FXCollections.observableArrayList(currentEstimates);
        observableOrders = FXCollections.observableArrayList(currentOrders);
        observableModels = FXCollections.observableArrayList(currentModels);
        observablePieces = FXCollections.observableArrayList(currentPieces);
        observableFabrics = FXCollections.observableArrayList(currentFabrics);

    }

    //endregion
}
/*
nome cliente
data criacao
valor

situacao

* **/
