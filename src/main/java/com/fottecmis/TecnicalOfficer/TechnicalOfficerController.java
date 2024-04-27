package com.fottecmis.TecnicalOfficer;

import com.fottecmis.Shared.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class TechnicalOfficerController extends TechnicalOfficerDashboard {

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
        SceneHandler.switchScene(event, techOfficerMedicalScene);
    }

}
