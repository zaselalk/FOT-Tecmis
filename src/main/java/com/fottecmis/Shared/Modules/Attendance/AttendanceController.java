package com.fottecmis.Shared.Modules.Attendance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttendanceController {
    Connection connection;


    protected AttendanceController(Connection connection) {
        this.connection = connection;
    }

    public List<Attendance> getStudentAttendanceForCourse(int student_id, int course_id) throws SQLException {
        List<Attendance> attendance = new ArrayList<>();
        ResultSet resultSet;

        PreparedStatement getStudentMedical = connection.prepareStatement("SELECT * FROM attendance WHERE student_id = ? AND course_id = ?;");
        getStudentMedical.setInt(1, student_id);
        getStudentMedical.setInt(2, course_id);


        resultSet = getStudentMedical.executeQuery();

        if (!resultSet.next()) {
            System.out.println("No attendance found");
            return null;
        }

        return getAttendance(attendance, resultSet);
    }

    private List<Attendance> getAttendance(List<Attendance> attendance, ResultSet resultSet) {
        try {
            do {
                Attendance attendance1 = new Attendance();
                attendance1.setAttendance_id(resultSet.getInt("attendance_id"));
                attendance1.setStudent_id(resultSet.getInt("student_id"));
                attendance1.setCourse_id(resultSet.getInt("course_id"));
                attendance1.setMedical_id(resultSet.getInt("medical_id"));
                attendance1.setAttendance_date(String.valueOf(resultSet.getDate("date")));
                attendance1.setAttendance_staus(resultSet.getString("state"));


                attendance.add(attendance1);
            } while (resultSet.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendance;
    }
}
