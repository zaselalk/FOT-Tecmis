package com.fottecmis.TestMap;

import com.fottecmis.Authenticate.AuthController;
import com.fottecmis.Lecturer.LecturerDashboard;
import com.fottecmis.Student.EditStudentController;
import com.fottecmis.TecnicalOfficer.TechnicalOfficerDashboard;
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
        AuthController auth = new AuthController();
        try {
            auth.showStudentDashboard(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showLecturerDashboardScene(ActionEvent event) {
        LecturerDashboard lct = new LecturerDashboard();
        try {
            lct.showLecturerDashboard(event);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //    technical officer
    public void showTechnicalOfficerDashboardScene(ActionEvent event) {
        try {
            TechnicalOfficerDashboard techOfficerDashboard = new TechnicalOfficerDashboard();
            techOfficerDashboard.showTechnicalOfficerDashboard(event);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
