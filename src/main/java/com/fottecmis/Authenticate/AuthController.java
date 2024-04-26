package com.fottecmis.Authenticate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AuthController {
    private final AuthDatabaseConnection authDatabaseConnection = new AuthDatabaseConnection();
    private Stage stage;
    private Scene scene;
    private Parent parent;
    private Connection connection;

    @FXML
    private TextField email_address;
    @FXML
    private TextField password;


    public AuthController() {
        try {
            authDatabaseConnection.getAuthConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    boolean authenticateUser(String email_address, String password) {
        try {
            PreparedStatement pres = connection.prepareStatement("SELECT * FROM users WHERE email_address = ? AND plain_password = ?");

            pres.setString(1, email_address);
            pres.setString(2, password);

            return pres.executeQuery().next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void login(ActionEvent event) throws Exception {

        if (authenticateUser(email_address.getText(), password.getText())) {
            System.out.println("Login Successful");
            System.out.println(getUserTypeByEmail(email_address.getText()));
            showDashboard(event, getUserTypeByEmail(email_address.getText()));

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

    public String getUserTypeByEmail(String email_address) {
        try {
            PreparedStatement pres = authDatabaseConnection.getAuthConnection().prepareStatement("SELECT role FROM users WHERE email_address = ?");
            pres.setString(1, email_address);
            pres.executeQuery();

            if (pres.getResultSet().next()) {
                return pres.getResultSet().getString("role");
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void showDashboard(ActionEvent event, String userType) {

        switch (userType) {
            case "admin":
                try {
                    showAdminDash(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "student":
                try {
                    showStudentDash(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "lecturer":
                try {
                    showLecturerDash(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "technical_officer":
                try {
                    showTechnicalOfficerDash(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Invalid User Type");
        }
    }

    public void showAdminDash(ActionEvent event) throws IOException {
        Parent loginscene = FXMLLoader.load(getClass().getResource("/com/fottecmis/Interfaces/Admin/admin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(loginscene);
        stage.setScene(scene);
        stage.show();
    }

    public void showStudentDash(ActionEvent event) throws IOException {
        Parent loginscene = FXMLLoader.load(getClass().getResource("/com/fottecmis/Interfaces/Student/student.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(loginscene);
        stage.setScene(scene);
        stage.show();
    }

    public void showLecturerDash(ActionEvent event) throws IOException {
        Parent loginscene = FXMLLoader.load(getClass().getResource("/com/fottecmis/Interfaces/Lecturer/lecturer.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(loginscene);
        stage.setScene(scene);
        stage.show();
    }

    public void showTechnicalOfficerDash(ActionEvent event) throws IOException {
        Parent loginscene = FXMLLoader.load(getClass().getResource("/com/fottecmis/Interfaces/TechnicalOfficer/technical_officer.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(loginscene);
        stage.setScene(scene);
        stage.show();
    }

}
