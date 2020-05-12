package com.example;

import com.example.misc.GenericUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MyController {
    @FXML
    public void selectFile(ActionEvent event) {
        Button button = (Button) event.getSource();
        String btnId = button.getId();
        Label label = (Label) button.getScene().lookup("#" + btnId.replace("button", "label"));
        String fileName=null;
        switch (btnId){
            case "button1": fileName = "first.txt"; break;
            case "button2": fileName = "second.txt"; break;
            case "button3": fileName = "third.txt"; break;
        }
        label.setText(GenericUtils.readStringFromFile(fileName));
    }
}
