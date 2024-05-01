package com.fottecmis.TecnicalOfficer;

import com.fottecmis.Shared.Modules.Medical.Medical;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TechnicalOfficerMedicalViewController extends TechnicalOfficerDashboard {
    public List<Medical> studentMedicals;
    @FXML
    public TableView studentMedicalTableView;

    public void initialize(Connection connection) {
        this.connection = connection;
    }

    public void showStudentMedical() {
        try {
            this.studentMedicals = new TechnicalOfficerMedicalController(connection).getAllMedicals();
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
