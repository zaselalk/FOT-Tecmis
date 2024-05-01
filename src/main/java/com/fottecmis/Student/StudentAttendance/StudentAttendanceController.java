package com.fottecmis.Student.StudentAttendance;

import com.fottecmis.Shared.Modules.Attendance.AttendanceController;

import java.sql.Connection;

public class StudentAttendanceController extends AttendanceController {


    protected StudentAttendanceController(Connection connection) {
        super(connection);
    }
}
