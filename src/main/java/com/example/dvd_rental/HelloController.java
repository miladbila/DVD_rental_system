package com.example.dvd_rental;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private RadioButton adminRadio;

    @FXML
    private RadioButton customerRadio;

    @FXML
    private TextField txt_AccountName;

    @FXML
    private PasswordField txt_Password;

    @FXML
    void clickLogin(MouseEvent event) {

    }

    @FXML
    void clickSignUp(MouseEvent event) {
        Parent parent = null;
        try {
            parent = FXMLLoader.load(HelloApplication.class.getResource("SignUp.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        Scene scene = new Scene(parent);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onAdminRadio(ActionEvent event) {
        customerRadio.setSelected(false);
    }

    @FXML
    void onCustomerRadio(ActionEvent event) {
        adminRadio.setSelected(false);
    }

}
