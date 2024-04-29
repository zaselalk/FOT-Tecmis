package com.fottecmis.Admin;

import com.fottecmis.Admin.AdminCourses.AdminCourseViewController;
import com.fottecmis.Shared.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.sql.Connection;

public class AdminController extends AdminDashboard {
    private int admin_id;
    private Connection connection;

    public void initialize(int adminId) {
        this.admin_id = adminId;
        try {
            this.connection = new AdminDatabaseConnection().getAdminConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void coursesView(ActionEvent action) throws IOException {
        FXMLLoader loader = SceneHandler.createLoader("Admin/admin_courses");
        Parent coursesScene = loader.load();
        AdminCourseViewController adminCourseViewController = loader.getController();
        adminCourseViewController.initialize(admin_id, connection);
        adminCourseViewController.showAdminCourses();
        SceneHandler.switchScene(action, coursesScene);
    }

    public void noticeView(ActionEvent action) throws IOException {
        FXMLLoader loader = SceneHandler.createLoader("Admin/admin_notice");
        Parent noticeScene = loader.load();
        SceneHandler.switchScene(action, noticeScene);
    }

    public void usersView(ActionEvent action) throws IOException {
        FXMLLoader loader = SceneHandler.createLoader("Admin/admin_users");
        Parent studentScene = loader.load();
        SceneHandler.switchScene(action, studentScene);
    }

    public void timeTableView(ActionEvent action) throws IOException {
        FXMLLoader loader = SceneHandler.createLoader("Admin/admin_timetable");
        Parent timeTableScene = loader.load();
        SceneHandler.switchScene(action, timeTableScene);
    }

}
