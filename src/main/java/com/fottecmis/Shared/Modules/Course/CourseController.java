package com.fottecmis.Shared.Modules.Course;

import com.fottecmis.Student.StudentDashboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseController extends StudentDashboard {
    Connection connection;

    protected CourseController(Connection connection) {
        this.connection = connection;
    }

    public List<Course> getAllCourses() throws SQLException {
        List<Course> courses = new ArrayList<>();
        ResultSet resultSet;
        PreparedStatement getStudentMedical = connection.prepareStatement("SELECT * FROM courses;");
        resultSet = getStudentMedical.executeQuery();

        if (!resultSet.next()) {
            return null;
        }

        return getCourses(courses, resultSet);

    }

    public List<Course> getAllCoursesByDepartmentId(int department_id) throws SQLException {
        List<Course> courses = new ArrayList<>();
        ResultSet resultSet;

        PreparedStatement getStudentMedical = connection.prepareStatement("SELECT * FROM courses WHERE department_id = ?;");
        getStudentMedical.setInt(1, department_id);

        resultSet = getStudentMedical.executeQuery();

        if (!resultSet.next()) {
            System.out.println("No medical found");
            return null;
        }

        return getCourses(courses, resultSet);
    }

    public List<Course> getCoursesByStudentId(int student_id) throws SQLException {
        List<Course> courses = new ArrayList<>();
        ResultSet resultSet;

        PreparedStatement getStudentMedical = connection.prepareStatement("SELECT * FROM courses c INNER JOIN student_course sc WHERE c.c_id = sc.course_id AND sc.student_id = ?;");
        getStudentMedical.setInt(1, student_id);

        resultSet = getStudentMedical.executeQuery();

        if (!resultSet.next()) {
            System.out.println("No medical found");
            return null;
        }

        return getCourses(courses, resultSet);
    }

    private List<Course> getCourses(List<Course> courses, ResultSet resultSet) {
        try {
            do {
                Course course = new Course();
                course.setCourse_id(resultSet.getInt("c_id"));
                course.setCourse_name(resultSet.getString("course_name"));
                course.setDepartmentId(resultSet.getInt("department_id"));
                course.setIs_gpa(resultSet.getInt("is_gpa"));
                course.setLevel(resultSet.getInt("level"));
                course.setSemester(resultSet.getInt("semster"));
                course.setCourse_hour(resultSet.getInt("course_hour"));
                courses.add(course);
            } while (resultSet.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
}
