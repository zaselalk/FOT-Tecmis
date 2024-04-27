package com.fottecmis.TecnicalOfficer;

import com.fottecmis.Shared.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class TechnicalOfficerDashboard {
    public void showTechnicalOfficerDashboard(ActionEvent event) throws IOException {
        FXMLLoader loader = SceneHandler.createLoader("TechnicalOfficer/technical_officer");
        Parent studentDashboardScene = loader.load();
        SceneHandler.switchScene(event, studentDashboardScene);
    }
}
