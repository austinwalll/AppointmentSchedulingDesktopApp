module com.example.c195_wallace {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.c195_wallace to javafx.fxml;
    exports com.example.c195_wallace;
    exports com.example.c195_wallace.controllers;
    opens com.example.c195_wallace.controllers to javafx.fxml;
}