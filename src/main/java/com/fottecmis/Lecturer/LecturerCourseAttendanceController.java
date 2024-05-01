package com.fottecmis.Lecturer;

import com.fottecmis.Shared.Modules.Course.Course;
import com.fottecmis.Shared.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.sql.Connection;

public class LecturerCourseAttendanceController extends LecturerDashboard {
    protected Course course;
    protected int lecturer_id;
    protected Connection connection;

    public void initialize(Course course, int lecturer_id, Connection connection) {
        this.course = course;
        this.lecturer_id = lecturer_id;
        this.connection = connection;
    }

    public void backToCourse(ActionEvent event) throws Exception {
        FXMLLoader loader = SceneHandler.createLoader("Lecturer/lecturer_single_course");
        Parent lecturerDashboardScene = loader.load();
        LecturerSingleCourseController lecturerCourseSelectionViewController = loader.getController();
        lecturerCourseSelectionViewController.initialize(lecturer_id, connection, course);
        SceneHandler.switchScene(event, lecturerDashboardScene);
    }
}
