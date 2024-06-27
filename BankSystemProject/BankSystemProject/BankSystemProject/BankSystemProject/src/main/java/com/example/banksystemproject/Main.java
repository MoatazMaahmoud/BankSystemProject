package com.example.banksystemproject;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
        public Main() {
        }

        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
            Scene scene = new Scene((Parent)fxmlLoader.load(), 600, 400);
            stage.setTitle("DashBoard");
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {
            launch(new String[0]);
        }
    }


