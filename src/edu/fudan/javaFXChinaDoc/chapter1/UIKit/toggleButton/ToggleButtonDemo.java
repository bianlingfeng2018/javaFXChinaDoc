package edu.fudan.javaFXChinaDoc.chapter1.UIKit.toggleButton;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ToggleButtonDemo extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    final ToggleGroup group = new ToggleGroup();
    ToggleButton tb1 = new ToggleButton("Button1");
    tb1.setUserData(Color.LIGHTGREEN);
    tb1.getStyleClass().add("toggle-button1");
    tb1.setToggleGroup(group);

    ToggleButton tb2 = new ToggleButton("Button2");
    tb2.setUserData(Color.LIGHTBLUE);
    tb2.getStyleClass().add("toggle-button2");
    tb2.setToggleGroup(group);

    ToggleButton tb3 = new ToggleButton("Button3");
    tb3.setUserData(Color.SALMON);
    tb3.getStyleClass().add("toggle-button3");
    tb3.setToggleGroup(group);

//    tb1.setSelected(true);

    Rectangle rectangle = new Rectangle();
    rectangle.setHeight(50);  // width = hBox.getWidth，在后面设置
    rectangle.setArcHeight(10);
    rectangle.setArcWidth(10);
    rectangle.setStroke(Color.DARKGRAY);
    rectangle.setFill(Color.WHITE);
    rectangle.setStrokeWidth(2);

    // add listener to group
    group.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oleToggle, Toggle newToggle) -> {
      if (newToggle == null) {
        rectangle.setFill(Color.WHITE);
      } else {
        rectangle.setFill((Color) group.getSelectedToggle().getUserData());
      }
    });

    HBox hBox = new HBox();
    hBox.getChildren().addAll(tb1, tb2, tb3);

    VBox vBox = new VBox();
    vBox.getChildren().add(hBox);
    vBox.getChildren().add(rectangle);

    Scene scene = new Scene(new Group());
    ((Group) scene.getRoot()).getChildren().add(vBox);
    scene.getStylesheets().add("edu/fudan/javaFXChinaDoc/chapter1/UIKit/toggleButton/control.css");
    primaryStage.setScene(scene);
    primaryStage.show();

    rectangle.setWidth(hBox.getWidth());  // 此句很重要，因为show之后才能获得到hBox的宽度
  }
}
