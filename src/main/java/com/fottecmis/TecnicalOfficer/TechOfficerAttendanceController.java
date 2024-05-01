package com.fottecmis.TecnicalOfficer;

import com.fottecmis.Shared.Modules.Attendance.AttendanceController;

import java.sql.Connection;

public class TechOfficerAttendanceController extends AttendanceController {
    protected TechOfficerAttendanceController(Connection connection) {
        super(connection);
    }
}
