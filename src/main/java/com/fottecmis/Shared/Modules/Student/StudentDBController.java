package com.fottecmis.Shared.Modules.Student;

import com.fottecmis.Shared.DatabaseConnectionException;
import com.fottecmis.Student.StudentDatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDBController {
    private Connection connection;

    public StudentDBController(Connection connection) {
        this.connection = connection;
    }

    public Student getStudentById(int student_id) throws SQLException, DatabaseConnectionException {
        String query = "SELECT * FROM users u INNER JOIN departments d ON u.department_id = d.d_id WHERE u.user_id = ?;";
        connection = new StudentDatabaseConnection().getStudentDBConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, student_id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Student student = new Student();
            student.name = resultSet.getString("first_name") + " " + resultSet.getString("last_name");
            student.department = resultSet.getString("department_name");
            student.email_address = resultSet.getString("email_address");
            student.address = resultSet.getString("address");
            return student;
        }
        return null;
    }

    public Student findStudentByName(String first_name) {
        String query = "SELECT * FROM users u INNER JOIN departments d ON u.department_id = d.d_id WHERE u.first_name = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, first_name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Student student = new Student();
                student.name = resultSet.getString("first_name") + " " + resultSet.getString("last_name");
                student.department = resultSet.getString("department_name");
                student.email_address = resultSet.getString("email_address");
                student.address = resultSet.getString("address");
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Student findStudentByName(String first_name, String last_name) {
        String query = "SELECT * FROM users u INNER JOIN departments d ON u.department_id = d.d_id WHERE u.first_name = ? AND last_name = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, last_name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Student student = new Student();
                student.name = resultSet.getString("first_name") + " " + resultSet.getString("last_name");
                student.department = resultSet.getString("department_name");
                student.email_address = resultSet.getString("email_address");
                student.address = resultSet.getString("address");
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }




}
