package com.fottecmis.Lecturer;

import com.fottecmis.Shared.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.sql.Connection;

public class LecturerController extends LecturerDashboard {

    Connection connection;


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

            initializeLecturerDashboard(lecturer_id);

        } catch (Exception e) {
            System.out.println("Error in LecturerController initialize method");
            e.printStackTrace();
        }
    }
}
