package com.fottecmis.TecnicalOfficer;


import com.fottecmis.Shared.DatabaseConnectionException;
import com.fottecmis.Shared.GetConnection;

import java.sql.Connection;

public class TechnicalOfficerDatabaseConnection {
    private final GetConnection getConnection = new GetConnection();

    public Connection getOfficerConnection() throws DatabaseConnectionException {
        String username = "student";
        String password = "stu123";
        return getConnection.getMyConnection(username, password);
    }
}

