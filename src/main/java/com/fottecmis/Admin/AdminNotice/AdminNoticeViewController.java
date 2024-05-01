package com.fottecmis.Admin.AdminNotice;

import com.fottecmis.Admin.AdminDashboard;
import com.fottecmis.Shared.Modules.Notice.Notice;
import com.fottecmis.Shared.Modules.Notice.NoticeController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.util.List;

public class AdminNoticeViewController extends AdminDashboard {
    public AnchorPane notice_editor;
    Connection connection;
    @FXML
    private TableView<Notice> admin_notice_tview;
    @FXML
    private Label feedback;
    @FXML
    private TextField notice_title;
    @FXML
    private TextArea notice_description;
    @FXML
    private Button notice_post;
    @FXML
    private Text notice_editor_text;
    private List<Notice> notices;

    public void initialize(Connection connection) {
        this.connection = connection;
        admin_notice_tview.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // clear feedback label
                feedback.setText("");
                Notice selectedNotice = newSelection;
                notice_title.setText(selectedNotice.getNotice_title());
                notice_description.setText(selectedNotice.getNotice_description());
                notice_editor.setVisible(true);
                notice_post.setText("Update Notice");
            }
        });

    }

    public void showAdminNotices() {
        try {
            notices = new NoticeController(connection).getAllNotices();
            admin_notice_tview.setItems(FXCollections.observableList(notices));
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

        //clear previous columns
        admin_notice_tview.getColumns().clear();

        admin_notice_tview.getColumns().addAll(notice_title, notice_description);


    }

    @FXML
    private void actionButtonHandler() {
        if (notice_post.getText().equals("Update Notice")) {
            updateNotice();
        } else {
            postNotice();
        }
    }

    @FXML
    private void showNewNotice() {
        feedback.setText("");
        feedback.setVisible(false);
        clearNoticeEditor();

        notice_editor.setVisible(true);
        notice_post.setText("Post Notice");
        notice_editor_text.setText("Post Notice");

    }

    @FXML
    private void deleteNotice() {
        Notice selectedNotice = admin_notice_tview.getSelectionModel().getSelectedItem();
        try {
            new NoticeController(connection).deleteNotice(selectedNotice.getNotice_id());
            feedback.setStyle("-fx-text-fill: green");
            feedback.setText("Notice deleted successfully");
            showAdminNotices();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateNotice() {
        notice_editor_text.setText("Update Notice");
        Notice selectedNotice = admin_notice_tview.getSelectionModel().getSelectedItem();
        selectedNotice.setNotice_title(notice_title.getText());
        selectedNotice.setNotice_description(notice_description.getText());
        try {
            new NoticeController(connection).updateNotice(selectedNotice);
            clearNoticeEditor();
            feedback.setStyle("-fx-text-fill: green");
            feedback.setText("Notice Updated Success!");
            showAdminNotices();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void postNotice() {
        Notice notice = new Notice();
        notice.setNotice_title(notice_title.getText());
        notice.setNotice_description(notice_description.getText());
        try {
            new NoticeController(connection).createNotice(notice);
            feedback.setText("Notice posted successfully");
            hideNoticeEditor();
            showAdminNotices();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearNoticeEditor() {
        notice_title.clear();
        notice_description.clear();
        notice_post.setText("Post Notice");
    }

    private void hideNoticeEditor() {
        notice_editor.setVisible(false);
    }

}
