package com.example.dvd_rental;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminReserveRequests {

    static String staffId;

    @FXML
    private TextField id_text;

    @FXML
    private TableView tableview;

    @FXML
    private Label welcome_label;

    public void initialize() {
        ResultSet rs = null;
        try {
            ObservableList<ObservableList> data = FXCollections.observableArrayList();
            rs = Database.sqlCommand(String.format("select rental_id, customer_id from rental where rental_date = null and return_date = null and staff_id = %s", staffId));
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));
                tableview.getColumns().addAll(col);
            }
            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    row.add(rs.getString(i));
                }
                data.add(row);
            }
            tableview.setItems(data);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onReject(ActionEvent event) {
        try {
            Database.sqlCommand(String.format("delete from rental where rental_id = %s", id_text.getText()));
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onAccept(ActionEvent event) {
        try {
            Database.sqlCommand(String.format("update rental set rental_date = now() where rental_id = %s", id_text.getText()));
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
