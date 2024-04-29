package com.fottecmis.Shared;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneHandler {
    public static void switchScene(ActionEvent event, Parent sceneName) {
        Scene scene = new Scene(sceneName);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public static FXMLLoader createLoader(String path) {
        return new FXMLLoader(SceneHandler.class.getResource("/com/fottecmis/Interfaces/" + path + ".fxml"));
    }
}
