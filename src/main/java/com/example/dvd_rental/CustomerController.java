package com.example.dvd_rental;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerController {
    static String customerId;
    @FXML
    private Label welcome_label;

    @FXML
    void onEditProfile(ActionEvent event) {
        CustomerEditProfile.customerId = customerId;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customer.EditProfile.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    void onFilmList(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("admin.filmList.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    void onMyFilms(ActionEvent event) {
        CustomerActiveRents.customerId = customerId;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customer.activeRents.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    void onMyHistiry(ActionEvent event) {
        CustomerMyFilms.customerId = customerId;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customer.MyHistory.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    void onPaymentInfo(ActionEvent event) {
        CustomerPaymentInfo.customerId = customerId;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customer.PaymentInfo.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    void onRentalInfo(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("admin.FilmInfo.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    void onReserveRequests(ActionEvent event) {
        CustomerReserveRequest.customerId = customerId;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customer.ReserveRequest.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    void onSearch(ActionEvent event) {
        CustomerSearch.customerId = customerId;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customer.Search.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    void onStoresInfo(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customer.StoresInfo.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.show();
    }

}
