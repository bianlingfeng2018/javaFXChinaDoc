package edu.fudan.javaFXChinaDoc.chapter1.layout.layoutsample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
    borderPane.setRight(addFlowPane());
//    borderPane.setCenter(addGridPane());
    borderPane.setCenter(addAnchorPane(addGridPane()));
    Scene scene = new Scene(borderPane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  // 左侧 VBox
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

  // 顶部HBox
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

    addStackPane(hBox);

    return hBox;
  }

  // 创建堆栈面板，将问号和方形底图叠放在一起
  public void addStackPane(HBox hb) {
    StackPane stack = new StackPane();
    Rectangle helpIcon = new Rectangle(30.0, 25.0);
    helpIcon.setFill(new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
            new Stop[]{
                    new Stop(0, Color.web("#4977A3")),
                    new Stop(0.5, Color.web("#B0C6DA")),
                    new Stop(1, Color.web("#9CB6CF")),}));
    helpIcon.setStroke(Color.web("#D0E6FA"));
    helpIcon.setArcHeight(3.5);
    helpIcon.setArcWidth(3.5);

    Text helpText = new Text("?");
    helpText.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
    helpText.setFill(Color.WHITE);
    helpText.setStroke(Color.web("#7080A0"));

    stack.getChildren().addAll(helpIcon, helpText);
    stack.setAlignment(Pos.CENTER_RIGHT); //右对齐节点

    StackPane.setMargin(helpText, new Insets(0, 10, 0, 0)); //设置问号居中显示
    hb.getChildren().add(stack); // 将StackPane添加到HBox中
    HBox.setHgrow(stack, Priority.ALWAYS); // 将HBox水平多余的所有空间都给StackPane，这样前面设置的右对齐就能保证问号按钮在最右边
  }


  // 右侧新增流面板/磁铁面板
  public TilePane addFlowPane() {
//  public FlowPane addFlowPane() {
//    FlowPane flow = new FlowPane();
//    flow.setPadding(new Insets(5, 0, 5, 0));
//    flow.setVgap(4);
//    flow.setHgap(4);
//    flow.setPrefWrapLength(170); // 预设FlowPane的宽度，使其能够显示两列
//    flow.setStyle("-fx-background-color: DAE6F3;");
//
//    ImageView pages[] = new ImageView[8];
//    for (int i = 0; i < 8; i++) {
//      pages[i] = new ImageView(
//              new Image(LayoutSample.class.getResourceAsStream(
//                      "graphics/chart_" + (i + 1) + ".png")));
//      flow.getChildren().add(pages[i]);
//    }
//    return flow;
    TilePane tile = new TilePane();
    tile.setPadding(new Insets(5, 0, 5, 0));
    tile.setVgap(4);
    tile.setHgap(4);
    tile.setPrefColumns(2);
    tile.setStyle("-fx-background-color: DAE6F3;");

    ImageView pages[] = new ImageView[8];
    for (int i=0; i<8; i++){
      pages[i] = new ImageView(
              new Image(LayoutSample.class.getResourceAsStream(
                      "graphics/chart_"+(i+1)+".png")));
      tile.getChildren().add(pages[i]);
    }
    return tile;
  }
  
  // 新增网格面板
  public GridPane addGridPane(){
    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(0, 10, 0, 10));
    grid.setGridLinesVisible(true);

    // 将category节点放在第1行,第2列
    Text category = new Text("Sales:");
    category.setFont(Font.font("Arial", FontWeight.BOLD, 20));
    grid.add(category, 1, 0);

    // 将chartTitle节点放在第1行,第3列
    Text chartTitle = new Text("Current Year");
    chartTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
    grid.add(chartTitle, 2, 0);

    // 将chartSubtitle节点放在第2行,占第2和第3列
    Text chartSubtitle = new Text("Goods and Services");
    grid.add(chartSubtitle, 1, 1, 2, 1);

    // 将House图标放在第1列，占第1和第2行
    ImageView imageHouse = new ImageView(
            new Image(LayoutSample.class.getResourceAsStream("graphics/house.png")));
    grid.add(imageHouse, 0, 0, 1, 2);

    // 将左边的标签goodsPercent放在第3行，第1列，靠下对齐
    Text goodsPercent = new Text("Goods\n80%");
    GridPane.setValignment(goodsPercent, VPos.BOTTOM);
    grid.add(goodsPercent, 0, 2);

    // 将饼图放在第3行，占第2和第3列
    ImageView imageChart = new ImageView(
            new Image(LayoutSample.class.getResourceAsStream("graphics/piechart.png")));
    grid.add(imageChart, 1, 2, 2, 1);

    // 将右边的标签servicesPercent放在第3行，第4列，靠上对齐
    Text servicesPercent = new Text("Services\n20%");
    GridPane.setValignment(servicesPercent, VPos.TOP);
    grid.add(servicesPercent, 3, 2);

    return grid;
  }
  
  // 创建锚面板
  public AnchorPane addAnchorPane(GridPane grid){
    AnchorPane anchorpane = new AnchorPane();

    Button buttonSave = new Button("Save");
    Button buttonCancel = new Button("Cancel");

    HBox hb = new HBox();
    hb.setPadding(new Insets(0, 10, 10, 10));
    hb.setSpacing(10);
    hb.getChildren().addAll(buttonSave, buttonCancel);

    anchorpane.getChildren().addAll(grid,hb); //添加来自例1-5 的GridPane
    AnchorPane.setBottomAnchor(hb, 8.0);
    AnchorPane.setRightAnchor(hb, 5.0);
    AnchorPane.setTopAnchor(grid, 10.0);

    return anchorpane;
  }
}
