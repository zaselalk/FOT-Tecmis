package com.fottecmis.Authenticate;

import com.fottecmis.Admin.AdminController;
import com.fottecmis.Lecturer.LecturerCourse.LecturerCourseSelectionViewController;
import com.fottecmis.Shared.SceneHandler;
import com.fottecmis.Student.StudentController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AuthController {
    private final AuthDatabaseConnection authDatabaseConnection = new AuthDatabaseConnection();
    private Parent parent;
    private Connection connection;
    private int user_id;

    @FXML
    private TextField email_address;
    @FXML
    private TextField password;


    public AuthController() {
        try {
            connection = authDatabaseConnection.getAuthConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    boolean authenticateUser(String email_address, String password) {
        try {
            PreparedStatement pres = connection.prepareStatement("SELECT user_id FROM users WHERE email_address = ? AND plain_password = ?");

            pres.setString(1, email_address);
            pres.setString(2, password);

            if (pres.executeQuery().next()) {
                user_id = pres.getResultSet().getInt("user_id");
                return true;
            } else {
                return false;
            }

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
        FXMLLoader loader = SceneHandler.createLoader("Authenticate/auth");
        Parent root = loader.load();
        SceneHandler.switchScene(event, root);
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
                    showAdminDashboard(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "student":
                try {
                    showStudentDashboard(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "lecturer":
                try {
                    showLecturerDashboard(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "technical_officer":
                try {
                    showTechnicalOfficerDashboard(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Invalid User Type");
        }
    }

    public void showAdminDashboard(ActionEvent event) throws IOException {
        FXMLLoader loader = SceneHandler.createLoader("Admin/admin");
        Parent root = loader.load();
        AdminController admincontroller = loader.getController();
        admincontroller.initialize(user_id, connection);
        SceneHandler.switchScene(event, root);
    }

    public void showStudentDashboard(ActionEvent event) throws IOException {
        FXMLLoader loader = SceneHandler.createLoader("Student/student");
        Parent stundentScene = loader.load();
        StudentController studentController = loader.getController();
        studentController.initialize(user_id);
        SceneHandler.switchScene(event, stundentScene);
    }

    public void showLecturerDashboard(ActionEvent event) throws IOException {
        FXMLLoader loader = SceneHandler.createLoader("Lecturer/lecturer_select_course");
        Parent lecturerScene = loader.load();

        LecturerCourseSelectionViewController lecturerCourseSelectionViewController = loader.getController();
        lecturerCourseSelectionViewController.initialize(1);
        lecturerCourseSelectionViewController.showCourses();

        SceneHandler.switchScene(event, lecturerScene);
    }

    public void showTechnicalOfficerDashboard(ActionEvent event) throws IOException {
        FXMLLoader loader = SceneHandler.createLoader("TechnicalOfficer/technical_officer");
        Parent technicalOfficerScene = loader.load();
        SceneHandler.switchScene(event, technicalOfficerScene);
    }

}
