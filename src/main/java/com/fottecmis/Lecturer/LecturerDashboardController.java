package com.fottecmis.Lecturer;

import com.fottecmis.Shared.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class LecturerDashboardController extends LecturerDashboard {

    public void showSingleCourse(ActionEvent event) throws Exception {
        FXMLLoader loader = SceneHandler.createLoader("Lecturer/lecturer_single_course");
        Parent lecturerSingleCourseScene = loader.load();
        SceneHandler.switchScene(event, lecturerSingleCourseScene);
    }

    public void showEditProfile(ActionEvent event) throws Exception {
        FXMLLoader loader = SceneHandler.createLoader("Lecturer/lecturer_edit_profile");
        Parent editProfileScene = loader.load();
        SceneHandler.switchScene(event, editProfileScene);
    }


}
