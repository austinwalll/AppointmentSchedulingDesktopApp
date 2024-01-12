package com.example.c195_wallace.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreenController {
    public Button mainAppointmentBtn;
    public Button mainCustomersBtn;
    public Button mainReportsBtn;
    public Button mainExitBtn;
    @FXML
    private Label welcomeText;
    private Stage stage;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void mainMenuExit(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void mainMenuReportsClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/c195_wallace/reports-page.fxml"));
        Parent root = loader.load();
        stage = (Stage) mainReportsBtn.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Reports");
        stage.setScene(scene);
        stage.show();
    }

    public void mainMenuCustomersClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/c195_wallace/customers-page.fxml"));
        Parent root = loader.load();
        stage = (Stage) mainCustomersBtn.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Customers");
        stage.setScene(scene);
        stage.show();
    }
    public void mainMenuAppointmentsClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/c195_wallace/appointments-page.fxml"));
        Parent root = loader.load();
        stage = (Stage) mainAppointmentBtn.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Appointments");
        stage.setScene(scene);
        stage.show();

    }
}