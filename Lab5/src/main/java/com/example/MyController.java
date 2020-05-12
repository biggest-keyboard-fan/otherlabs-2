package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MyController {

    @FXML
    private Label output;

    @FXML
    public void onClick(ActionEvent event) {
        String outputText = output.getText();
        if(outputText.equals("0")) outputText = "";
        String text = ((Button)event.getSource()).getText()+outputText;
        output.setText(text.substring(0,Math.min(6,text.length())));
    }
}