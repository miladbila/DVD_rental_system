package com.example.dvd_rental;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerActiveRents {

    @FXML
    private Button btnDone;
     static String customerId;

    @FXML
    private TableView  tableview;

    @FXML
    private TextField txtrentalId;

    public void initialize() {
        ResultSet rs = null;
        try {
            ObservableList<ObservableList> data = FXCollections.observableArrayList();
            rs = Database.sqlCommand(String.format("select * from rental where customer_id = %s and return_date = null", customerId));
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
    void onBtnDone(ActionEvent event) {
        try {
            Database.sqlCommand(String.format("update rental set return_date = now()  where customer_id = %s and rental_id = %s", customerId , txtrentalId.getText()));
            ResultSet rs = Database.sqlCommand(String.format("select TIMESTAMPDIFF(day,rental_date,return_date) as days from rental where rental_id = 1",txtrentalId.getText()));
            rs.next();
            int days = Integer.parseInt(rs.getString("days"));
            int amount;
            if (days > 14) {
                amount = 28;
                amount += (days - 14) * 3;
                Database.sqlCommand(String.format("update customer set delay = delay + 1  where customer_id = %s", customerId , txtrentalId.getText()));
            } else {
                amount = days * 2;
            }
            Database.sqlCommand(String.format("insert into payment(customer_id, rental_id,amount,payment_date) values (%s,%s,%s,now())", customerId , txtrentalId.getText(),amount));

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
