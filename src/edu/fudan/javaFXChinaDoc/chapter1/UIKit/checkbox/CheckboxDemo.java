package edu.fudan.javaFXChinaDoc.chapter1.UIKit.checkbox;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.security.Security;
import java.util.Arrays;

public class CheckboxDemo extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
//    CheckBox c1 = new CheckBox("first");
//    c1.setIndeterminate(true);
//    c1.setUserData("Chart.png");
//
//    CheckBox c2 = new CheckBox("second");
//    c2.setIndeterminate(false);
//    c2.setSelected(true);
//    c2.setUserData("Project.png");
//
//    CheckBox c3 = new CheckBox("third");
//    c3.setUserData("Security.png");
//    c3.setSelected(false);
//
//    CheckBox c4 = new CheckBox("fourth");
//    c4.setAllowIndeterminate(true);
//
//    ImageView imageView = new ImageView();
//
//    VBox vBox = new VBox();
//    vBox.getChildren().addAll(c1, c2, c3, c4);
//
//    HBox hBox = new HBox();
//    hBox.getChildren().addAll(vBox, imageView);
//    Scene scene = new Scene(new Group());
//    ((Group)scene.getRoot()).getChildren().add(hBox);
//    primaryStage.setScene(scene);
//    primaryStage.show();

    VBox vBox = new VBox();
    HBox hBox = new HBox();
    vBox.setSpacing(5);
    hBox.setPadding(new Insets(0, 0, 0, 5));

    final String[] names = new String[]{"Security", "Project", "Chart"};
    final ImageView[] imageViews = new ImageView[names.length];
    final CheckBox[] checkBoxes = new CheckBox[names.length];
    for (int i = 0; i < names.length; i++) {
      String name = names[i];
      ImageView imageView = new ImageView();
      CheckBox checkBox = new CheckBox(name);
      imageViews[i] = imageView;
      checkBoxes[i] = checkBox;
      checkBox.selectedProperty().addListener((ov, oldValue, newValue) -> {
        if (newValue) {
          // 选中
          imageView.setImage(new Image(getClass().getResourceAsStream(name + ".png")));
        } else {
          imageView.setImage(null);
        }
      });
    }

    vBox.getChildren().addAll(checkBoxes);
    hBox.getChildren().addAll(imageViews);

    // rectangle
    Rectangle rectangle = new Rectangle(90, 30);
    rectangle.setArcWidth(10);
    rectangle.setArcHeight(10);
    rectangle.setFill(Color.rgb(41, 41, 41));

    // stackPane 用法
    StackPane stackPane = new StackPane();
    stackPane.getChildren().add(rectangle);  // 后加载的在上层
    stackPane.getChildren().add(hBox);
    StackPane.setAlignment(rectangle, Pos.TOP_CENTER);  // 静态方法，设置rectangle在stackPane中的位置
    HBox hBox2 = new HBox();
    hBox2.getChildren().addAll(vBox, stackPane);

    Scene scene = new Scene(new Group());
    ((Group) scene.getRoot()).getChildren().add(hBox2);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
