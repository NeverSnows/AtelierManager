package com.company.atelier_manager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class AtelieManagerApplication extends Application {
    public static Scene loginScene;
    public static Scene signInScene;
    public static Scene mainScene;
    private static Scene newModelScene;
    private static Scene newPieceScene;
    private static Scene newFabricScene;
    private static Scene registerCustomerScene;
    private static Stage mainStage;

    @Override
    public void start(Stage stage) throws IOException {
        loadScenes();

        stage.setTitle("Atelier Manager");
        //mainStage.getIcons().add(new Image("main/resources/com/company/atelier_manager/Atelier-icon.png"));
        stage.setScene(loginScene);
        stage.show();
        stage.setResizable(false);
        mainStage = stage;
    }

    public static void main(String[] args) {
        launch();
    }
    public static boolean test(){
        System.out.println("Triggered");
        return true;
    }
    public static void loadScenes() throws IOException {
        FXMLLoader logInFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("login-view.fxml"));
        FXMLLoader signInFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("sign_in-view.fxml"));
        FXMLLoader mainFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("main-view.fxml"));

        FXMLLoader newModelFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("new_model-view.fxml"));
        FXMLLoader newPieceFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("new_piece-view.fxml"));
        FXMLLoader newFabricFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("new_fabric-view.fxml"));
        FXMLLoader registerCustomerFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("register_customer-view.fxml"));

        FXMLLoader viewFabricFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("view_fabric-view.fxml"));

        mainScene = new Scene(mainFxmlLoader.load());
        signInScene = new Scene(signInFxmlLoader.load());
        loginScene = new Scene(logInFxmlLoader.load());

        newModelScene = new Scene(newModelFxmlLoader.load());
        newPieceScene = new Scene(newPieceFxmlLoader.load());
        newFabricScene = new Scene(newFabricFxmlLoader.load());
        registerCustomerScene = new Scene(registerCustomerFxmlLoader.load());
    }

    public static void swapToSignIn() {
        mainStage.setScene(signInScene);
    }

    public static void swapToLogIn() {
        mainStage.setScene(loginScene);
    }

    public static void swapToMain() {
        mainStage.setScene(mainScene);
    }

    public static void swapToNewModel(){
        mainStage.setScene(newModelScene);
    }

    public static void swapToNewPiece(){
        mainStage.setScene(newPieceScene);
    }

    public static void swapToNewFabric(){
        mainStage.setScene(newFabricScene);
    }

    public static void swapToRegisterCustomer(){
        mainStage.setScene(registerCustomerScene);
    }

}