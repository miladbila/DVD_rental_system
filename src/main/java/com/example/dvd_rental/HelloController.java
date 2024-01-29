package com.example.dvd_rental;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloController {
    Alert alert = new Alert(Alert.AlertType.ERROR, "username or password incorrect", ButtonType.OK);
    @FXML
    private RadioButton adminRadio;

    @FXML
    private RadioButton customerRadio;

    @FXML
    private TextField txt_AccountName;

    @FXML
    private PasswordField txt_Password;

    @FXML
    void clickLogin(MouseEvent event) {
        if (customerRadio.isSelected()) {
            ResultSet result;
            try {
                result = Database.sqlCommand(String.format("select customer_id from customer where username = \"%s\" and password = \"%s\"", txt_AccountName.getText(), txt_Password.getText()));
                if (!result.next())
                    alert.showAndWait();
                else {
                    CustomerController.customerId = result.getString("customer_id");
                    Parent parent;
                    try {
                        parent = FXMLLoader.load(HelloApplication.class.getResource("customer.fxml"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(parent);
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.show();
                }
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }

        } else {
            ResultSet result;
            try {
                result = Database.sqlCommand(String.format("select staff_id, first_name, last_name from staff where username = \"%s\" and password = \"%s\"", txt_AccountName.getText(), txt_Password.getText()));
                if (!result.next())
                    alert.showAndWait();
                else {
                    AdminController.staffId = result.getString("staff_id");
                    AdminController.firstName = result.getString("first_name");
                    AdminController.lastName = result.getString("last_name");
                    Parent parent;
                    try {
                        parent = FXMLLoader.load(HelloApplication.class.getResource("admin.fxml"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(parent);
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.show();
                }
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void clickSignUp(MouseEvent event) {
        Parent parent;
        try {
            parent = FXMLLoader.load(HelloApplication.class.getResource("SignUp.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onAdminRadio(ActionEvent event) {
        customerRadio.setSelected(false);
    }

    @FXML
    void onCustomerRadio(ActionEvent event) {
        adminRadio.setSelected(false);
    }

}
