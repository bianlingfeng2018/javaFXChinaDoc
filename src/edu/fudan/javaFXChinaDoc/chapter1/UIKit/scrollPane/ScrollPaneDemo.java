package edu.fudan.javaFXChinaDoc.chapter1.UIKit.scrollPane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScrollPaneDemo extends Application {
  public static void main(String[] args) {
    launch(args);
  }
  @Override
  public void start(Stage primaryStage) throws Exception {
    ScrollPane scrollPane = new ScrollPane();
//    scrollPane.setContent(new ImageView(new Image(getClass().getResourceAsStream("roses.jpg"))));
    HBox hBox = new HBox();
    hBox.setAlignment(Pos.CENTER_LEFT);
    hBox.setSpacing(10);
    hBox.setPadding(new Insets(20, 0, 0, 20));
    hBox.getChildren().add(new Label("some label"));
    hBox.getChildren().add(new TextField());
    scrollPane.setContent(hBox);
    scrollPane.setPannable(true);  // 可以通过点击图片并拖拽的方法查看超出边界的部分

//    scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
//    scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

    scrollPane.setFitToHeight(true);
    scrollPane.setFitToWidth(true);

    Scene scene = new Scene(scrollPane, 100, 100);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
