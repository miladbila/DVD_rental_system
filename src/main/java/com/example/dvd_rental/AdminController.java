package com.example.dvd_rental;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AdminController {
    static String staffId;
    @FXML
    private Label lb;

    public void initialize() {
        lb.setText(staffId);
    }

}
