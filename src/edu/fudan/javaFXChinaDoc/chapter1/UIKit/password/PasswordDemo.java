package edu.fudan.javaFXChinaDoc.chapter1.UIKit.password;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PasswordDemo extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    PasswordField pw = new PasswordField();
    pw.setPromptText("Please enter your password");
    pw.setText("123456");
    Label label = new Label("Your Password:");
    HBox hBox = new HBox();
    hBox.setSpacing(10);
    hBox.setAlignment(Pos.CENTER_LEFT);  // 对齐方式：上下居中，左右靠左
    hBox.getChildren().addAll(label, pw);

    Label msg = new Label();
    VBox vBox = new VBox();
    vBox.setPadding(new Insets(10, 0, 0, 10));
    vBox.setSpacing(10);
    vBox.getChildren().addAll(hBox, msg);

    pw.setOnAction(event -> {
      if (pw.getText().equals("123456")) {
        msg.setText("Accept!");
        msg.setTextFill(Color.GREEN);
      } else {
        msg.setText("Denied!");
        msg.setTextFill(Color.RED);
      }
      pw.clear();
    });

    Scene scene = new Scene(new Group(), 260, 80);

//    ((Group) scene.getRoot()).getChildren().add(vBox);
    scene.setRoot(vBox);  // 注意与之前的用法不一样，效果略不同

    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
