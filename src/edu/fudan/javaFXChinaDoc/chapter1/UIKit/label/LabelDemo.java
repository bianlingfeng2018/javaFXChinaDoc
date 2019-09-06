package edu.fudan.javaFXChinaDoc.chapter1.UIKit.label;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.stage.Stage;

public class LabelDemo extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
//    Label label = new Label("Search");
//    Image image = new Image(getClass().getResourceAsStream("labels.jpg"));
//    label.setGraphic(new ImageView(image));
//    label.setTextFill(Color.web("#0076a3"));
//    label.setFont(Font.font("Arial", 30));

//    label.setTextAlignment(TextAlignment.RIGHT);  // 文本对齐方式
//    label.setContentDisplay(ContentDisplay.RIGHT);  // 图形和文字的相对位置

    Label label = new Label("A label that needs to be wrapped");
    label.setWrapText(true);  // 宽度限制时折叠换行
    label.setTextOverrun(OverrunStyle.ELLIPSIS);  // 高度限制时显示省略号

    label.setRotate(270);
    label.setTranslateY(50);

    label.setOnMouseEntered(event -> {
      label.setScaleX(1.5);
      label.setScaleY(1.5);
    });

    label.setOnMouseExited(event -> {
      label.setScaleX(1.0);
      label.setScaleY(1.0);
    });

    Scene scene = new Scene(label);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
