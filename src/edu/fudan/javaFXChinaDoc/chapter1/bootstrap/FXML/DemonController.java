package edu.fudan.javaFXChinaDoc.chapter1.bootstrap.FXML;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class DemonController {
    @FXML private Text actiontarget;
    @FXML protected void handleSubmitButtonAction(ActionEvent actionEvent) {
        actiontarget.setText("Sign in button pressed");
    }
}
