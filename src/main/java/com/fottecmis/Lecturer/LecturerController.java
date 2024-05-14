package com.fottecmis.Lecturer;

import com.fottecmis.Shared.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.sql.Connection;

public class LecturerController extends LecturerDashboard {

    public Connection connection;
    int lecturer_id;


    public void showEditProfile(ActionEvent event) throws Exception {
        FXMLLoader loader = SceneHandler.createLoader("Lecturer/lecturer_edit_profile");
        Parent editProfileScene = loader.load();
        SceneHandler.switchScene(event, editProfileScene);
    }


    public void initializeDashboard(int userId, Connection connection) {
        try {
            lecturer_id = userId;
            connection = connection;
            initializeLecturerDashboard(lecturer_id, connection);

        } catch (Exception e) {
            System.out.println("Error in LecturerController initialize method");
            e.printStackTrace();
        }
    }
}
