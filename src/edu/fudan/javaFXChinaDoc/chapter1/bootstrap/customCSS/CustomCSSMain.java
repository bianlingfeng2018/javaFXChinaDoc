package edu.fudan.javaFXChinaDoc.chapter1.bootstrap.customCSS;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CustomCSSMain extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX Form!");

        // 设置 gridPane
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        // 设置表单
        Text title = new Text("Welcome!");
        title.setId("title-text");
//        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));  // 内联样式
        gridPane.add(title, 0, 0, 2, 1);  // 0行0列，合并2列，合并1行
        Label userName = new Label("User Name");
        gridPane.add(userName, 0, 1);  // 1行0列
        TextField userNameTextField = new TextField();
        gridPane.add(userNameTextField, 1, 1);
        Label password = new Label("Password");
        gridPane.add(password, 0, 2);
        PasswordField passwordField = new PasswordField();
        gridPane.add(passwordField, 1, 2);
//        gridPane.setGridLinesVisible(true);  // 为了便于调试，打开 gridPane 的网格线

        // 增加提交表单按钮
        Button button = new Button();
        button.setText("Sign in");
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().add(button);
        gridPane.add(hBox, 1, 4);

        // 增加显示消息的文本
        Text actionTarget = new Text();
        gridPane.add(actionTarget, 1, 6);
        actionTarget.setId("actionTarget-text");

        // 增加事件处理代码
        button.setOnAction(event -> {
//            actionTarget.setFill(Color.FIREBRICK);  // 内联样式
            actionTarget.setText("Sign in button pressed");
        });

        Scene scene = new Scene(gridPane, 800, 600);
        // 增加自定义CSS
        scene.getStylesheets().add(CustomCSSMain.class.getResource("Login.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
