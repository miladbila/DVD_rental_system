package com.example.dvd_rental;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class CustomerEditProfile {
    static String customerId;

    @FXML
    private Button btnAddress;

    @FXML
    private Button btnEmail;

    @FXML
    private Button btnFirstName;

    @FXML
    private Button btnLastName;

    @FXML
    private TextField txtNew;

    @FXML
    void onBtnAddress(ActionEvent event) {
        try {
            Database.sqlCommand(String.format("update address set address = %s where address.address_id = customer.address_id and customer_id= %s", txtNew.getText() , customerId));
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onBtnEmail(ActionEvent event) {
        try {
            Database.sqlCommand(String.format("update customer set email = \"%s\" where customer_id = %s", txtNew.getText() , customerId));
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onBtnFirstName(ActionEvent event) {
        try {
            Database.sqlCommand(String.format("update customer set first_name = \"%s\" where where customer_id = %s", txtNew.getText(), customerId));
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onBtnLastName(ActionEvent event) {
        try {
            Database.sqlCommand(String.format("update customer set last_name = \"%s\" where customer_id = %s", txtNew.getText() , customerId));
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
