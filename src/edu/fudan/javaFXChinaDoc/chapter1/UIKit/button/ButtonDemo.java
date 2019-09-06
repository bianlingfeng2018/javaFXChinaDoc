package edu.fudan.javaFXChinaDoc.chapter1.UIKit.button;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ButtonDemo extends Application {
  public static void main(String[] args) {
    launch(args);
  }
  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Button demo");

    Button button = new Button("My Button");
    Image image = new Image(getClass().getResourceAsStream("ok.png"));
    button.setGraphic(new ImageView(image));
    button.setGraphicTextGap(5.0);
    button.setContentDisplay(ContentDisplay.TOP);

    button.setOnAction((event)-> {
      button.setText("Accept!");
    });

    button.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
      button.setEffect(new DropShadow());
    });

    button.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
      button.setEffect(null);
    });

    button.getStyleClass().add("button_test");

    AnchorPane anchorPane = new AnchorPane();
    anchorPane.getChildren().add(button);
    Scene scene = new Scene(anchorPane);
    scene.getStylesheets().add("edu/fudan/javaFXChinaDoc/chapter1/UIKit/button/ControlStyle.css");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
