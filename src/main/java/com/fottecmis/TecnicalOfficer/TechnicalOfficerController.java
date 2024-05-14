package com.fottecmis.TecnicalOfficer;

import com.fottecmis.Shared.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.sql.Connection;

public class TechnicalOfficerController {
    Connection connection;

    public void viewAttendance(ActionEvent event) throws IOException {
        FXMLLoader loader = SceneHandler.createLoader("TechnicalOfficer/tech_officer_attendance");
        Parent techOfficerAttendanceScene = loader.load();
        SceneHandler.switchScene(event, techOfficerAttendanceScene);
    }

    public void viewTimeTable(ActionEvent event) throws IOException {
        FXMLLoader loader = SceneHandler.createLoader("TechnicalOfficer/tech_officer_timetable");
        Parent techOfficerTimeTableScene = loader.load();
        SceneHandler.switchScene(event, techOfficerTimeTableScene);
    }

    public void viewMedical(ActionEvent event) throws IOException {
        FXMLLoader loader = SceneHandler.createLoader("TechnicalOfficer/tech_officer_medical");
        Parent techOfficerMedicalScene = loader.load();
        TechnicalOfficerMedicalViewController technicalOfficerMedicalViewController = loader.getController();
        technicalOfficerMedicalViewController.initialize(connection);
        technicalOfficerMedicalViewController.showStudentMedical();
        SceneHandler.switchScene(event, techOfficerMedicalScene);
    }

    public void initialize() {
        try {
            this.connection = new TechnicalOfficerDatabaseConnection().getOfficerConnection();
        } catch (Exception e) {
            System.out.println("Unable to connect");
        }
    }

}
