package com.fottecmis.Shared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetConnection {
    private static final Logger LOGGER = Logger.getLogger(GetConnection.class.getName());
    private void registerConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Successfully registerd");
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Error in registering the driver", e);
        }
    }

    public Connection getMyConnection(String user, String password) throws DatabaseConnectionException {
        try {
            registerConnection();
            String url = "jdbc:mysql://mysql-server-tecmis.mysql.database.azure.com:3306/tecmis?useSSL=true&requireSSL=false&serverTimezone=UTC";

            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error in getting connection", e);
            throw new DatabaseConnectionException("Error in getting connection");
        }
    }
}
