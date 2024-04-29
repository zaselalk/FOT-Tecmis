package com.fottecmis.Lecturer.LecturerCourse;

import com.fottecmis.Lecturer.LecturerController;
import com.fottecmis.Lecturer.LecturerDatabaseConnection;
import com.fottecmis.Lecturer.LecturerSingleCourseController;
import com.fottecmis.Shared.Modules.Course.Course;
import com.fottecmis.Shared.SceneHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class LecturerCourseSelectionViewController extends LecturerController {
    public javafx.scene.control.ListView courseList;
    private int lecturer_id;
    private Connection connection;


    public void initialize(int lecturer_id) {
        this.lecturer_id = lecturer_id;
        try {
            connection = new LecturerDatabaseConnection().getLecturerConnection();
            showCourses();
        } catch (Exception e) {
            e.printStackTrace();
        }

        courseList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                Course course = new LecturerCourseSelectorController(connection).getCourseByName(newValue.toString());
                FXMLLoader loader = SceneHandler.createLoader("Lecturer/lecturer_single_course");
                Parent lecturerSingleCourseScene = loader.load();
                LecturerSingleCourseController lecturerSingleCourseController = loader.getController();
                lecturerSingleCourseController.initialize(lecturer_id, connection, course);
                ActionEvent event = new ActionEvent(courseList, null);
                SceneHandler.switchScene(event, lecturerSingleCourseScene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void showCourses() {
        try {
            List<Course> courses;
            courses = new LecturerCourseSelectorController(connection).getCoursesByLecturerId(lecturer_id);

            ObservableList<String> courseNames = FXCollections.observableArrayList(); // Use ObservableList

            for (Course course : courses) {
                courseNames.add(course.getCourse_name());
            }

            courseList.setItems(courseNames);

            // add event listener to the list view

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
