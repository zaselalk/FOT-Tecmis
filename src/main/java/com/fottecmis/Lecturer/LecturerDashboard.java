package com.fottecmis.Lecturer;

import com.fottecmis.Lecturer.LecturerCourse.LecturerCourseSelectionViewController;
import com.fottecmis.Shared.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class LecturerDashboard {
    protected int lecturer_id;
    public void showLecturerDashboard(ActionEvent event) throws IOException {
        FXMLLoader loader = SceneHandler.createLoader("Lecturer/lecturer_select_course");
        Parent lecturerDashboardScene = loader.load();
        LecturerCourseSelectionViewController lecturerCourseSelectionViewController = loader.getController();
        lecturerCourseSelectionViewController.initialize(1);
        SceneHandler.switchScene(event, lecturerDashboardScene);
    }
}
