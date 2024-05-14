package com.fottecmis.Lecturer;

import com.fottecmis.Shared.Modules.Course.Course;

import java.sql.Connection;

public class LectuereMaterialController extends LecturerDashboard {
//    protected Connection connection;
//    protected  Course course;
//    protected int lecturer_id;

    public void initialize(Connection connection, Course course) {
        this.connection = connection;
        this.course = course;
    }

//    public void backToCourse(ActionEvent event) throws Exception {
//        FXMLLoader loader = SceneHandler.createLoader("Lecturer/lecturer_single_course");
//        Parent lecturerDashboardScene = loader.load();
//        LecturerSingleCourseController lecturerCourseSelectionViewController = loader.getController();
//        lecturerCourseSelectionViewController.initialize(lecturer_id, connection, course);
//        SceneHandler.switchScene(event, lecturerDashboardScene);
//    }

}
