package com.example.dvd_rental;

import java.sql.*;

public class Database {
    static ResultSet sqlCommand (String sqlCommand) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/sakila", "root", "bilabila");
        Statement s = connection.prepareStatement(sqlCommand);
        if (sqlCommand.split(" ")[0].toLowerCase().equals("select"))
            return s.executeQuery(sqlCommand);
        else {
            s.execute(sqlCommand);
            return null;
        }
    }

}
