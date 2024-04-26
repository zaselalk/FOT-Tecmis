package com.fottecmis.Student;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EditStudentController {
    private Stage stage;
    private Scene scene;

    public void showEditStudentScreen(ActionEvent event) throws Exception {
        Parent loginscene = FXMLLoader.load(getClass().getResource("/com/fottecmis/Interfaces/Student/edit-student.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(loginscene);
        stage.setScene(scene);
        stage.show();

    }
}
