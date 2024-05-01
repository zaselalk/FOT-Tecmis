package com.fottecmis.Lecturer;

import com.fottecmis.Shared.Modules.Course.Course;

import java.sql.Connection;

public class LecturerCourseEnrolls extends LecturerDashboard {

    public void initialize(Connection connection, Course course) {
        this.connection = connection;
        this.course = course;
    }


}
