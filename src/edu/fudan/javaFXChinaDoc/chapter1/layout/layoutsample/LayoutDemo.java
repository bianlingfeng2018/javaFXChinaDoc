package edu.fudan.javaFXChinaDoc.chapter1.layout.layoutsample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LayoutDemo extends Application {
  public static void main(String[] args) {
    launch(args);
  }
  @Override
  public void start(Stage primaryStage) throws Exception {
    BorderPane borderPane = new BorderPane();
    borderPane.setTop(getTop());
    borderPane.setLeft(getLeft());
    Scene scene = new Scene(borderPane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private Node getLeft() {
    Label label = new Label("Data");
    label.setFont(Font.font("Arial", FontWeight.BOLD, 14));

    Hyperlink[] hyperlinks = {
            new Hyperlink("Sales"),
            new Hyperlink("Marketing"),
            new Hyperlink("Distribution"),
            new Hyperlink("Costs")
    };

    VBox vBox2 = new VBox();
    vBox2.getChildren().addAll(hyperlinks);

    VBox vBox = new VBox();
    vBox.getChildren().addAll(label, vBox2);
    VBox.setMargin(vBox2, new Insets(0, 0, 0, 10));
    return vBox;
  }

  private Node getTop() {
    Button b1 = new Button("Function1");
    b1.setPrefSize(100, 20);
    Button b2 = new Button("Function2");
    b2.setPrefSize(100, 20);
    HBox hBox = new HBox();
    hBox.getChildren().addAll(b1, b2);
    hBox.setSpacing(10);
    hBox.setStyle("-fx-background-color: #336699;"); //背景色
    hBox.setPadding(new Insets(15, 12, 15, 12)); //节点到边缘的距离
    return hBox;
  }
}
