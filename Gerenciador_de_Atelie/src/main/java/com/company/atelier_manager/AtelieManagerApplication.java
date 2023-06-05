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
    private static Stage mainStage;

    @Override
    public void start(Stage stage) throws IOException {
        loadScenes();

        stage.setTitle("Atelier Manager");
        //mainStage.getIcons().add(new Image("main/resources/com/company/atelier_manager/Atelier-icon.png"));
        stage.setScene(loginScene);
        stage.show();
        mainStage = stage;
    }

    public static void main(String[] args) {
        launch();
    }

    public static void loadScenes() throws IOException {
        FXMLLoader logInFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("login-view.fxml"));
        FXMLLoader signInFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("sign_in-view.fxml"));
        FXMLLoader mainFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("main-view.fxml"));

        mainScene = new Scene(mainFxmlLoader.load());
        signInScene = new Scene(signInFxmlLoader.load());
        loginScene = new Scene(logInFxmlLoader.load());
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
}