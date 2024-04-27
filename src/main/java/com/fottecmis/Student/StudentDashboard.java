package com.fottecmis.Student;

import com.fottecmis.Shared.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class StudentDashboard {


    public void showStudentDashboard(ActionEvent event) throws IOException {
        FXMLLoader loader = SceneHandler.createLoader("Student/student");
        Parent studentDashboardScene = loader.load();
        SceneHandler.switchScene(event, studentDashboardScene);
    }


}
