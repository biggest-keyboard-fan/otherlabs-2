package com.example;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.FileInputStream;

public class MyApplication extends Application {
    public static Parent root;

    @Override
    public void start(Stage primaryStage) throws Exception {
        try(FileInputStream fi = new FileInputStream("singleton.fxml")){
            root = (Pane) new FXMLLoader().load(fi);
        }
        primaryStage.setTitle("Singleton");
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
