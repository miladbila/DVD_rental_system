package com.example.dvd_rental;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

import java.sql.SQLException;

public class SignUpController {

    @FXML
    private RadioButton CustomerRadio;

    @FXML
    private RadioButton adminRadio;

    @FXML
    private Button btn_save;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;

    @FXML
    private Label lbl4;

    @FXML
    private Label lbl5;

    @FXML
    private Label lbl6;

    @FXML
    private Label lbl8;

    @FXML
    private Label lbl81;

    @FXML
    private Label lbl811;

    @FXML
    private Rectangle rec;

    @FXML
    private TextField txt_address;

    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_lastname;

    @FXML
    private TextField txt_name;

    @FXML
    private PasswordField txt_pass;

    @FXML
    private TextField txt_store;

    @FXML
    private TextField txt_username;

    public void initialize(){
        adminRadio.setSelected(true);
    }
    @FXML
    void clickSave(MouseEvent event) throws SQLException, ClassNotFoundException {
        if (adminRadio.isSelected()){
            String[] storeIds = txt_store.getText().split(" ");
            if (storeIds.length > 2 || storeIds.length < 1){
                Alert alert = new Alert(Alert.AlertType.ERROR, "admin only can manage 2 stores", ButtonType.OK);
                alert.showAndWait();
            } else if (storeIds.length == 2){
                try {
                    Database.sqlCommand(String.format("insert into staff(first_name, last_name,address_id ,email, username, password) values (\"%s\",\"%s\",%s,\"%s\",\"%s\",\"%s\")",txt_name.getText(),txt_lastname.getText(),txt_address.getText(),txt_email.getText(),txt_username.getText(),txt_pass.getText()));
                    Database.sqlCommand(String.format("update store set manager_staff_id = (SELECT staff_id FROM staff ORDER BY staff_id DESC LIMIT 1)  where store_id = %s",storeIds[0]));
                    Database.sqlCommand(String.format("update store set manager_staff_id = (SELECT staff_id FROM staff ORDER BY staff_id DESC LIMIT 1)  where store_id = %s",storeIds[1]));
                } catch (ClassNotFoundException | SQLException e) {
                    throw new RuntimeException(e);
                }
            } else {
                Database.sqlCommand(String.format("insert into staff(first_name, last_name,address_id ,email, username, password) values (\"%s\",\"%s\",%s,\"%s\",\"%s\",\"%s\")",txt_name.getText(),txt_lastname.getText(),txt_address.getText(),txt_email.getText(),txt_username.getText(),txt_pass.getText()));
                Database.sqlCommand(String.format("update store set manager_staff_id = (SELECT staff_id FROM staff ORDER BY staff_id DESC LIMIT 1)  where store_id = %s",storeIds[0]));
            }
        } else {
            String[] storeIds = txt_store.getText().split(" ");
            if (storeIds.length != 1){
                Alert alert = new Alert(Alert.AlertType.ERROR, "customer only can join 1 store", ButtonType.OK);
                alert.showAndWait();
            } else {
                Database.sqlCommand(String.format("insert into customer(first_name, last_name,address_id ,email, username, password, store_id) values (\"%s\",\"%s\",%s,\"%s\",\"%s\",\"%s\",\"%s\")",txt_name.getText(),txt_lastname.getText(),txt_address.getText(),txt_email.getText(),txt_username.getText(),txt_pass.getText(),storeIds[0]));
            }
        }
    }

    @FXML
    void onAdmin(ActionEvent event) {
        adminRadio.setSelected(true);
        CustomerRadio.setSelected(false);
    }

    @FXML
    void onCustomer(ActionEvent event) {
        adminRadio.setSelected(false);
        CustomerRadio.setSelected(true);

    }

}
