package com.fottecmis.Lecturer;

import com.fottecmis.Shared.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.sql.Connection;

public class LecturerController extends LecturerDashboard {

    Connection connection;
    int lecturer_id;
    public void showSingleCourse(ActionEvent event) throws Exception {
        FXMLLoader loader = SceneHandler.createLoader("Lecturer/lecturer_single_course");
        Parent lecturerSingleCourseScene = loader.load();
        LecturerSingleCourseController lecturerSingleCourseController = loader.getController();
        lecturerSingleCourseController.initialize(lecturer_id, connection);
        SceneHandler.switchScene(event, lecturerSingleCourseScene);
    }

    public void showEditProfile(ActionEvent event) throws Exception {
        FXMLLoader loader = SceneHandler.createLoader("Lecturer/lecturer_edit_profile");
        Parent editProfileScene = loader.load();
        SceneHandler.switchScene(event, editProfileScene);
    }


    public void initialize(int userId) {
        System.out.println("LecturerController initialize method");
        try {
            lecturer_id = userId;
            connection = new LecturerDatabaseConnection().getLecturerConnection();

            System.out.println("Connection is:" + connection);

        } catch (Exception e) {
            System.out.println("Error in LecturerController initialize method");
            e.printStackTrace();
        }
    }
}
