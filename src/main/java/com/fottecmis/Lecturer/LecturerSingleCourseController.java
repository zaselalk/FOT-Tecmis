package com.fottecmis.Lecturer;

import com.fottecmis.Lecturer.LecturerMedical.LecturerMedicalViewController;
import com.fottecmis.Shared.Modules.Course.Course;
import com.fottecmis.Shared.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.sql.Connection;

public class LecturerSingleCourseController extends LecturerDashboard {
    Connection connection;
    Course course;
    int lec_id;
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
        LecturerMedicalViewController lecturerMedicalViewController = loader.getController();
        lecturerMedicalViewController.initialize(connection);
        lecturerMedicalViewController.showStudentsMedical();
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


    public void initialize(int lec_id, Connection connection, Course course) {
        this.lec_id = lec_id;
        this.connection = connection;
        this.course = course;

        System.out.println(course.getCourse_name());

    }
}
