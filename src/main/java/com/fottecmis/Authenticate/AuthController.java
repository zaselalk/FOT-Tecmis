package com.fottecmis.Authenticate;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;

public class AuthController {
    private final AuthDatabaseConnection authDatabaseConnection = new AuthDatabaseConnection();

    @FXML
    private TextField email_address;
    @FXML
    private TextField password;

    private boolean authenticateUser(String email_address, String password) {
        try {
            PreparedStatement pres = authDatabaseConnection.getAuthConnection().prepareStatement("SELECT * FROM users WHERE email_address = ? AND plain_password = ?");

            pres.setString(1, email_address);
            pres.setString(2, password);

//            return true if the query returns a row
            return pres.executeQuery().next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void login() {
        if (authenticateUser(email_address.getText(), password.getText())) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login Failed");
        }
    }
}
