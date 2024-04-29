package com.fottecmis.Student.StudentMedical;

import com.fottecmis.Shared.Modules.Medical.Medical;
import com.fottecmis.Student.StudentController;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentMedicalViewController extends StudentController {
    public TableView<Medical> studentMedicalTableView;
    List<Medical> studentMedicals = new ArrayList<>();
    private int student_id;
    private Connection connection;

    public void initialize(int user_id, Connection connection) {
        this.student_id = 1;
        this.connection = connection;

    }

    public void showStudentMedical() {
        try {
            this.studentMedicals = new StudentMedicalController(connection).getAllMedicalsById(student_id);
            studentMedicalTableView.setItems(FXCollections.observableList(studentMedicals));
            createTableView();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTableView() {

        if (this.studentMedicals == null) {
            return;
        }

        TableColumn<Medical, Integer> medicalId = new TableColumn<>("ID");
        medicalId.setCellValueFactory(new PropertyValueFactory<>("medical_id"));

        TableColumn<Medical, String> courseName = new TableColumn<>("Course Name");
        courseName.setCellValueFactory(new PropertyValueFactory<>("course_name"));
        studentMedicalTableView.getColumns().addAll(medicalId, courseName);

        studentMedicalTableView.setItems(FXCollections.observableList(studentMedicals));

    }

}
