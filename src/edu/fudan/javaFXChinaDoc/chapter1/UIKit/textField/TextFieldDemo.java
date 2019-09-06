package edu.fudan.javaFXChinaDoc.chapter1.UIKit.textField;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextFieldDemo extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
//    TextField textField = new TextField("Alice");
    TextField tf1 = new TextField();
    TextField tf2 = new TextField();
    tf1.setPromptText("姓");
    tf1.setPrefColumnCount(5);
    tf2.setPromptText("名");

    Label label = new Label("Your Name:");

    HBox hBox = new HBox();
    hBox.setSpacing(10);
    hBox.setPadding(new Insets(10, 0, 0, 10));
    hBox.setAlignment(Pos.CENTER);
    hBox.getChildren().addAll(label, tf1, tf2);

    Scene scene = new Scene(new Group(), 400, 200);
    ((Group)scene.getRoot()).getChildren().add(hBox);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
