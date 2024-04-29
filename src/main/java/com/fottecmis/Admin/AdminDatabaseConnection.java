package com.fottecmis.Admin;

import com.fottecmis.Shared.DatabaseConnectionException;
import com.fottecmis.Shared.GetConnection;

import java.sql.Connection;

public class AdminDatabaseConnection {
    private final GetConnection getConnection = new GetConnection();

    public Connection getAdminConnection() throws DatabaseConnectionException {
        String username = "root";
        String password = "12345";
        return getConnection.getMyConnection(username, password);
    }
}
