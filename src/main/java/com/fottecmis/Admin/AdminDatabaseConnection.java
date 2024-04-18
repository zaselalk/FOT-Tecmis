package com.fottecmis.Admin;

import com.fottecmis.Database.GetConnection;

import java.sql.Connection;

public class AdminDatabaseConnection {
    private final GetConnection getConnection = new GetConnection();

    public Connection getAdminConnection() {
        String username = "root";
        String password = "root";
        return getConnection.getMyConnection(username, password);
    }
}
