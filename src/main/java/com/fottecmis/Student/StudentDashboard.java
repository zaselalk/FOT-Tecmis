package com.fottecmis.Student;

import com.fottecmis.Shared.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.sql.Connection;

public class StudentDashboard {
    Connection connection;
    String name;
    String department;
    public void showStudentDashboard(ActionEvent event) throws IOException {
        FXMLLoader loader = SceneHandler.createLoader("Student/student");
        Parent studentDashboardScene = loader.load();
        StudentController stdController = loader.getController();
        stdController.initialize(1);
        SceneHandler.switchScene(event, studentDashboardScene);
    }


}
