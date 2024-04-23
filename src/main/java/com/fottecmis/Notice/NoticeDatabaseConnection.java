package com.fottecmis.Notice;

import com.fottecmis.Shared.DatabaseConnectionException;
import com.fottecmis.Shared.GetConnection;

import java.sql.Connection;

public class NoticeDatabaseConnection {
    private final GetConnection getConnection = new GetConnection();

    public Connection getAuthConnection() throws DatabaseConnectionException {
        String username = "student";
        String password = "stu123";
        return getConnection.getMyConnection(username, password);
    }
}
