package com.example;

import com.example.misc.GenericUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class MyApplication extends Application {
    Parent root;
    @Override
    public void start(Stage primaryStage) throws Exception {
        try(FileInputStream fi = new FileInputStream("calculator.fxml")){
            root = (Pane) new FXMLLoader().load(fi);
        }
        primaryStage.setTitle("Calculator");
        try {
            primaryStage.setScene(new Scene(root, 640, 480));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
