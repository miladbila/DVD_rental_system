package com.example.dvd_rental;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;


 class CustomerReserveRequest {
    static String customerId;

    @FXML
    private Button btndone;

    @FXML
    private Label lbllist;

    @FXML
    private TextField txtFilmId;

    @FXML
    private TextField txtstoreId;

    @FXML
    void onDone(ActionEvent event) {
        try {
            Database.sqlCommand(String.format("select inventory_id from inventory where film_id = %s", txtFilmId));
            Database.sqlCommand(String.format("select manager_staff_id as staff_id from store where store_id = %s", txtstoreId));
            Database.sqlCommand(String.format("insert rental (- , null , inventory_id , %s , null , staff_id " ,customerId));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
