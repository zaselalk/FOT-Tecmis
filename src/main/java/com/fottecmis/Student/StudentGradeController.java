package com.fottecmis.Student;

import com.fottecmis.Shared.Modules.Student.StudentGrade;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentGradeController extends StudentDashboard {
    private Connection connection;
    private int student_id;
    private final List<StudentGrade> studentGradeList = new ArrayList<>();
    @FXML
    private TableView<StudentGrade> studentGradeTableView;

    @FXML
    private TableColumn<StudentGrade, String> Assignment_1;

    @FXML
    private TableColumn<StudentGrade, String> Assignment_2;

    @FXML
    private TableColumn<StudentGrade, String> course_code;

    @FXML
    private TableColumn<StudentGrade, String> end;

    @FXML
    private TableColumn<StudentGrade, String> mid;

    @FXML
    private TableColumn<StudentGrade, String> quiz_02;

    @FXML
    private TableColumn<StudentGrade, String> quiz_03;

    @FXML
    private TableColumn<StudentGrade, String> quiz_1;

    @FXML
    private TableColumn<StudentGrade, String> r_id;


    public void initialize(Connection connection, int student_id) throws SQLException {
        this.connection = connection;
        this.student_id = student_id;

        // get students grades
        String query = "SELECT * FROM mark WHERE studentId = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, student_id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            StudentGrade studentGrade = new StudentGrade();
            studentGrade.mark_id = resultSet.getInt("mark_id");
            studentGrade.student_id = resultSet.getInt("studentId");
            studentGrade.course_id = resultSet.getString("courseCode");
            studentGrade.assignment_mark1 = resultSet.getString("assesment_01");
            studentGrade.assignment_mark2 = resultSet.getString("assesment_02");
            studentGrade.assignment_mark3 = resultSet.getString("assesment_03");
            studentGrade.quiz_mark1 = resultSet.getString("quiz_1");
            studentGrade.quiz_mark2 = resultSet.getString("quiz_2");
            studentGrade.quiz_mark3 = resultSet.getString("quiz_3");
            studentGrade.exam_mark = resultSet.getString("midExam");
            studentGrade.end_mark = resultSet.getString("finalExam");
            studentGradeList.add(studentGrade);
        }

//       implement table view

    }



}
