package com.fottecmis.Authenticate;

import com.fottecmis.Database.DatabaseConnectionException;
import com.fottecmis.Database.GetConnection;

import java.sql.Connection;

public class AuthDatabaseConnection {
    private final GetConnection getConnection = new GetConnection();

    public Connection getAuthConnection() throws DatabaseConnectionException {
        String username = "authenticate";
        String password = "auth123";
        return getConnection.getMyConnection(username, password);
    }
}
