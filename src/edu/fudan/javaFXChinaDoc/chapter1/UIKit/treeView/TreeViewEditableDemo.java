package edu.fudan.javaFXChinaDoc.chapter1.UIKit.treeView;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class TreeViewEditableDemo extends Application {
  private final Node rootIcon =
          new ImageView(new Image(getClass().getResourceAsStream("root.png")));
  private final Image depIcon =
          new Image(getClass().getResourceAsStream("department.png"));
  List<Employee> employees = Arrays.<Employee>asList(
          new Employee("Jacob Smith", "Accounts Department"),
          new Employee("Isabella Johnson", "Accounts Department"),
          new Employee("Ethan Williams", "Sales Department"),
          new Employee("Emma Jones", "Sales Department"),
          new Employee("Michael Brown", "Sales Department"),
          new Employee("Anna Black", "Sales Department"),
          new Employee("Rodger York", "Sales Department"),
          new Employee("Susan Collins", "Sales Department"),
          new Employee("Mike Graham", "IT Support"),
          new Employee("Judy Mayer", "IT Support"),
          new Employee("Gregory Smith", "IT Support"));
  TreeItem<String> rootNode;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    rootNode = new TreeItem<>("Root Node", rootIcon);
    rootNode.setExpanded(true);

    for (int i = 0; i < employees.size(); i++) {
      ObservableList<TreeItem<String>> deps = rootNode.getChildren();
      boolean found = false;
      for (TreeItem<String> dep : deps) {
        if (dep.getValue().equals(employees.get(i).getDepartment())) {
          dep.getChildren().add(new TreeItem<>(employees.get(i).getName()));
          found = true;
        }
      }
      if (!found) {
        TreeItem<String> depItem = new TreeItem<>(employees.get(i).getDepartment(), new ImageView(depIcon));
        rootNode.getChildren().add(depItem);
        depItem.getChildren().add(new TreeItem<>(employees.get(i).getName()));
      }
    }

    TreeView<String> treeView = new TreeView<>(rootNode);
    treeView.setEditable(true);
    treeView.setCellFactory((TreeView<String> p) -> new TextFieldTreeCellImp());

    VBox vBox = new VBox(treeView);
    Scene scene = new Scene(vBox, 300, 400);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  class TextFieldTreeCellImp extends TreeCell<String> {
    private TextField textField;
    private final ContextMenu addMenu = new ContextMenu();

    public TextFieldTreeCellImp() {
//      super();
      MenuItem addMenuItem = new MenuItem("Add Employee");
      addMenu.getItems().add(addMenuItem);
      addMenuItem.setOnAction((ActionEvent t) -> {
        TreeItem newEmployee =
                new TreeItem<>("New Employee");
        getTreeItem().getChildren().add(newEmployee);
      });
    }

    @Override
    public void startEdit() {
      super.startEdit();
      if (textField == null) {
        createTextField();
      }
      setText(null);
      setGraphic(textField);
      textField.selectAll();
    }

    @Override
    public void cancelEdit() {
      super.cancelEdit();
      setText((String) getItem());
      setGraphic(getTreeItem().getGraphic());
    }

    @Override
    protected void updateItem(String item, boolean empty) {
      super.updateItem(item, empty);
      if (empty) {
        setText(null);
        setGraphic(null);
      } else {
        if (isEditing()) {
          if (textField != null) {
            textField.setText(getString());
          }
          setText(null);
          setGraphic(textField);
        } else {
          setText(getString());
          setGraphic(getTreeItem().getGraphic());
          // 不是叶子节点也不是根节点，而是分支节点。
          if (!getTreeItem().isLeaf() && getTreeItem().getParent() != null) {
            setContextMenu(addMenu);
          }
        }
      }
    }

    private void createTextField() {
      textField = new TextField(getString());
      textField.setOnKeyReleased((KeyEvent t) -> {  // 提交修改逻辑
        if (t.getCode() == KeyCode.ENTER) {
          commitEdit(textField.getText());
        } else if (t.getCode() == KeyCode.ESCAPE) {
          cancelEdit();
        }
      });
    }

    private String getString() {
      return getItem() == null ? "" : getItem().toString();
    }
  }
}
