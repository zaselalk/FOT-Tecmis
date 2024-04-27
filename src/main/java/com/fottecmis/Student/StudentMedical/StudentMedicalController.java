package com.fottecmis.Student.StudentMedical;

import com.fottecmis.Student.StudentDashboard;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentMedicalController extends StudentDashboard {
    public TableView<StudentMedical> studentMedicalTableView;
    private int student_id;
    private Connection connection;
    List<StudentMedical> studentMedicals = new ArrayList<>();


    public void initialize(int user_id, Connection connection) {
        this.student_id = user_id;
        this.connection = connection;


    }


    public void showStudentMedical() {
        if (connection == null) {
            System.out.println(student_id);
            System.out.println("Connection is null");
            return;
        }
        try {
            PreparedStatement getStudentMedical = connection.prepareStatement("SELECT * FROM medical m INNER JOIN courses c where m.course_id = c.c_id;");
//            getStudentMedical.setInt(1, student_id);

            if (!getStudentMedical.executeQuery().next()) {
                return;
            }


            while (getStudentMedical.getResultSet().next()) {
                StudentMedical studentMedical = new StudentMedical();
                studentMedical.setStudent_id(getStudentMedical.getResultSet().getInt("student_id"));
                studentMedical.setMedical_id(getStudentMedical.getResultSet().getInt("medical_id"));
                studentMedical.setCourse_id(getStudentMedical.getResultSet().getInt("course_id"));
                studentMedical.setCourse_name(getStudentMedical.getResultSet().getString("course_name"));
                System.out.println(studentMedical.getMedical_id());
                studentMedicals.add(studentMedical);
            }
//           studentMedicalTableView.setItems(FXCollections.observableList(studentMedicals));
            createTableView();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTableView() {

        TableColumn<StudentMedical, Integer> medicalId = new TableColumn<>("ID");
        medicalId.setCellValueFactory(new PropertyValueFactory<>("medical_id"));


//        course name column
        TableColumn<StudentMedical, String> courseName = new TableColumn<>("Course Name");
        courseName.setCellValueFactory(new PropertyValueFactory<>("course_name"));
        studentMedicalTableView.getColumns().addAll(medicalId, courseName);

        studentMedicalTableView.setItems(FXCollections.observableList(studentMedicals));


    }

}
