package edu.fudan.javaFXChinaDoc.chapter1.UIKit.listView;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class ListViewCustomCellDemo2 extends Application {
  ListView<String> listView = new ListView<>();
  ObservableList data = FXCollections.observableArrayList(
          "chocolate", "salmon", "gold", "coral", "darkorchid",
          "darkgoldenrod", "lightsalmon", "black", "rosybrown", "blue",
          "blueviolet", "brown");
  Label label = new Label();

  public static void main(String[] args) {
    launch(args);
  }

  static class ColorRectCell extends ListCell<String> {
    @Override
    public void updateItem(String item, boolean empty) {
      super.updateItem(item, empty);
      Rectangle rect = new Rectangle(100, 20);
      if (item != null) {
        rect.setFill(Color.web(item));
        setGraphic(rect);  // labeled 对象都可以设置这个
        setText(item);  // labeled 对象都可以设置这个
      }
    }
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    VBox vBox = new VBox();
    VBox.setVgrow(listView, Priority.ALWAYS);
    // 此处这两个属性似乎没效果
//    label.setLayoutX(10);
//    label.setLayoutY(115);
    label.setFont(Font.font("Verdana", 20));
    vBox.getChildren().addAll(listView, label);
    listView.setItems(data);

    listView.setCellFactory((ListView<String> l) -> new ColorRectCell());

    listView.getSelectionModel().selectedItemProperty().addListener(
            (ObservableValue<? extends String> ov,
             String old_val,
             String new_val) -> {
              label.setText(new_val);
              label.setTextFill(Color.web(new_val));
            });

    Scene scene = new Scene(vBox, 200, 200);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
