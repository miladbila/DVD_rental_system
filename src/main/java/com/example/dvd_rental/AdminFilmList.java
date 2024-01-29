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

public class AdminFilmList {

    @FXML
    private TableView tableview;

    @FXML
    private Label welcome_label;

    @FXML
    private TextField category_text;

    @FXML
    private TableView tableview1;
    public void initialize() {
        ResultSet rs = null;
        try {
            ObservableList<ObservableList> data = FXCollections.observableArrayList();
            rs = Database.sqlCommand("select name from category");
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
    void onSubmit(ActionEvent event) {
        ResultSet rs = null;
        try {
            ObservableList<ObservableList> data = FXCollections.observableArrayList();
            if (!category_text.getText().equals("all"))
                rs = Database.sqlCommand(String.format("select film.film_id, title, rating from film, film_category as x, category  where film.film_id = x.film_id and x.category_id = category.category_id and name = \"%s\" order by rating", category_text.getText()));
            else
                rs = Database.sqlCommand(String.format("select film.film_id, title, rating from film, film_category as x, category  where film.film_id = x.film_id and x.category_id = category.category_id order by rating"));
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));
                tableview1.getColumns().addAll(col);
            }
            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    row.add(rs.getString(i));
                }
                data.add(row);
            }
            tableview1.setItems(data);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
