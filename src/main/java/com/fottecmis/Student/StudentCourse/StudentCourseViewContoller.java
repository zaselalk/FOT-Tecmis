package com.fottecmis.Student.StudentCourse;

import com.fottecmis.Shared.Modules.Course.Course;
import com.fottecmis.Student.StudentController;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentCourseViewContoller extends StudentController {
    public TableView<Course> studentCourseView;
    List<Course> studentCourses = new ArrayList<>();
    private int student_id;
    private Connection connection;

    public void initialize(int user_id, Connection connection) {
        this.student_id = 1;
        this.connection = connection;
    }

    public void showStudentMedical() {
        try {
            studentCourses = new StudentCourseController(connection).getCoursesByStudentId(student_id);
            studentCourseView.setItems(FXCollections.observableList(studentCourses));
            createTableView();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTableView() {

        if (this.studentCourses == null) {
            return;
        }

//        course id
        TableColumn<Course, Integer> courseId = new TableColumn<>("ID");
        courseId.setCellValueFactory(new PropertyValueFactory<>("course_id"));

//        course name
        TableColumn<Course, String> courseName = new TableColumn<>("Course Name");
        courseName.setCellValueFactory(new PropertyValueFactory<>("course_name"));


//        course level
        TableColumn<Course, Integer> courseLevel = new TableColumn<>("Level");
        courseLevel.setCellValueFactory(new PropertyValueFactory<>("level"));

//        course semester
        TableColumn<Course, Integer> courseSemester = new TableColumn<>("Semester");
        courseSemester.setCellValueFactory(new PropertyValueFactory<>("semester"));

//        is gpa
        TableColumn<Course, String> isGpa = new TableColumn<>("GPA");
        isGpa.setCellValueFactory(new PropertyValueFactory<>("is_gpa"));

        studentCourseView.getColumns().addAll(courseId, courseName, courseLevel, courseSemester, isGpa);

        studentCourseView.setItems(FXCollections.observableList(studentCourses));

    }
}
