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
    opens com.company.model to org.hibernate.orm.core;
    opens com.company.model.Util to org.hibernate.orm.core;

    exports com.company.atelier_manager.structure;
    exports com.company.atelier_manager.structure.enums;
    exports com.company.atelier_manager.view_controllers;
    exports com.company.atelier_manager;
    exports com.company.dao to org.hibernate.orm.core;
    exports com.company.model to org.hibernate.orm.core;




}