package edu.fudan.javaFXChinaDoc.chapter1.UIKit.tableView;

import edu.fudan.javaFXChinaDoc.chapter1.UIKit.tableView.model.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewDemo extends Application {
  private final TableView tableView = new TableView();
  final ObservableList<Person> persons = FXCollections.observableArrayList(
          new Person("Jacob", "Smith", "jacob.smith@example.com"),
          new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
          new Person("Ethan", "Williams", "ethan.williams@example.com"),
          new Person("Emma", "Jones", "emma.jones@example.com"),
          new Person("Michael", "Brown", "michael.brown@example.com")
  );
  private final HBox hBox = new HBox();

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    TableColumn c1 = new TableColumn("First Name");
    c1.setMinWidth(100);

    TableColumn c2 = new TableColumn("Last Name");
    c2.setMinWidth(100);

    TableColumn c3 = new TableColumn("Email");
    c3.setMinWidth(200);

    c1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    c2.setCellValueFactory(new PropertyValueFactory<>("secondName"));
    c3.setCellValueFactory(new PropertyValueFactory<>("email"));

    tableView.setItems(persons);

//    tableView.setEditable(true);

//    TableColumn subC1 = new TableColumn("Primary");
//    TableColumn subC2 = new TableColumn("Secondary");
//    c3.getColumns().addAll(subC1, subC2);

    tableView.getColumns().addAll(c1, c2, c3);

//    c3.setVisible(false);
//    tableView.setPlaceholder(new Label("请输入数据"));

    Label label = new Label("Address Book");

    VBox vBox = new VBox();
    vBox.setSpacing(5);
    vBox.setPadding(new Insets(10, 0, 0, 10));
    vBox.getChildren().addAll(label, tableView);
    addTextFields(vBox, c1, c2, c3);

//    Scene scene = new Scene(vBox);
    Scene scene = new Scene(new Group());
    ((Group) scene.getRoot()).getChildren().addAll(vBox);
    primaryStage.setScene(scene);
    primaryStage.setWidth(450);
    primaryStage.setHeight(500);
    primaryStage.show();
  }

  private void addTextFields(VBox vBox, TableColumn c1, TableColumn c2, TableColumn c3) {
    TextField tf1 = new TextField();
    tf1.setMaxWidth(c1.getPrefWidth());
    tf1.setPromptText("First Name");

    TextField tf2 = new TextField();
    tf2.setMaxWidth(c2.getPrefWidth());
    tf2.setPromptText("Second Name");

    TextField tf3 = new TextField();
    tf3.setMaxWidth(c3.getPrefWidth());
    tf3.setPromptText("Email");

    Button button = new Button();
    button.setText("Add");
    button.setOnAction(event -> {
      persons.add(
              new Person(
                      tf1.getText(), tf2.getText(), tf3.getText())
      );
      tf1.clear();
      tf2.clear();
      tf3.clear();
    });
    hBox.getChildren().addAll(tf1, tf2, tf3, button);
    hBox.setSpacing(3);
    vBox.getChildren().add(hBox);
  }
}
