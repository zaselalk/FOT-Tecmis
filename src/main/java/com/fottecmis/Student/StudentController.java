package com.fottecmis.Student;

import com.fottecmis.Shared.DatabaseConnectionException;
import com.fottecmis.Shared.Modules.Student.Student;
import com.fottecmis.Shared.Modules.Student.StudentDBController;
import com.fottecmis.Shared.SceneHandler;
import com.fottecmis.Student.StudentAttendance.StudentAttendaceViewController;
import com.fottecmis.Student.StudentCourse.StudentCourseViewContoller;
import com.fottecmis.Student.StudentMedical.StudentMedicalViewController;
import com.fottecmis.Student.StudentNotice.StudentNoticeViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class StudentController extends StudentDashboard {
    private int student_id;
    @FXML
    private Label std_name;
    @FXML
    private Label std_department;
    private Student student;


    public void viewStudentCourse(ActionEvent event) throws IOException {
        FXMLLoader loader = SceneHandler.createLoader("Student/student-course");
        Parent studentCourseScene = loader.load();
        StudentCourseViewContoller studentCourseController = loader.getController();
        studentCourseController.initialize(student_id, connection);
        studentCourseController.showStudentMedical();
        SceneHandler.switchScene(event, studentCourseScene);
    }
    public void viewStudentAttendance(ActionEvent event) throws IOException {
        FXMLLoader loader = SceneHandler.createLoader("Student/student-attendance");
        Parent studentAttendanceScene = loader.load();
        StudentAttendaceViewController studentAttendanceController = loader.getController();
        studentAttendanceController.initialize(connection, student_id);
        studentAttendanceController.showStudentCourse();
        SceneHandler.switchScene(event, studentAttendanceScene);
    }

    public void viewStudentGrade(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = SceneHandler.createLoader("Student/student-grade");
        Parent studentGradeScene = loader.load();
        StudentGradeController studentGradeController = loader.getController();
        studentGradeController.initialize(connection, student_id);
        SceneHandler.switchScene(event, studentGradeScene);
    }

    public void viewStudentTimetable(ActionEvent event) throws IOException {
        FXMLLoader loader = SceneHandler.createLoader("Student/student-timetable");
        Parent studentTimetableScene = loader.load();
        SceneHandler.switchScene(event, studentTimetableScene);
    }

    public void viewStudentMedical(ActionEvent event) throws IOException {
        FXMLLoader loader = SceneHandler.createLoader("Student/student-medical");
        Parent studentMedicalScene = loader.load();
        StudentMedicalViewController studentMedicalController = loader.getController();
        studentMedicalController.initialize(student_id, connection);
        studentMedicalController.showStudentMedical();
        SceneHandler.switchScene(event, studentMedicalScene);
    }

    public void viewStudentProfileEdit(ActionEvent event) throws IOException, DatabaseConnectionException, SQLException {
        FXMLLoader loader = SceneHandler.createLoader("Student/edit-student");
        Parent studentProfileEditScene = loader.load();
        EditStudentController editStudentController = loader.getController();
        // get student details
        StudentDBController studentDBController = new StudentDBController(connection);
        Student student = studentDBController.getStudentById(student_id);
        if (student != null) {
            this.std_name.setText(student.name);
            this.std_department.setText(student.department);
        }

        editStudentController.initialize(student, connection);
        SceneHandler.switchScene(event, studentProfileEditScene);
    }

    public void initialize(int userId) {

        try {
            student_id = userId;
            connection = new StudentDatabaseConnection().getStudentDBConnection();

            // get student details
            StudentDBController studentDBController = new StudentDBController(connection);
            Student student = studentDBController.getStudentById(student_id);
            if (student != null) {
                this.std_name.setText(student.name);
                this.std_department.setText(student.department);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void setDatabaseConnection(Connection connection) {
        this.connection = connection;
    }
    public void viewStudentNotification(ActionEvent event) {
        try {
            FXMLLoader loader = SceneHandler.createLoader("Student/notice");
            Parent studentNotificationScene = loader.load();
            StudentNoticeViewController studentNoticeViewController = loader.getController();
            studentNoticeViewController.initialize(connection);
            studentNoticeViewController.showStudentNotices();
            SceneHandler.switchScene(event, studentNotificationScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
