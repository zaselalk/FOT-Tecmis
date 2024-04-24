package com.fottecmis.Authenticate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.PreparedStatement;

public class AuthController {
    private final AuthDatabaseConnection authDatabaseConnection = new AuthDatabaseConnection();
    private Stage stage;
    private Scene scene;
    private Parent parent;

    @FXML
    private TextField email_address;
    @FXML
    private TextField password;

    boolean authenticateUser(String email_address, String password) {
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

    public void showLoginScreen(ActionEvent event) throws Exception {
        Parent loginscene = FXMLLoader.load(getClass().getResource("/com/fottecmis/Interfaces/Authenticate/auth.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(loginscene);
        stage.setScene(scene);
        stage.show();

    }
}
