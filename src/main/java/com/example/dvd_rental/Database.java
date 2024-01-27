package com.example.dvd_rental;

import java.sql.*;

public class Database {
    static ResultSet sqlCommand (String sqlCommand) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/sakila", "root", "bilabila");
        Statement s = connection.prepareStatement(sqlCommand);
        return s.executeQuery(sqlCommand);
    }

}
