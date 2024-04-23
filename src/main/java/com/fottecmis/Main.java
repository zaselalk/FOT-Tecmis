package com.fottecmis;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("TestMap/map-view.fxml"));
        //        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Authenticate/auth.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Interfaces/TestMap/map-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Map");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}