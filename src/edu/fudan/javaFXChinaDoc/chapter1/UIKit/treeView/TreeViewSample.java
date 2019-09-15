package edu.fudan.javaFXChinaDoc.chapter1.UIKit.treeView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TreeViewSample extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Tree View Sample");

    // CheckBoxTreeItem 继承自 TreeItem
    // 其他已经提供默认实现的 CellFactory 有：ChoiceBoxTreeCell，ComboBoxTreeCell，TextFieldTreeCell
    CheckBoxTreeItem<String> rootItem =
            new CheckBoxTreeItem<>("View Source Files");
    rootItem.setExpanded(true);

//    rootItem.setIndependent(true);

    final TreeView tree = new TreeView(rootItem);
    tree.setEditable(true);

    tree.setCellFactory(CheckBoxTreeCell.<String>forTreeView());
    for (int i = 0; i < 8; i++) {
      final CheckBoxTreeItem<String> checkBoxTreeItem =
              new CheckBoxTreeItem<>("Sample" + (i + 1));
      rootItem.getChildren().add(checkBoxTreeItem);
//      checkBoxTreeItem.setIndependent(true);
    }

    tree.setRoot(rootItem);
    tree.setShowRoot(true);

    StackPane root = new StackPane();
    root.getChildren().add(tree);
    primaryStage.setScene(new Scene(root, 300, 250));
    primaryStage.show();
  }
}