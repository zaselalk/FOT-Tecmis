package com.fottecmis.Lecturer;

import com.fottecmis.Shared.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class LecturerDashboard {
    public void showLecturerDashboard(ActionEvent event) throws IOException {
        FXMLLoader loader = SceneHandler.createLoader("Lecturer/lecturer_select_course");
        Parent lecturerDashboardScene = loader.load();
        SceneHandler.switchScene(event, lecturerDashboardScene);
    }
}
