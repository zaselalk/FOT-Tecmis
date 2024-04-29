package com.fottecmis.Shared;

public class DatabaseConnectionException extends Exception {
    public DatabaseConnectionException(String message) {
        super(message);
        System.out.println("Database Connection Exception: " + message);

    }
}
