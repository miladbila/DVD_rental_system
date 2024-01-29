package com.example.dvd_rental;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.ResultSet;
import java.sql.SQLException;


 public  class CustomerReserveRequest {
    static String customerId;

    @FXML
    private Button btndone;

    @FXML
    private Label lbllist;

    @FXML
    private TextField txtFilmId;

    @FXML
    private TextField txtStoreId;

    @FXML
    void onDone(ActionEvent event) {
        try {
            ResultSet tdelay =  Database.sqlCommand(String.format("select delay from customer where customer_id = %s", customerId));
            tdelay.next();
            String delay = tdelay.getString("delay");
            if(Integer.parseInt(delay)>9){
                Alert alert = new Alert(Alert.AlertType.ERROR, "you have been blocked", ButtonType.OK);
                alert.showAndWait();
                return;
            }
            ResultSet maxR = Database.sqlCommand(String.format("select count(rental_id) as rent_num from rental where customer_id = %s and return_date = null", customerId));
            maxR.next();
            String max_rent = maxR.getString("rent_num");
            if(Integer.parseInt(max_rent)>3){
                Alert alert = new Alert(Alert.AlertType.ERROR, "you have been blocked", ButtonType.OK);
                alert.showAndWait();
                return;
            }
           ResultSet inventory_id =  Database.sqlCommand(String.format("select inventory_id from inventory where film_id = %s", txtFilmId.getText()));
           inventory_id.next();
           String inventories = inventory_id.getString("inventory_id");
           ResultSet staff_id =  Database.sqlCommand(String.format("select manager_staff_id as staff_id from store where store_id = %s", txtStoreId.getText()));
           staff_id.next();
            String staffs = staff_id.getString("staff_id");
            Database.sqlCommand(String.format("insert into rental (inventory_id,customer_id,staff_id) values (%s,%s,%s)" ,inventories,customerId,staffs));

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
