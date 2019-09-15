package edu.fudan.javaFXChinaDoc.chapter1.UIKit.treeTableView;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class TreeTableViewMultiColumnDemo extends Application {
  List<Employee> employees = Arrays.<Employee>asList(
          new Employee("Ethan Williams", "ethan.williams@example.com"),
          new Employee("Emma Jones", "emma.jones@example.com"),
          new Employee("Michael Brown", "michael.brown@example.com"),
          new Employee("Anna Black", "anna.black@example.com"),
          new Employee("Rodger York", "roger.york@example.com"),
          new Employee("Susan Collins", "susan.collins@example.com"));

  private final ImageView depIcon = new ImageView(
          new Image(getClass().getResourceAsStream("department.png"))
  );

  final TreeItem<Employee> root = new TreeItem<>(
          new Employee("Sales Department", ""), depIcon);

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    // 1.
    root.setExpanded(true);

    // 2.
    employees.stream().forEach(employee -> {
      root.getChildren().add(new TreeItem<>(employee));
    });

    // 3.
    TreeTableColumn<Employee, String> c1 = new TreeTableColumn<>("Employee Name");
    c1.setPrefWidth(150);
    c1.setCellValueFactory(
            (TreeTableColumn.CellDataFeatures<Employee, String> param) ->
                    new ReadOnlyStringWrapper(param.getValue().getValue().getName()));

    TreeTableColumn<Employee, String> c2 = new TreeTableColumn<>("Employee Email");
    c2.setPrefWidth(190);
    c2.setCellValueFactory(
            (TreeTableColumn.CellDataFeatures<Employee, String> param) ->
                    new ReadOnlyStringWrapper(param.getValue().getValue().getEmail())
    );

    // 4.
    TreeTableView<Employee> treeTableView = new TreeTableView<>();
    treeTableView.setRoot(root);
    treeTableView.setShowRoot(true);
    treeTableView.getColumns().addAll(c1, c2);

    Scene scene = new Scene(new Group());
    ((Group)scene.getRoot()).getChildren().add(treeTableView);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
