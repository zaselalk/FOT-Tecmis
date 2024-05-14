package com.fottecmis.Lecturer;

import com.fottecmis.Shared.Modules.Course.Course;

import java.sql.Connection;

public class LecturerStudentMarksController extends LecturerDashboard {
    //    protected Course course;
//    protected int lecturerId;
//    protected Connection connection;
    public void initialize(int lecturerId, Connection connection, Course course) {
        this.lecturer_id = lecturerId;
        this.connection = connection;
        this.course = course;
    }
}
