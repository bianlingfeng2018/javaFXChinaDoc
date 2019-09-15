package edu.fudan.javaFXChinaDoc.chapter1.UIKit.treeTableView;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.stage.Stage;

public class TreeTableViewDemo extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    // 1.Creating tree items
    TreeItem<String> child1 = new TreeItem<>("String Node 1");
    TreeItem<String> child2 = new TreeItem<>("String Node 2");
    TreeItem<String> child3 = new TreeItem<>("String Node 3");

    // 2.Creating root element
    TreeItem<String> rootNode = new TreeItem<>("Root Node");
    rootNode.setExpanded(true);

    // 3.Adding items to the root
    rootNode.getChildren().setAll(child1, child2, child3);

    // 4.Creating a column
    TreeTableColumn<String, String> myColumn = new TreeTableColumn<>("MyColumn");
    myColumn.setPrefWidth(150);

    // 5.Defining cell content
    myColumn.setCellValueFactory(
            (TreeTableColumn.CellDataFeatures<String, String> p) ->
                    new ReadOnlyStringWrapper(p.getValue().getValue()));

    // 6.Creating a treeTableView
    TreeTableView<String> treeTableView = new TreeTableView<>(rootNode);
    treeTableView.getColumns().add(myColumn);
    treeTableView.setPrefWidth(152);
    treeTableView.setShowRoot(true);

    Scene scene = new Scene(new Group());
    ((Group)scene.getRoot()).getChildren().add(treeTableView);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
