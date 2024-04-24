package com.fottecmis.Student;

import com.fottecmis.Shared.DatabaseConnectionException;
import com.fottecmis.Shared.GetConnection;

import java.sql.Connection;

public class StudentDatabaseConnection {
    private final GetConnection getConnection = new GetConnection();

    public Connection getLecturerConnection() throws DatabaseConnectionException {
        String username = "student";
        String password = "stdpass123";
        return getConnection.getMyConnection(username, password);
    }
}
