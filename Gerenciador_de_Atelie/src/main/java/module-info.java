module com.example.gerenciador_de_atelie {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.sql;
    requires java.mail;

    opens com.company.atelier_manager.view_controllers to javafx.fxml;
    opens com.company.atelier_manager.structure to javafx.fxml;
    opens com.company.atelier_manager.structure.enums to javafx.fxml;
    opens com.company.atelier_manager to javafx.fxml;

    exports com.company.atelier_manager.structure;
    exports com.company.atelier_manager.structure.enums;
    exports com.company.atelier_manager.view_controllers;
    exports com.company.atelier_manager;
    exports com.company.model;
    opens com.company.model to javafx.fxml, org.hibernate.orm.core;
    exports com.company.dao;
    opens com.company.dao to javafx.fxml;
    exports com.company.model.Util;
    opens com.company.model.Util to javafx.fxml, org.hibernate.orm.core;


}