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

    public ObservableList<Estimate> observableEstimate;
    //endregion

    //region Orders
    @FXML
    private TableView<?> ordersTable;
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

    public ObservableList<Model> observableModels;
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

    public ObservableList<Piece> observablePieces;
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

    public ObservableList<Customer> observableCustomers;

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

    public ObservableList<Fabric> observableFabrics;
    //endregion

    //region Delete Methods
    @FXML
    void deleteCustomer(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Customer?");
        alert.setContentText("Are you sure you want to delete this customer?\nThis action is irreversible!");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.get() == ButtonType.OK){
            DatabaseManager.deleteCustomer(customersTable.getSelectionModel().getSelectedItem());
            observableCustomers.remove(customersTable.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    void deleteEstimate(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Estimate?");
        alert.setContentText("Are you sure you want to delete this estimate?\nThis action is irreversible!");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.get() == ButtonType.OK) {
            DatabaseManager.deleteEstimate(estimateTable.getSelectionModel().getSelectedItem());
            observableEstimate.remove(estimateTable.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    void deleteFabric(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Fabric?");
        alert.setContentText("Are you sure you want to delete this fabric?\nThis action is irreversible!");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.get() == ButtonType.OK) {
            DatabaseManager.deleteFabric(fabricsTable.getSelectionModel().getSelectedItem());
            observableFabrics.remove(fabricsTable.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    void deleteModel(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Model?");
        alert.setContentText("Are you sure you want to delete this model?\nThis action is irreversible!");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            DatabaseManager.deleteModel(modelsTable.getSelectionModel().getSelectedItem());
            observableModels.remove(modelsTable.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    void deletePiece(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Piece?");
        alert.setContentText("Are you sure you want to delete this piece?\nThis action is irreversible!");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            DatabaseManager.deletePiece(piecesTable.getSelectionModel().getSelectedItem());
            observablePieces.remove(piecesTable.getSelectionModel().getSelectedItem());
        }
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
        customerNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        customerEmailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        customerPhoneCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        estimateCustomerCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        estimateUserCol.setCellValueFactory(new PropertyValueFactory<>("userName"));
        estimateDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        estimateValueCol.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        estimateObservationsCol.setCellValueFactory(new PropertyValueFactory<>("observations"));

        modelNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        modelPriceCol.setCellValueFactory(new PropertyValueFactory<>("value"));

        pieceNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        piecePriceCol.setCellValueFactory(new PropertyValueFactory<>("value"));

        fabricNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        fabricPriceCol.setCellValueFactory(new PropertyValueFactory<>("value"));

        //Gets refference from DB.
        currentEstimates = DatabaseManager.getEstimates();
        //currentOrders = DatabaseManager.getOrders();
        currentModels = DatabaseManager.getModels();
        currentPieces = DatabaseManager.getPieces();
        currentCustomers = DatabaseManager.getCustomers();
        currentFabrics = DatabaseManager.getFabrics();

        observableCustomers = FXCollections.observableArrayList(currentCustomers);
        observableEstimate = FXCollections.observableArrayList(currentEstimates);
        observableModels = FXCollections.observableArrayList(currentModels);
        observablePieces = FXCollections.observableArrayList(currentPieces);
        observableFabrics = FXCollections.observableArrayList(currentFabrics);

        //Saves data to tables.
        customersTable.setItems(observableCustomers);
        estimateTable.setItems(observableEstimate);
        modelsTable.setItems(observableModels);
        piecesTable.setItems(observablePieces);
        fabricsTable.setItems(observableFabrics);
    }

    //endregion
}
