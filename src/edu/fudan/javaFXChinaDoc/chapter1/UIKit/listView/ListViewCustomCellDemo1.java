package edu.fudan.javaFXChinaDoc.chapter1.UIKit.listView;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * editable + cellFactory
 */
public class ListViewCustomCellDemo1 extends Application {
  public static final ObservableList names = FXCollections.observableArrayList();

  public static final ObservableList data = FXCollections.observableArrayList();

  public static void main(String[] args) {
    launch(args);
  }
  @Override
  public void start(Stage primaryStage) throws Exception {
    ListView listView = new ListView(data);  // 另一种用法是 listView.setItems(...)
    listView.setPrefWidth(200);
    listView.setPrefHeight(250);
    listView.setEditable(true);

    names.addAll(
            "Adam", "Alex", "Alfred", "Albert",
            "Brenda", "Connie", "Derek", "Donny",
            "Lynne", "Myrtle", "Rose", "Rudolph",
            "Tony", "Trudy", "Williams", "Zach"
    );

    for (int i = 0; i < 18; i++) {
      data.add("anonym");
    }

    listView.setCellFactory(ComboBoxListCell.forListView(names));

    StackPane stackPane = new StackPane();
    stackPane.getChildren().add(listView);
    Scene scene = new Scene(stackPane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
