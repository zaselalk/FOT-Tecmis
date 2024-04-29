package com.fottecmis.Student;

import com.fottecmis.Shared.DatabaseConnectionException;
import com.fottecmis.Shared.GetConnection;

import java.sql.Connection;

public class StudentDatabaseConnection {
    private final GetConnection getConnection = new GetConnection();

    public Connection getStudentDBConnection() throws DatabaseConnectionException {
        String username = "student";
        String password = "stu123";
        return getConnection.getMyConnection(username, password);
    }
}
