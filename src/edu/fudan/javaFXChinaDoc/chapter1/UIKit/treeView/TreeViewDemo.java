package edu.fudan.javaFXChinaDoc.chapter1.UIKit.treeView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class TreeViewDemo extends Application {
  private final ImageView rootIcon = new javafx.scene.image.ImageView(new Image(
          getClass().getResourceAsStream("folder_16.png")
  ));
  public static void main(String[] args) {
    launch(args);
  }
  @Override
  public void start(Stage primaryStage) throws Exception {
    TreeView<String> treeView = new TreeView<>();
    TreeItem<String> rootItem = new TreeItem<>("Inbox", rootIcon);

    for (int i = 0; i < 5; i++) {
      TreeItem<String> treeItem = new TreeItem<>("Message" + i);
      rootItem.getChildren().add(treeItem);
    }

    treeView.setRoot(rootItem);

    rootItem.setExpanded(true);

    StackPane stackPane = new StackPane(treeView);
    Scene scene = new Scene(stackPane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
