package com.example.dvd_rental;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

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
        AdminCustomrtInfo.staffId = staffId;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("admin.customrtInfo.fxml"));
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
    void onPayment(ActionEvent event){
        AdminPaymentinfo.staffId = staffId;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("admin.paymentinfo.fxml"));
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

    public void onFilmInfo(ActionEvent event) {
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

    public void onActiveRent(ActionEvent event) {
        AdminActiveRent.staffId = staffId;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("admin.ActiveRents.fxml"));
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

    public void onReserverequests(ActionEvent event) {
        AdminReserveRequests.staffId = staffId;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("admin.reserveRequests.fxml"));
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

    public void onBestselling(ActionEvent event) {
        adminBestSelling.AdminBestSelling.staffId = staffId;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("admin.bestSelling.fxml"));
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

    public void onStoreinfo(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("admin.storeInfo.fxml"));
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

    public void onFilmlists(ActionEvent event) {
        AdminFilmList.staffId = staffId;
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

    public void onSearchinfilms(ActionEvent event) {
        AdminSearch.staffId = staffId;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("admin.search.fxml"));
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
