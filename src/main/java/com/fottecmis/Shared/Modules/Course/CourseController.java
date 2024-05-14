package com.fottecmis.Shared.Modules.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseController {
    Connection connection;

    public CourseController(Connection connection) {
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
            System.out.println("No Courses found");
            return null;
        }

        return getCourses(courses, resultSet);
    }

    public List<Course> getCoursesByLecturerId(int lecturer_id) throws SQLException {
        List<Course> courses = new ArrayList<>();
        ResultSet resultSet;

        PreparedStatement getStudentMedical = connection.prepareStatement("SELECT * FROM courses c INNER JOIN lecturer_course lc WHERE c.c_id = lc.course_id AND lc.lecturer_id = ?;");
        getStudentMedical.setInt(1, lecturer_id);

        resultSet = getStudentMedical.executeQuery();

        if (!resultSet.next()) {
            System.out.println("No Courses found");
            return null;
        }

        return getCourses(courses, resultSet);
    }

    private List<Course> getCourses(List<Course> courses, ResultSet resultSet) {
        try {
            do {
                Course course = new Course();
                course.setCourse_id(resultSet.getInt("c_id"));
                course.setCourse_code(resultSet.getString("course_code"));
                course.setCourse_name(resultSet.getString("course_name"));
                course.setDepartmentId(resultSet.getInt("department_id"));
                course.setIs_gpa(resultSet.getInt("is_gpa"));
                course.setLevel(resultSet.getInt("level"));
                course.setSemester(resultSet.getInt("semster"));
                course.setCourse_hour(resultSet.getInt("course_hour"));
                course.setCredit(resultSet.getInt("credit"));
                courses.add(course);
            } while (resultSet.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    public Course getCourseByName(String course_name) {
        try {
            PreparedStatement pres = connection.prepareStatement("SELECT * FROM courses WHERE course_name = ?");
            pres.setString(1, course_name);
            return getCourse(pres);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Course updateCourse(int courseId, Course course) {
        try {
            PreparedStatement pres = connection.prepareStatement("UPDATE courses SET course_name = ?,level=?,course_hour=?,credit = ? WHERE c_id = ?");

            pres.setString(1, course.getCourse_name());
            pres.setInt(2, course.getLevel());
            pres.setInt(3, course.getCourse_hour());
            pres.setInt(4, course.getCredit());
            pres.setInt(5, courseId);
            pres.executeUpdate();

            return getCourseById(courseId);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Course getCourseById(int courseId) {
        try {
            PreparedStatement pres = connection.prepareStatement("SELECT * FROM courses WHERE c_id = ?");
            pres.setInt(1, courseId);
            return getCourse(pres);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Course getCourse(PreparedStatement pres) throws SQLException {
        pres.executeQuery();
        if (pres.getResultSet().next()) {
            Course course = new Course();
            course.setCourse_id(pres.getResultSet().getInt("c_id"));
            course.setCourse_name(pres.getResultSet().getString("course_name"));
            course.setCourse_code(pres.getResultSet().getString("course_code"));
            course.setDepartmentId(pres.getResultSet().getInt("department_id"));
            course.setIs_gpa(pres.getResultSet().getInt("is_gpa"));
            course.setLevel(pres.getResultSet().getInt("level"));
            course.setSemester(pres.getResultSet().getInt("semster"));
            course.setCourse_hour(pres.getResultSet().getInt("course_hour"));
            course.setCredit(pres.getResultSet().getInt("credit"));
            return course;
        } else {
            return null;
        }
    }

    public void createCourse(Course course) throws SQLException {

        PreparedStatement pres = connection.prepareStatement("INSERT INTO courses (course_name, course_code, department_id, is_gpa, level, semster, course_hour, credit) VALUES (?,?,?,?,?,?,?,?)");
        pres.setString(1, course.getCourse_name());
        pres.setString(2, course.getCourse_code());
        pres.setInt(3, course.getDepartmentId());
        pres.setInt(4, course.getIs_gpa());
        pres.setInt(5, course.getLevel());
        pres.setInt(6, course.getSemester());
        pres.setInt(7, course.getCourse_hour());
        pres.setInt(8, course.getCredit());
        pres.executeUpdate();

    }

    public void deleteCourse(int courseId) throws SQLException {
        PreparedStatement pres = connection.prepareStatement("DELETE FROM courses WHERE c_id = ?");
        pres.setInt(1, courseId);
        pres.executeUpdate();

    }
}
