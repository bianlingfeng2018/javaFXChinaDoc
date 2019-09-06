package edu.fudan.javaFXChinaDoc.chapter1.UIKit.scrollbar;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScrollbarDemo extends Application {
  public static void main(String[] args) {
    launch(args);
  }
  @Override
  public void start(Stage primaryStage) throws Exception {
    ScrollBar scrollBar = new ScrollBar();
    scrollBar.setMax(0);
    scrollBar.setMax(100);
    scrollBar.setValue(50);
    scrollBar.setOrientation(Orientation.VERTICAL);

    scrollBar.setBlockIncrement(50);
    scrollBar.setUnitIncrement(2);

    VBox vBox = new VBox();
    vBox.getChildren().add(scrollBar);
    Scene scene = new Scene(vBox);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
