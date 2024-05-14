package com.fottecmis.Admin.AdminCourses;

import com.fottecmis.Shared.Modules.Course.CourseController;

import java.sql.Connection;

public class AdminCourseController extends CourseController {
    protected AdminCourseController(Connection connection) {
        super(connection);
    }
}
