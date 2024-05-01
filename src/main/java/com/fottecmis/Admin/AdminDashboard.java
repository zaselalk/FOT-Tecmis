package com.fottecmis.Admin;

import com.fottecmis.Shared.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class AdminDashboard {
    protected int admin_id;
    public void showAdminDashboard(ActionEvent event) throws IOException {
        FXMLLoader loader = SceneHandler.createLoader("Admin/admin");
        Parent adminDashboardScene = loader.load();
        AdminController adminController = loader.getController();
        adminController.initialize(1);
        SceneHandler.switchScene(event, adminDashboardScene);
    }
}
