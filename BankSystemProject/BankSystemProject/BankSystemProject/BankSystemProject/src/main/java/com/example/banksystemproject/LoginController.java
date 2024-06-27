package com.example.banksystemproject;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController  {
    ManagerController manager = new ManagerController();
    private String userM = ManagerController.username;
    private String userP = ManagerController.password;
    @FXML
    private TextField UserName_TextField;
    @FXML
    private TextField Password_TextField;
    @FXML
    private RadioButton Customer_Radio;
    @FXML
    private RadioButton Manager_Radio;
    @FXML
    private RadioButton Staff_Radio;
    @FXML
    private Button Login_Button;
    @FXML
    private Button Back_Button;
    @FXML
    private Label error;

    @FXML
    public void handleLogin_Button() throws IOException {
        String pass=Password_TextField.getText();
        String user=UserName_TextField.getText();;
        try {
            if (Manager_Radio.isSelected())
                if( user.equals("AAM") && pass.equals("restricted")) {
                Parent root = FXMLLoader.load(getClass().getResource("Manager.fxml"));
                Stage window = (Stage) Login_Button.getScene().getWindow();
                window.setTitle("Manager");
                window.setScene(new Scene(root, 600, 400));
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            error.setText("Please enter the right credentials");
        }

        if(Customer_Radio.isSelected())

    {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connection = connectNow.getConnection();
        String validate ="SELECT count(1) FROM customer_info WHERE username= '"+UserName_TextField.getText()+"'and password ='"+Password_TextField.getText()+"'";
        try {
            Statement statement = connection.createStatement();
            ResultSet queryResult = statement.executeQuery(validate);

            while (queryResult.next()) {
                if (queryResult.getInt(1)== 1 && (Customer_Radio.isSelected())) {
                    Parent root = FXMLLoader.load(getClass().getResource("Customer.fxml"));
                    Stage window = (Stage) Login_Button.getScene().getWindow();
                    window.setTitle("Customer");
                    window.setScene(new Scene(root, 600, 400));
                    //loginsucc.setText("you did it");
                } else if (queryResult.getInt(1) != 1 && (Customer_Radio.isSelected())) {
                    throw new Exception();
                } else {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            error.setText("Please enter the right credentials");

        }
    }

}

        /*if(Manager_Radio.isSelected()) {
            Parent root = FXMLLoader.load(getClass().getResource("Manager.fxml"));
            Stage window = (Stage) Login_Button.getScene().getWindow();
            window.setTitle("Manager");
            window.setScene(new Scene(root, 600, 400));
        }
        else{}*/


    @FXML
    public void handleBack_Button() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage window = (Stage) Back_Button.getScene().getWindow();
        window.setTitle("DashBoard");
        window.setScene(new Scene(root, 600, 400));
    }



}


