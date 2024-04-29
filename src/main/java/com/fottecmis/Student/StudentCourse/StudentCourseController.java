package com.fottecmis.Student.StudentCourse;

import com.fottecmis.Shared.Modules.Course.CourseController;

import java.sql.Connection;

public class StudentCourseController extends CourseController {
    protected StudentCourseController(Connection connection) {
        super(connection);
    }


}
