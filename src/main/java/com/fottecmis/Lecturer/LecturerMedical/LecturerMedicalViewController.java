package com.fottecmis.Lecturer.LecturerMedical;

import com.fottecmis.Lecturer.LecturerDashboard;
import com.fottecmis.Shared.Modules.Medical.Medical;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LecturerMedicalViewController extends LecturerDashboard {
    public TableView<Medical> medicalTableView;
    List<Medical> studentMedicals = new ArrayList<>();
    private Connection connection;

    public void initialize(Connection connection, int user_id) {
        this.connection = connection;
        lecturer_id = user_id;

    }

    public void showStudentsMedical() {
        try {
            this.studentMedicals = new LecturereMedicalController(connection).getAllMedicals();
//            medicalTableView.setItems(FXCollections.observableList(studentMedicals));
            createTableView();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTableView() {

        if (this.studentMedicals == null) {
            return;
        }

        TableColumn<Medical, Integer> medicalId = new TableColumn<>("ID");
        medicalId.setCellValueFactory(new PropertyValueFactory<>("medical_id"));

        TableColumn<Medical, String> courseName = new TableColumn<>("Course Name");
        courseName.setCellValueFactory(new PropertyValueFactory<>("course_name"));
        medicalTableView.getColumns().addAll(medicalId, courseName);

        medicalTableView.setItems(FXCollections.observableList(studentMedicals));

    }

}
