package com.fottecmis.Student;

import com.fottecmis.Shared.SceneHandler;
import com.fottecmis.Student.StudentMedical.StudentMedicalController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.sql.Connection;

public class StudentController {
    private int student_id;
    private Connection connection;

    public void viewStudentCourse(ActionEvent event) throws IOException {
        FXMLLoader loader = SceneHandler.createLoader("Student/student-course");
        Parent studentCourseScene = loader.load();
        SceneHandler.switchScene(event, studentCourseScene);

    }

    public void viewStudentAttendance(ActionEvent event) throws IOException {
        FXMLLoader loader = SceneHandler.createLoader("Student/student-attendance");
        Parent studentAttendanceScene = loader.load();
        SceneHandler.switchScene(event, studentAttendanceScene);

    }

    public void viewStudentGrade(ActionEvent event) throws IOException {
        FXMLLoader loader = SceneHandler.createLoader("Student/student-grade");
        Parent studentGradeScene = loader.load();
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

        StudentMedicalController studentMedicalController = loader.getController();

        studentMedicalController.initialize(student_id, connection);
        studentMedicalController.showStudentMedical();
        SceneHandler.switchScene(event, studentMedicalScene);
    }

    public void initialize(int userId) {

        try {
            student_id = userId;
            connection = new StudentDatabaseConnection().getStudentDBConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}