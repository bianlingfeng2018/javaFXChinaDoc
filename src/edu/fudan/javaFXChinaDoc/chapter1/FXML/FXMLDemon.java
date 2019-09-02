package edu.fudan.javaFXChinaDoc.chapter1.FXML;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLDemon extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("demo.fxml"));
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("FXMLDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
