package edu.fudan.javaFXChinaDoc.chapter1.UIKit.listView;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ListViewDemo extends Application {
  public static void main(String[] args) {
    launch(args);
  }
  @Override
  public void start(Stage primaryStage) throws Exception {
    ListView<String> listView = new ListView<>();
    listView.setPrefHeight(70);
    listView.setPrefWidth(100);

    ObservableList<String> items = FXCollections.observableArrayList("Single", "Double", "Suite", "Family App");
    listView.setItems(items);  // 另一种用法是 setCellFactory

    Scene scene = new Scene(listView);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
