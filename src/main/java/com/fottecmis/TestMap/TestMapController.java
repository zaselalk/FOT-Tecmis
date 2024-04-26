package com.fottecmis.TestMap;

import com.fottecmis.Authenticate.AuthController;
import com.fottecmis.Student.EditStudentController;
import com.fottecmis.Student.StudentDashboard;
import javafx.event.ActionEvent;

public class TestMapController {
    public void showLoginScene(ActionEvent event) {
        AuthController auth = new AuthController();
        try {
            auth.showLoginScreen(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showEditProfileScene(ActionEvent event) {
        EditStudentController edt = new EditStudentController();
        try {
            edt.showEditStudentScreen(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showStudentDashboardScene(ActionEvent event) {
        StudentDashboard std = new StudentDashboard();
        try {
            std.showStudentDashboard(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
