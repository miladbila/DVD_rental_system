package com.example.dvd_rental;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


import javafx.scene.control.Label;
import javafx.util.Callback;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerSearch {
    static String customerId;
    @FXML
    private TableView tableview;

    @FXML
    private Label welcome_label;

    @FXML
    private TextField txtId;

    @FXML
    void onActorName(ActionEvent event) {
        ResultSet rs = null;
        try {
            rs = Database.sqlCommand(String.format("select store_id from customer where customer_id = %s", customerId));
            ArrayList<String> storeIds = new ArrayList<>();
            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    storeIds.add(rs.getString(i));
                }
            }
            ObservableList<ObservableList> data = FXCollections.observableArrayList();
            rs = Database.sqlCommand(String.format("select distinct film.film_id , title , release_year , length from film , film_actor , actor , inventory , store where film.film_id = film_actor.film_id and film_actor.actor_id = actor.actor_id film.film_id = inventory.film_id and inventory.store_id = store.store_id and inventory.store_id = %s and actor.first_name = \"%s\"", storeIds.get(0), txtId.getText()));
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
    void onGenre(ActionEvent event) {
        ResultSet rs = null;
        try {
            rs = Database.sqlCommand(String.format("select store_id from customer where customer_id = %s", customerId));
            ArrayList<String> storeIds = new ArrayList<>();
            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    storeIds.add(rs.getString(i));
                }
            }
            ObservableList<ObservableList> data = FXCollections.observableArrayList();
            rs = Database.sqlCommand(String.format("select distinct film.film_id , title , release_year , length from film , film_category , category , inventory , store where film.film_id = film_category.film_id and film_category.category_id = category.category_id and film.film_id = inventory.film_id and inventory.store_id = store.store_id and inventory.store_id = %s and category.name = \"%s\"", storeIds.get(0), txtId.getText()));
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
    void onLanguage(ActionEvent event) {
        ResultSet rs = null;
        try {
            rs = Database.sqlCommand(String.format("select store_id from customer where customer_id = %s", customerId));
            ArrayList<String> storeIds = new ArrayList<>();
            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    storeIds.add(rs.getString(i));
                }
            }
            ObservableList<ObservableList> data = FXCollections.observableArrayList();
            rs = Database.sqlCommand(String.format("select distinct film.film_id , title , release_year , length from film , language , inventory , store where film.language_id= language.language_id and  film.film_id = inventory.film_id and inventory.store_id = store.store_id and inventory.store_id = %s and language.name = \"%s\"", storeIds.get(0), txtId.getText()));
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
    void onName(ActionEvent event) {
        ResultSet rs = null;
        try {
            rs = Database.sqlCommand(String.format("select store_id from customer where customer_id = %s", customerId));
            ArrayList<String> storeIds = new ArrayList<>();
            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    storeIds.add(rs.getString(i));
                }
            }
            ObservableList<ObservableList> data = FXCollections.observableArrayList();
            rs = Database.sqlCommand(String.format("select distinct film.film_id , title , release_year , length from film  , inventory , store where  film.film_id = inventory.film_id and inventory.store_id = store.store_id and inventory.store_id = %s and film.title = \"%s\"", storeIds.get(0), txtId.getText()));
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
    void onYear(ActionEvent event) {
        ResultSet rs = null;
        try {
            rs = Database.sqlCommand(String.format("select store_id from customer where customer_id = %s", customerId));
            ArrayList<String> storeIds = new ArrayList<>();
            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    storeIds.add(rs.getString(i));
                }
            }
            ObservableList<ObservableList> data = FXCollections.observableArrayList();
            rs = Database.sqlCommand(String.format("select distinct film.film_id , title , release_year , length from film  , inventory , store where  film.film_id = inventory.film_id and inventory.store_id = store.store_id and inventory.store_id = %s and film.release_year = %s", storeIds.get(0), txtId.getText()));
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
