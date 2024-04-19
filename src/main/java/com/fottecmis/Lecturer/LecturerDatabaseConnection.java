package com.fottecmis.Lecturer;

import com.fottecmis.Shared.DatabaseConnectionException;
import com.fottecmis.Shared.GetConnection;

import java.sql.Connection;

public class LecturerDatabaseConnection {
    private final GetConnection getConnection = new GetConnection();

    public Connection getLecturerConnection() throws DatabaseConnectionException {
        String username = "lecturer";
        String password = "lecturer";
        return getConnection.getMyConnection(username, password);
    }
}
