package com.example.dvd_rental;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AdminController {
    static String staffId;
    static String firstName;
    static String lastName;

    @FXML
    private Label welcome_label;

    public void initialize() {
        welcome_label.setText("Welcome " + firstName + " " + lastName);
    }

    @FXML
    void onCustomersInfo(ActionEvent event) {

    }

}
