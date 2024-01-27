module com.example.dvd_rental {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.dvd_rental to javafx.fxml;
    exports com.example.dvd_rental;
}