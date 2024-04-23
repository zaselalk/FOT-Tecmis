package com.fottecmis.Notice;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.ResultSet;

public class NoticeController {
    private Stage stage;
    private Scene scene;

    public void showNotices(ActionEvent event) throws Exception {
        Parent loginscene = FXMLLoader.load(getClass().getResource("/com/fottecmis/Interfaces/Notice/view-notice.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(loginscene);
        stage.setScene(scene);
        stage.show();
    }

    public ResultSet getNotices() {

//        code here
//        create database connection - NoticeDatabaseConnection
//        get notices from database
        return null;
    }


}
