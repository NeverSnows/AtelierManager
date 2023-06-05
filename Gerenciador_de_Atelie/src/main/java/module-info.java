module com.example.gerenciador_de_atelie {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.company.atelier_manager to javafx.fxml;
    exports com.company.atelier_manager;
}