package com.company.atelier_manager;

import com.company.atelier_manager.view_controllers.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class AtelieManagerApplication extends Application {
    private static Stage mainStage;
    public static Scene loginScene;
    public static Scene signInScene;
    public static Scene mainScene;

    private  static  Scene newEstimateScene;
    private static Scene newModelScene;
    private static Scene newPieceScene;
    private static Scene newFabricScene;
    private static Scene registerCustomerScene;
    private static Scene escalateEstimateScene;
    private static Scene recoveryEmailScene;
    private static Scene recoveryCodeScene;
    private static Scene recoverPasswordScene;

    private static Scene viewFabricScene;
    private static Scene viewCustomerScene;
    private static Scene viewPieceScene;
    private static Scene viewModelScene;
    private static Scene viewEstimateScene;
    private static Scene viewOrderScene;

    private static MainController mainController;
    private static ViewFabricController viewFabricController;
    private static ViewCustomerController viewCustomerController;
    private static ViewPieceController viewPieceController;
    private static ViewModelController viewModelController;
    private static ViewEstimateController viewEstimateController;
    private static ViewOrderController viewOrderController;
    private static EscalateEstimateController escalateEstimateController;

    @Override
    public void start(Stage stage) throws IOException {
        loadScenes();

        stage.setTitle("Ponto Certo");
        //mainStage.getIcons().add(new Image("main/resources/com/company/atelier_manager/Atelier-icon.png"));
        stage.setScene(loginScene);
        stage.show();
        stage.setResizable(false);
        mainStage = stage;
    }

    public static void main(String[] args) {
        launch();
    }

    public static void loadScenes() throws IOException {
        //region FXML Loaders
        //Base FXML Loaders
        FXMLLoader logInFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("login-view.fxml"));
        FXMLLoader signInFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("sign_in-view.fxml"));
        FXMLLoader mainFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("main-view.fxml"));

        //Other FXML Loaders
        FXMLLoader newEstimateFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("new_estimate-view.fxml"));
        FXMLLoader newModelFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("new_model-view.fxml"));
        FXMLLoader newPieceFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("new_piece-view.fxml"));
        FXMLLoader newFabricFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("new_fabric-view.fxml"));
        FXMLLoader registerCustomerFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("register_customer-view.fxml"));
        FXMLLoader escalateEstimateFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("escalate_estimate-view.fxml"));
        FXMLLoader recoveryEmailFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("recovery_email-view.fxml"));
        FXMLLoader recoveryCodeFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("recovery_code-view.fxml"));
        FXMLLoader recoverPasswordFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("recover_password-view.fxml"));

        //View and Edit FXML Loaders
        FXMLLoader viewFabricFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("view_fabric-view.fxml"));
        FXMLLoader viewCustomerxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("view_customer-view.fxml"));
        FXMLLoader viewPieceFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("view_piece-view.fxml"));
        FXMLLoader viewModelFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("view_model-view.fxml"));
        FXMLLoader viewEstimateFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("view_estimate-view.fxml"));
        FXMLLoader viewOrderFxmlLoader = new FXMLLoader(AtelieManagerApplication.class.getResource("view_order-view.fxml"));
        //endregion

        //region Scenes
        //Base Scenes
        mainScene = new Scene(mainFxmlLoader.load());
        signInScene = new Scene(signInFxmlLoader.load());
        loginScene = new Scene(logInFxmlLoader.load());

        //Other Scenes
        newEstimateScene = new Scene(newEstimateFxmlLoader.load());
        newModelScene = new Scene(newModelFxmlLoader.load());
        newPieceScene = new Scene(newPieceFxmlLoader.load());
        newFabricScene = new Scene(newFabricFxmlLoader.load());
        registerCustomerScene = new Scene(registerCustomerFxmlLoader.load());
        escalateEstimateScene = new Scene(escalateEstimateFxmlLoader.load());
        recoveryEmailScene = new Scene(recoveryEmailFxmlLoader.load());
        recoveryCodeScene = new Scene(recoveryCodeFxmlLoader.load());
        recoverPasswordScene = new Scene(recoverPasswordFxmlLoader.load());

        //View Scenes
        viewFabricScene = new Scene(viewFabricFxmlLoader.load());
        viewCustomerScene = new Scene(viewCustomerxmlLoader.load());
        viewPieceScene = new Scene(viewPieceFxmlLoader.load());
        viewModelScene = new Scene(viewModelFxmlLoader.load());
        viewEstimateScene = new Scene(viewEstimateFxmlLoader.load());
        viewOrderScene = new Scene(viewOrderFxmlLoader.load());
        //endregion

        //region Controllers
        mainController = mainFxmlLoader.getController();
        escalateEstimateController = escalateEstimateFxmlLoader.getController();
        viewFabricController = viewFabricFxmlLoader.getController();
        viewCustomerController = viewCustomerxmlLoader.getController();
        viewPieceController = viewPieceFxmlLoader.getController();
        viewModelController = viewModelFxmlLoader.getController();
        viewEstimateController = viewEstimateFxmlLoader.getController();
        viewOrderController = viewOrderFxmlLoader.getController();
        //endregion
    }

    public static void swapToSignIn() {
        mainStage.setScene(signInScene);
    }

    public static void swapToLogIn() {
        mainStage.setScene(loginScene);
    }

    public static void swapToMain() {
        mainController.updateTables();
        mainStage.setScene(mainScene);
    }

    public static void swapToNewEstimate(){mainStage.setScene(newEstimateScene);}
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
    public static void swapToRecoveryEmail(){
        mainStage.setScene(recoveryEmailScene);
    }
    public static void swapToRecoveryCode(){
        mainStage.setScene(recoveryCodeScene);
    }
    public static void swapToRecoverPassword(){mainStage.setScene(recoverPasswordScene);}

    //region View and Edit
    public static void swapToViewCustomer(){
        try{
            viewCustomerController.updateCustomerInfo();
            mainStage.setScene(viewCustomerScene);
        }catch (IndexOutOfBoundsException exception){
            alertSelectionNull("No Customer Selected!", "Please, select a customer.");
        }
    }
    public static void swapToViewFabric(){
        try{
            viewFabricController.updateFabricInfo();
            mainStage.setScene(viewFabricScene);
        }catch(IndexOutOfBoundsException exception){
            alertSelectionNull("No Fabric Selected!", "Please, select a fabric.");
        }
    }

    public static void swapToViewPiece(){
        try{
            viewPieceController.updatePieceInfo();
            mainStage.setScene(viewPieceScene);
        }catch(IndexOutOfBoundsException exception){
            alertSelectionNull("No Piece Selected!", "Please, select a piece.");
        }
    }

    public static void swapToViewModel(){
        try{
            viewModelController.updateModelInfo();
            mainStage.setScene(viewModelScene);
        }catch(IndexOutOfBoundsException exception){
            alertSelectionNull("No Model Selected!", "Please, select a model.");
        }
    }

    public static void swapToViewEstimate(){
        try{
            viewEstimateController.updateEstimateInfo();
            mainStage.setScene(viewEstimateScene);
        }catch (IndexOutOfBoundsException exception){
            alertSelectionNull("No Estimate Selected!", "Please, select an estimate.");
        }
    }
    public static void swapToViewOrder(){
        try{
            viewOrderController.updateOrderInfo();
            mainStage.setScene(viewOrderScene);
        }catch (IndexOutOfBoundsException exception){
            alertSelectionNull("No Order Selected!", "Please, select an order.");
        }
    }

    public static void swapToEscalateEstimate(){
        try{
            escalateEstimateController.updateEstimateInfo();
            mainStage.setScene(escalateEstimateScene);
        }catch (IndexOutOfBoundsException exception){
            alertSelectionNull("No Estimate Selected!", "Please, select an estimate.");
        }
    }


    private static void alertSelectionNull(String title, String textContent){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(textContent);
        alert.setHeaderText(alert.getTitle());
        Optional<ButtonType> result = alert.showAndWait();
    }
}

//TODO aprender a usar:
//-tags customisadas como @FXML;
//-throws forçar a implementar um try/catch ou um outro throws;
//-descrições de metodos e de variáveis;
//