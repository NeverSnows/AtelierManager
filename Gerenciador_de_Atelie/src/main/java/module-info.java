module com.example.gerenciador_de_atelie {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.company.atelier_manager to javafx.fxml;
    exports com.company.atelier_manager;
    exports com.company.atelier_manager.view_controllers;
    opens com.company.atelier_manager.view_controllers to javafx.fxml;
    exports com.company.atelier_manager.structure;
    opens com.company.atelier_manager.structure to javafx.fxml;
    exports com.company.atelier_manager.structure.enums;
    opens com.company.atelier_manager.structure.enums to javafx.fxml;
}