package com.company.atelier_manager.view_controllers;

import com.company.atelier_manager.*;
import com.company.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.*;

import java.net.URL;

public class MainController implements Initializable {

    //Deprecate and should not be used
    private List<Estimate> currentEstimates;
    private List<Order> currentOrders;
    private List<Model> currentModels;
    private List<Piece> currentPieces;
    private List<Customer> currentCustomers;
    private List<Fabric> currentFabrics;

    private ObservableList<Size> observableSizes;

    //region Estimates
    @FXML
    public TableView<Estimate> estimateTable;

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

    //endregion

    //region Orders
    @FXML
    public TableView<Order> ordersTable;

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

    //endregion

    //region Models
    @FXML
    public TableView<Model> modelsTable;

    @FXML
    private TableColumn<Model, String> modelNameCol;

    @FXML
    private TableColumn<Model, String> modelPriceCol;
    //endregion

    //region Pieces
    @FXML
    public TableView<Piece> piecesTable;

    @FXML
    private TableColumn<Piece, String> pieceNameCol;

    @FXML
    private TableColumn<Piece, String> piecePriceCol;

    @FXML
    private TableColumn<Piece, String> pieceModelCol;
    //endregion

    //region Customers
    @FXML
    public TableView<Customer> customersTable;

    @FXML
    private TableColumn<Customer, String> customerEmailCol;

    @FXML
    private TableColumn<Customer, String> customerNameCol;

    @FXML
    private TableColumn<Customer, String> customerPhoneCol;
    //endregion

    //region Fabrics
    @FXML
    public TableView<Fabric> fabricsTable;

    @FXML
    private TableColumn<Fabric, String> fabricNameCol;

    @FXML
    private TableColumn<Fabric, String> fabricPriceCol;
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
        alert.setHeaderText(alert.getTitle());
        Optional<ButtonType> result = alert.showAndWait();

        return result.isPresent() && result.get() == ButtonType.OK;
    }
    //endregion

    //region New Methods
    @FXML
    void newEstimate(ActionEvent event){
        AtelieManagerApplication.swapToNewEstimate();
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
        CurrentSessionSingleton.getInstance().selectedTableIndex = customersTable.getSelectionModel().getSelectedIndex();
        AtelieManagerApplication.swapToViewCustomer();
    }

    @FXML
    void viewEstimate(ActionEvent event) {
        CurrentSessionSingleton.getInstance().selectedTableIndex = estimateTable.getSelectionModel().getSelectedIndex();
        AtelieManagerApplication.swapToViewEstimate();
    }

    @FXML
    void viewOrder(ActionEvent event){

    }

    @FXML
    void viewFabric(ActionEvent event) {
        CurrentSessionSingleton.getInstance().selectedTableIndex = fabricsTable.getSelectionModel().getSelectedIndex();
        AtelieManagerApplication.swapToViewFabric();
    }

    @FXML
    void viewModelBtn(ActionEvent event) {
        CurrentSessionSingleton.getInstance().selectedTableIndex = modelsTable.getSelectionModel().getSelectedIndex();
        AtelieManagerApplication.swapToViewModel();
    }

    @FXML
    void viewPiece(ActionEvent event) {
        CurrentSessionSingleton.getInstance().selectedTableIndex = piecesTable.getSelectionModel().getSelectedIndex();
        AtelieManagerApplication.swapToViewPiece();
    }
    //endregion

    //region Main
    @FXML
    void escalateEstimate(){
        CurrentSessionSingleton.getInstance().selectedTableIndex = estimateTable.getSelectionModel().getSelectedIndex();
        AtelieManagerApplication.swapToEscalateEstimate();
    }

    @FXML
    void printOrder(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        try{
            //Pega a referencia do pedido selecionado;
            Order selectedOrder = ordersTable.getSelectionModel().getSelectedItem();

            //TODO que porra eu chamo aqui?? Tem um printOrder(Order order) em algum lugar?

            alert.setTitle("Order printed Successfully");
            alert.setContentText("");
            alert.setHeaderText(alert.getTitle());
            alert.showAndWait();
        }catch (IndexOutOfBoundsException exception){
            alert.setTitle("No Order Selecter");
            alert.setContentText("Please, select an Order.");
            alert.setHeaderText(alert.getTitle());
            alert.showAndWait();
        }
    }

    @FXML
    void logOut(ActionEvent event) {
        CurrentSessionSingleton.getInstance().loggedUser = null;
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
        pieceModelCol.setCellValueFactory(new PropertyValueFactory<>("modelName"));

        customerNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        customerEmailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        customerPhoneCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        fabricNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        fabricPriceCol.setCellValueFactory(new PropertyValueFactory<>("value"));

        observableSizes = FXCollections.observableArrayList(Arrays.asList(Size.values()));
        updateTables();

        customersTable.setItems(CurrentSessionSingleton.getInstance().observableCustomers);
        estimateTable.setItems(CurrentSessionSingleton.getInstance().observableEstimate);
        ordersTable.setItems(CurrentSessionSingleton.getInstance().observableOrders);
        modelsTable.setItems(CurrentSessionSingleton.getInstance().observableModels);
        piecesTable.setItems(CurrentSessionSingleton.getInstance().observablePieces);
        fabricsTable.setItems(CurrentSessionSingleton.getInstance().observableFabrics);

    }

    public void updateTables(){
        //Gets refference from DB.
        currentEstimates = DatabaseManager.getEstimates();
        currentOrders = DatabaseManager.getOrders();
        currentModels = DatabaseManager.getModels();
        currentPieces = DatabaseManager.getPieces();
        currentCustomers = DatabaseManager.getCustomers();
        currentFabrics = DatabaseManager.getFabrics();

        //saves data on CurrentSessionSingleton
        CurrentSessionSingleton.getInstance().observableCustomers = FXCollections.observableArrayList(currentCustomers);
        CurrentSessionSingleton.getInstance().observableEstimate = FXCollections.observableArrayList(currentEstimates);
        CurrentSessionSingleton.getInstance().observableOrders = FXCollections.observableArrayList(currentOrders);
        CurrentSessionSingleton.getInstance().observableModels = FXCollections.observableArrayList(currentModels);
        CurrentSessionSingleton.getInstance().observablePieces = FXCollections.observableArrayList(currentPieces);
        CurrentSessionSingleton.getInstance().observableFabrics = FXCollections.observableArrayList(currentFabrics);
        CurrentSessionSingleton.getInstance().observableSizes = observableSizes;
    }
    //endregion
}
