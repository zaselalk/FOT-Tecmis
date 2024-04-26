package com.fottecmis.Lecturer;

import com.fottecmis.Shared.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class LecturerSingleCourseController extends LecturerDashboard {
    public void showLecturerMaterialPage(ActionEvent event) throws Exception {
        FXMLLoader loader = SceneHandler.createLoader("Lecturer/lecture_material");
        Parent lecturerMaterialScene = loader.load();
        SceneHandler.switchScene(event, lecturerMaterialScene);
    }

    public void showEnrolledStudents(ActionEvent event) throws Exception {
        FXMLLoader loader = SceneHandler.createLoader("Lecturer/course_enrolled_students");
        Parent enrolledStudentsScene = loader.load();
        SceneHandler.switchScene(event, enrolledStudentsScene);
    }

    public void showStudentMedicalReport(ActionEvent event) throws Exception {
        FXMLLoader loader = SceneHandler.createLoader("Lecturer/student_medical_report");
        Parent studentMedicalReportScene = loader.load();
        SceneHandler.switchScene(event, studentMedicalReportScene);
    }

    public void showStudentAttendance(ActionEvent event) throws Exception {
        FXMLLoader loader = SceneHandler.createLoader("Lecturer/student_attendance");
        Parent studentAttendanceScene = loader.load();
        SceneHandler.switchScene(event, studentAttendanceScene);
    }

    public void showStudentMarks(ActionEvent event) throws Exception {
        FXMLLoader loader = SceneHandler.createLoader("Lecturer/student_marks");
        Parent studentMarksScene = loader.load();
        SceneHandler.switchScene(event, studentMarksScene);
    }
}
