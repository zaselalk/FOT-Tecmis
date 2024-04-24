package com.fottecmis.Authenticate;

import com.fottecmis.Shared.DatabaseConnectionException;
import com.fottecmis.Shared.GetConnection;

import java.sql.Connection;

public class AuthDatabaseConnection {
    private final GetConnection getConnection = new GetConnection();

    public Connection getAuthConnection() throws DatabaseConnectionException {
        String username = "authenticate";
        String password = "auth123";
        return getConnection.getMyConnection(username, password);
    }
}
