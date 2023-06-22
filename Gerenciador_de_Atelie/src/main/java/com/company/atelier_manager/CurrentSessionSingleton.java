package com.company.atelier_manager;

import com.company.model.*;
import javafx.collections.ObservableList;

public class CurrentSessionSingleton {
    private static CurrentSessionSingleton currentSessionSingleton = null;
    public ObservableList<Estimate> observableEstimate;
    public ObservableList<Order> observableOrders;
    public ObservableList<Model> observableModels;
    public ObservableList<Piece> observablePieces;
    public ObservableList<Customer> observableCustomers;
    public ObservableList<Fabric> observableFabrics;
    public ObservableList<Size> observableSizes;
    public User loggedUser;
    public int selectedTableIndex;
    public static CurrentSessionSingleton getInstance(){
        if(currentSessionSingleton == null){
            currentSessionSingleton = new CurrentSessionSingleton();
        }
        return currentSessionSingleton;
    }

    private CurrentSessionSingleton(){}
}
