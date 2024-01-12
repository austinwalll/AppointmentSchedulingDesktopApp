package com.example.c195_wallace.controllers;

import com.example.c195_wallace.DAO.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginPageController implements Initializable {
    public Label loginUsernameLbl;
    public TextField loginUsernameTF;
    public Label loginPasswordLbl;
    public PasswordField loginPasswordTF;
    public Button loginBtn;
    public Button cancelBtn;
    public Label loginLocationLbl;
    public Label loginWelcomeLbl;
    Stage stage;

    public void onLoginClick(ActionEvent actionEvent) throws IOException {
        try{
        Locale locale = Locale.getDefault();
        Locale.setDefault(locale);
        ResourceBundle resourceBundle;
        boolean french = false;
        if (locale.getLanguage().equals("fr")) {
            french = true;
        }

        if (french) {
            resourceBundle = ResourceBundle.getBundle("com.example.c195_wallace/labels_fr", locale);
        } else {
            resourceBundle = ResourceBundle.getBundle("com.example.c195_wallace/labels_en", Locale.ENGLISH);
        }
        String username = loginUsernameTF.getText();
        String password = loginPasswordTF.getText();
        boolean userValid = UserDAO.validateUsers(username, password);
        if (userValid){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/c195_wallace/main-screen.fxml"));
            Parent root = loader.load();
            stage = (Stage) loginBtn.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(resourceBundle.getString("Error"));
            alert.setContentText(resourceBundle.getString("Incorrect"));
            alert.show();
            loginUsernameTF.clear();
            loginPasswordTF.clear();
        }
    } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public void onCancelClick(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        try{
            Locale locale = Locale.getDefault();
            Locale.setDefault(locale);
            ResourceBundle resourceBundle;
            boolean french = false;
            if (locale.getLanguage().equals("fr")) {
                french = true;
            }

            if (french) {
                resourceBundle = ResourceBundle.getBundle("com.example.c195_wallace/labels_fr", locale);
            } else {
                resourceBundle = ResourceBundle.getBundle("com.example.c195_wallace/labels_en", Locale.ENGLISH);
            }
            loginUsernameLbl.setText(resourceBundle.getString("loginUsernameLbl"));
            loginPasswordLbl.setText(resourceBundle.getString("loginPasswordLbl"));
            loginBtn.setText(resourceBundle.getString("loginBtn"));
            cancelBtn.setText(resourceBundle.getString("cancelBtn"));
            loginLocationLbl.setText(resourceBundle.getString("loginLocationLbl"));
            loginWelcomeLbl.setText(resourceBundle.getString("loginWelcomeLbl"));

            ZoneId zoneID = ZoneId.systemDefault();

            loginLocationLbl.setText(loginLocationLbl.getText() + " " + zoneID.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
