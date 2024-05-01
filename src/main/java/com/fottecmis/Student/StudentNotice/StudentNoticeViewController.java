package com.fottecmis.Student.StudentNotice;

import com.fottecmis.Shared.Modules.Notice.Notice;
import com.fottecmis.Student.StudentDashboard;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.util.List;

public class StudentNoticeViewController extends StudentDashboard {
    @FXML
    private TableView notice_table;
    private Connection connection;
    private List<Notice> notices;


    public void initialize(Connection connection) {
        this.connection = connection;
    }

    public void showStudentNotices() {
        try {
            notices = new StudentNoticeController(connection).getAllNotices();
            notice_table.setItems(FXCollections.observableList(notices));
            createNoticeTable(notices);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createNoticeTable(List<Notice> notices) {
        if (notices != null) {
            System.out.println("No Notices");
        }

        TableColumn<Notice, String> notice_title = new TableColumn<>("Title");
        notice_title.setCellValueFactory(new PropertyValueFactory<>("notice_title"));

        TableColumn<Notice, String> notice_description = new TableColumn<>("Description");
        notice_description.setCellValueFactory(new PropertyValueFactory<>("notice_description"));

        notice_table.getColumns().addAll(notice_title, notice_description);


    }


}
