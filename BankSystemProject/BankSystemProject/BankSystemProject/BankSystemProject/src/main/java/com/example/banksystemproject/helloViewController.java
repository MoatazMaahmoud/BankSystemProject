package com.example.banksystemproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class helloViewController {

    @FXML
    private Button Login_Button;
    @FXML
    private Button SignUP_Button;


    @FXML
    private void handleLogin_Button() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage window = (Stage) Login_Button.getScene().getWindow();
        window.setTitle("Login");
        window.setScene(new Scene(root, 600, 400));
    }
    @FXML
    private void handleSignUP_Button() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Sign Up.fxml"));
        Stage window = (Stage) SignUP_Button.getScene().getWindow();
        window.setTitle("Sign Up");
        window.setScene(new Scene(root, 600, 400));
    }

}
