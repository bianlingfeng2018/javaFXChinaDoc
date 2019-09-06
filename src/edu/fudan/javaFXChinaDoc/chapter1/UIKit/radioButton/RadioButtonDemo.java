package edu.fudan.javaFXChinaDoc.chapter1.UIKit.radioButton;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class RadioButtonDemo extends Application {
  final ImageView imageView = new ImageView();

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    final ToggleGroup toggleGroup = new ToggleGroup();
    RadioButton rb1 = new RadioButton("Home");
    rb1.setUserData("Home");
    rb1.setToggleGroup(toggleGroup);

    RadioButton rb2 = new RadioButton("Calendar");
    rb2.setUserData("Calendar");
    rb2.setToggleGroup(toggleGroup);

    RadioButton rb3 = new RadioButton("Contacts");
    rb3.setUserData("Contacts");
    rb3.setToggleGroup(toggleGroup);
//    Image image = new Image("edu/fudan/javaFXChinaDoc/chapter1/UIKit/button/ok.png");
//    rb1.setGraphic(new ImageView(image));

    // 注册监听器
    toggleGroup.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldValue, Toggle newValue) -> {
      if (toggleGroup.getSelectedToggle() != null) {
        final Image image = new Image(getClass().getResourceAsStream(
                toggleGroup.getSelectedToggle().getUserData().toString() + ".jpg"));
        imageView.setImage(image);
      }
    });

    rb2.setSelected(true);
    rb2.requestFocus();  // 设置焦点

    VBox vBox = new VBox();
    vBox.setSpacing(10);
    vBox.getChildren().add(rb1);
    vBox.getChildren().add(rb2);
    vBox.getChildren().add(rb3);

    HBox hBox = new HBox();
    hBox.setSpacing(50);
    hBox.setPadding(new Insets(20, 10, 10, 20));
    hBox.getChildren().add(vBox);
    hBox.getChildren().add(imageView);

//    Scene scene = new Scene(hBox);  // 若装在Scene中，那么hBox大小固定了
    Scene scene = new Scene(new Group());  // 若装在Group中，那么hBox大小随内容增大，比较合理
    ((Group)scene.getRoot()).getChildren().add(hBox);

    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
