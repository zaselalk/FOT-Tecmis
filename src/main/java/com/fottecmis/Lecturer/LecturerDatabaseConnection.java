package com.fottecmis.Lecturer;

import com.fottecmis.Shared.DatabaseConnectionException;
import com.fottecmis.Shared.GetConnection;

import java.sql.Connection;

public class LecturerDatabaseConnection {
    private final GetConnection getConnection = new GetConnection();

    public Connection getLecturerConnection() throws DatabaseConnectionException {
        String username = "lecturer";
        String password = "lec123";
        return getConnection.getMyConnection(username, password);
    }
}
