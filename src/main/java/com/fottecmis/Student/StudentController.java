package com.fottecmis.Student;

import com.fottecmis.Shared.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class StudentController {
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
        SceneHandler.switchScene(event, studentMedicalScene);
    }
}
