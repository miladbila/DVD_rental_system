package com.example.dvd_rental;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

class CustomerPaymentInfo {

    @FXML
    private Label lbllist;
    static String staffId;

    @FXML
    private TableView tableview;

    public void initialize() {
        ResultSet rs = null;
        try {
            rs = Database.sqlCommand(String.format("select customer_id from customer where customer_id = %s", staffId));
            ArrayList<String> storeIds = new ArrayList<>();
            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    storeIds.add(rs.getString(i));
                }
            }
            ObservableList<ObservableList> data = FXCollections.observableArrayList();
            if (storeIds.size() == 1)
                rs = Database.sqlCommand(String.format(" select customer.first_name , customer.last_name , payment.payment_id , payment.amount from customer , payment where customer.customer_id = payment.payment_id and customer_id= %s", staffId));
            else
                rs = Database.sqlCommand(String.format("select distinct customer.customer_id, first_name, last_name from rental, customer where rental.customer_id = customer.customer_id and (store_id = %s or store_id = %s)", storeIds.get(0), storeIds.get(1)));
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

}
