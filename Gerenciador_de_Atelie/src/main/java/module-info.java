module com.example.gerenciador_de_atelie {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.sql;

    opens com.company.atelier_manager to javafx.fxml;
    opens com.company.model to org.hibernate.orm.core;

    exports com.company.atelier_manager;
}