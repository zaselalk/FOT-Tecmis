package com.fottecmis.TecnicalOfficer;

import com.fottecmis.Shared.Modules.Attendance.Attendance;
import com.fottecmis.Shared.Modules.Course.Course;
import com.fottecmis.Shared.Modules.Course.CourseController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.SQLException;
import java.util.List;

public class TechnicalOfficerAttendanceViewController extends TechnicalOfficerDashboard {

    @FXML
    private TableView<Course> course_table_view;
    @FXML
    private TableView<Attendance> attendance_table_view;

    private TableColumn<Attendance, Integer> attendanceId;
    @FXML
    private TableColumn<Attendance, String> attendanceDate;
    @FXML
    private TableColumn<Attendance, String> attendanceStatus;
    @FXML
    private TableColumn<Attendance, String> attendance;

    private int course_id;
    List<Course> coursesList;

    public void initialize() {
        // get course id when clicked
        course_table_view.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                Course selectedCourse = newSelection;
                setCourse_id(selectedCourse.getCourse_id());
//                showStudentAttendance();
            }
        });
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public void showAllCourses() {
        try {
            coursesList = new CourseController(connection).getAllCourses();
            createCourseSelectTableView();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

//    public void showStudentAttendance() {
//        try {
//            List<Attendance> attendancesList = new S
//            createAttendanceTableView(attendancesList);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public void createCourseSelectTableView() {
        course_table_view.getItems().clear();
        course_table_view.getColumns().clear();
        course_table_view.setItems(FXCollections.observableList(coursesList));
    }

    public void createAttendanceTableView(List<Attendance> attendancesList) {
        attendance_table_view.getItems().clear();
        attendance_table_view.getColumns().clear();
        attendance_table_view.setItems(FXCollections.observableList(attendancesList));
    }
}

