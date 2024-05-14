package com.fottecmis.Student.StudentAttendance;

import com.fottecmis.Shared.Modules.Attendance.Attendance;
import com.fottecmis.Shared.Modules.Course.Course;
import com.fottecmis.Student.StudentCourse.StudentCourseController;
import com.fottecmis.Student.StudentDashboard;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentAttendaceViewController extends StudentDashboard {
    private int student_id;
    private int course_id;
    private Connection connection;
    @FXML
    private TableView<Course> course_table_view;
    @FXML
    private TableView<Attendance> attendance_table_view;
    private List<Course> studentCourses;
    private List<Attendance> attendancesList;
    @FXML
    private TableColumn<Attendance, Integer> attendanceId;
    @FXML
    private TableColumn<Attendance, String> attendanceDate;

    @FXML
    private TableColumn<Attendance, String> attendanceStatus;

    public void initialize(Connection connection, int student_id) {
        this.student_id = student_id;
        this.connection = connection;

        // get course id when clicked
        course_table_view.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                Course selectedCourse = newSelection;
                setCourse_id(selectedCourse.getCourse_id());
                showStudentAttendance();
            }

        });
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    @FXML
    public void showStudentCourse() {
        try {
            studentCourses = new StudentCourseController(connection).getCoursesByStudentId(student_id);
            createCourseSelectTableView();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createCourseSelectTableView() {

//        get courses for student

        TableColumn<Course, Integer> courseId = new TableColumn<>("ID");
        courseId.setCellValueFactory(new PropertyValueFactory<>("course_id"));

        TableColumn<Course, String> courseName = new TableColumn<>("Course Name");
        courseName.setCellValueFactory(new PropertyValueFactory<>("course_name"));

//        add columns to table view
        course_table_view.getColumns().addAll(courseId, courseName);

        //        set items to table view
        course_table_view.setItems(FXCollections.observableList(studentCourses));

    }

    public void createAttendanceTableView() {
        attendance_table_view.getItems().clear();

        if (attendancesList == null) {
            System.out.println("No attendance found");
            attendance_table_view.setVisible(false);
            return;
        }

        attendanceId.setCellValueFactory(new PropertyValueFactory<>("attendance_id"));
        attendanceDate.setCellValueFactory(new PropertyValueFactory<>("attendance_date"));
        attendanceStatus.setCellValueFactory(new PropertyValueFactory<>("attendance_staus"));

        attendance_table_view.getColumns().clear();
        attendance_table_view.getColumns().addAll(attendanceId, attendanceDate, attendanceStatus);
        attendance_table_view.setItems(FXCollections.observableList(attendancesList));
        attendance_table_view.setVisible(true);
    }

    public void showStudentAttendance() {

        if (course_id == 0) {
            System.out.println("Please select a course");
            return;
        }

        try {
            System.out.println("Student ID: " + student_id + " Course ID: " + course_id);
            attendancesList = new StudentAttendanceController(connection).getStudentAttendanceForCourse(student_id, course_id);
            createAttendanceTableView();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
