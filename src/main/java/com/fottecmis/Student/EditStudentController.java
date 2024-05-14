package com.fottecmis.Student;

import com.fottecmis.Shared.Modules.Student.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.Connection;

public class EditStudentController extends StudentDashboard {
    private Stage stage;
    private Scene scene;
    private Student student;
    private Connection connection;
    @FXML
    private Label userfullname;
    @FXML
    private Label userdepartment;
    @FXML
    private Label useraddress;
    @FXML
    private Label usermemail;


    public void showEditStudentScreen(ActionEvent event) throws Exception {
        Parent loginscene = FXMLLoader.load(getClass().getResource("/com/fottecmis/Interfaces/Student/edit-student.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(loginscene);
        stage.setScene(scene);
        stage.show();

    }

    public void initialize(Student student, Connection connection) {
        this.student = student;
        this.connection = connection;

        userfullname.setText(student.name);
        userdepartment.setText(student.department);
        useraddress.setText(student.address);
        usermemail.setText(student.email_address);


    }
}
