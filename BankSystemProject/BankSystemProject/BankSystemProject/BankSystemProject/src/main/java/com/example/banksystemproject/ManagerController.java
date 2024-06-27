package com.example.banksystemproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

public class ManagerController extends Person implements Iadd,Iback {
    //attributes and constructors of the manager
    public  final static String username="AAM";
    public final static String password="restricted";
    @Override
    public void setSetPass(String setPass) {
        super.setSetPass(password);
    }

    @Override
    public void printInfo(CustomerController c) {

    }

    public String getUsername(){
        return username;
    }

    private static ManagerController uniqueInstance;

    public ManagerController() {
    }

    public static synchronized  ManagerController getInstance(){
        if(uniqueInstance==null){
            uniqueInstance=new ManagerController();
        }
        return uniqueInstance;
    }

    @FXML
    private TextField Name_TextField ;
    @FXML
    private TextField Phone_TextField;

    @FXML
    private TextField Id_Fire_TextField;
    @FXML
    private TextField Adress_TextField;

    @FXML
    private Button Fire_Button ;
    @FXML
    private Button Hire_Button ;
    @FXML
    private Button Analysis_Button;
    @FXML
    private Button Back_Button;
    @FXML
    private TextField salarytxt;

    @FXML
    public void handleLBack_Button() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage window = (Stage) Back_Button.getScene().getWindow();
        window.setTitle("Login");
        window.setScene(new Scene(root, 600, 400));
    }
    @FXML
    public void Hire(){
        DatabaseConnection connectNow=new DatabaseConnection();
        Connection connection=connectNow.getConnection();
        String add ="INSERT INTO staff(name,salary,phonenumber,address)"+ "VALUES('"+Name_TextField.getText()+"','"+salarytxt.getText()+"','"+Phone_TextField.getText()+"','"+Adress_TextField.getText()+"');";

        try{
            Statement statement=connection.createStatement();
            statement.executeUpdate(add);

        }catch (Exception e){
            System.out.println(e);
        }

    }

    @Override
    public void signup() {

    }

    @FXML
    public void Fire(){
        DatabaseConnection connectNow=new DatabaseConnection();
        Connection connection=connectNow.getConnection();
        String add ="DELETE FROM staff WHERE id = '"+Id_Fire_TextField.getText()+"';";

        try{
            Statement statement=connection.createStatement();
            statement.executeUpdate(add);

        }catch (Exception e){
            System.out.println(e);
        }

    }

    @Override
    public void printInfo() {

    }

    @Override
    public void checkBalance() {

    }
}
