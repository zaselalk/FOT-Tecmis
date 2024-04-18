package com.fottecmis.Lecturer;

import com.fottecmis.Database.DatabaseConnectionException;
import com.fottecmis.Database.GetConnection;

import java.sql.Connection;

public class LecturerDatabaseConnection {
    private final GetConnection getConnection = new GetConnection();

    public Connection getLecturerConnection() throws DatabaseConnectionException {
        String username = "lecturer";
        String password = "lecturer";
        return getConnection.getMyConnection(username, password);
    }
}
