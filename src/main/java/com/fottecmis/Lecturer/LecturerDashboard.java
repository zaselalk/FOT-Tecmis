package com.fottecmis.Lecturer;

import com.fottecmis.Lecturer.LecturerCourse.LecturerCourseSelectionViewController;
import com.fottecmis.Shared.Modules.Course.Course;
import com.fottecmis.Shared.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.sql.Connection;

public class LecturerDashboard {
    protected int lecturer_id;
    protected Connection connection;
    protected Course course;

    public void initializeLecturerDashboard(int user_id, Connection connection) {
        this.lecturer_id = user_id;
        this.connection = connection;
    }


    public void showLecturerDashboard(ActionEvent event) throws IOException {
        FXMLLoader loader = SceneHandler.createLoader("Lecturer/lecturer_select_course");
        Parent lecturerDashboardScene = loader.load();
        LecturerCourseSelectionViewController lecturerCourseSelectionViewController = loader.getController();
        lecturerCourseSelectionViewController.initialize(lecturer_id);
        SceneHandler.switchScene(event, lecturerDashboardScene);
    }

    public void backToCourse(ActionEvent event) throws Exception {

        if (connection == null) {
            System.out.println("No connection");
            return;
        }

        FXMLLoader loader = SceneHandler.createLoader("Lecturer/lecturer_single_course");
        Parent lecturerDashboardScene = loader.load();
        LecturerSingleCourseController lecturerCourseSelectionViewController = loader.getController();
        lecturerCourseSelectionViewController.initialize(lecturer_id, connection, course);
        SceneHandler.switchScene(event, lecturerDashboardScene);
    }
}
