module com.example.gerenciador_de_atelie {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;


    opens com.company.atelier_manager to javafx.fxml;
    exports com.company.atelier_manager;
}