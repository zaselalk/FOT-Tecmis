package com.fottecmis.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
    private void registerConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Successfully registerd");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Connection getMyConnection(String user, String password) {
        try {
            registerConnection();
            String url = "Jdbc:mysql://localhost:3306/student";

            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
