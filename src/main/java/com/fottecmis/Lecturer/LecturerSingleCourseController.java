package com.fottecmis.Lecturer;

import com.fottecmis.Lecturer.LecturerMedical.LecturerMedicalViewController;
import com.fottecmis.Shared.Modules.Course.Course;
import com.fottecmis.Shared.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.sql.Connection;
import java.sql.SQLException;

public class LecturerSingleCourseController {
    Connection connection;
    Course course;
    int lecturer_id;

    public void showLecturerMaterialPage(ActionEvent event) throws Exception {
        FXMLLoader loader = SceneHandler.createLoader("Lecturer/lecture_material");
        Parent lecturerMaterialScene = loader.load();
        LectuereMaterialController lectuereMaterialController = loader.getController();
        lectuereMaterialController.initialize(connection, course);
        SceneHandler.switchScene(event, lecturerMaterialScene);
    }

    public void showEnrolledStudents(ActionEvent event) throws Exception {
        FXMLLoader loader = SceneHandler.createLoader("Lecturer/course_enrolled_students");
        Parent enrolledStudentsScene = loader.load();
        LecturerCourseEnrolls lecturerEnrolledStudentsController = loader.getController();
        lecturerEnrolledStudentsController.initialize(connection, course);
        SceneHandler.switchScene(event, enrolledStudentsScene);
    }

    public void showStudentMedicalReport(ActionEvent event) throws Exception {
        FXMLLoader loader = SceneHandler.createLoader("Lecturer/student_medical_report");
        Parent studentMedicalReportScene = loader.load();
        LecturerMedicalViewController lecturerMedicalViewController = loader.getController();
        lecturerMedicalViewController.initialize(connection, lecturer_id);
        lecturerMedicalViewController.showStudentsMedical();
        SceneHandler.switchScene(event, studentMedicalReportScene);
    }

    public void showStudentAttendance(ActionEvent event) throws Exception {
        FXMLLoader loader = SceneHandler.createLoader("Lecturer/student_attendance");
        Parent studentAttendanceScene = loader.load();
        LecturerCourseAttendanceController lecturerStudentAttendanceController = loader.getController();
        lecturerStudentAttendanceController.initialize(course, lecturer_id, connection);
        SceneHandler.switchScene(event, studentAttendanceScene);
    }

    public void showStudentMarks(ActionEvent event) throws Exception {
        FXMLLoader loader = SceneHandler.createLoader("Lecturer/student_marks");
        Parent studentMarksScene = loader.load();
        LecturerStudentMarksController lecturerCourseMarksController = loader.getController();
        lecturerCourseMarksController.initialize(lecturer_id, connection, course);
        SceneHandler.switchScene(event, studentMarksScene);
    }

    public void BackToCourseDashboard(ActionEvent event) throws Exception {
        FXMLLoader loader = SceneHandler.createLoader("Lecturer/lecturer_single_course");
        Parent lecturerSingleCourseScene = loader.load();

        LecturerSingleCourseController lecturerSingleCourseController = loader.getController();
        lecturerSingleCourseController.initialize(lecturer_id, connection, course);
        SceneHandler.switchScene(event, lecturerSingleCourseScene);
    }


    public void initialize(int lec_id, Connection connection, Course course) {
        this.connection = connection;
        this.course = course;
        this.lecturer_id = lec_id;
    }
}
