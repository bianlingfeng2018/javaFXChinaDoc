package edu.fudan.javaFXChinaDoc.chapter1.UIKit.choiceBox;

import com.sun.org.apache.bcel.internal.generic.LADD;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChoiceBoxDemo extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    String[] strings = new String[]{"中文", "日文", "韩文"};
    ChoiceBox choiceBox = new ChoiceBox(FXCollections.observableArrayList("First", new Separator(), "Second", "Third"));
    Label label = new Label();
    choiceBox.getSelectionModel().selectedIndexProperty().addListener((ov, oldValue, newValue) -> {
      System.out.println("oldValue = " + oldValue + ", newValue = " + newValue);
      if (newValue.intValue() >= 0) {
        if (newValue.intValue() >= 2) {
          label.setText(strings[newValue.intValue() - 1]);
        } else {
          label.setText(strings[newValue.intValue()]);
        }
      }
    });

    // 提示信息
    choiceBox.setTooltip(new Tooltip("请选择语言"));

    HBox hBox = new HBox();
    hBox.setAlignment(Pos.CENTER);
    hBox.setSpacing(20);
    hBox.setPadding(new Insets(10, 0, 0, 10));
    hBox.getChildren().addAll(choiceBox, label);

    Scene scene = new Scene(new Group(), 300, 200);
    scene.setFill(Color.ALICEBLUE);
    ((Group) scene.getRoot()).getChildren().add(hBox);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
