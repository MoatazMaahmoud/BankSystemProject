package com.example.banksystemproject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class CustomerController extends Person implements Imethods,Iback {
    private String username;
    @FXML
    private Button CheckBalance_Button;
    @FXML
    private Button Deposite_Button;
    @FXML
    private Button Withdraw_Button;
    @FXML
    private Label Balance_Label;
    @FXML
    private Label Deposite_label;
    @FXML
    private Label withdraw_label;
    @FXML
    private Button Back_Button;
    @FXML
    private TextField deposit_text;
    @FXML
    private TextField withdraw_text;
    @FXML
    private Label balance_label;
    @FXML
    private TextField accno_text;
    @FXML
    private Label new_balance;
    @FXML
    private Label new_balancee;
    public CustomerController(String firstName, String lastName,String username,String setPass ,String email, String phoneNo) {
        super(firstName,lastName,email,phoneNo,setPass);
        this.username=username;
    }

    public CustomerController() {

    }

    public String getUsername() {
        return username;
    }

    // ---------------------------------------------------------------------------------------
    @FXML
    public void handleLBack_Button() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage window = (Stage) Back_Button.getScene().getWindow();
        window.setTitle("Customer");
        window.setScene(new Scene(root, 600, 400));
    }
//------------------------------------------------------------------------------------------
public void checkBalance(ActionEvent event){
    DatabaseConnection connectNow=new DatabaseConnection();
    Connection connection=connectNow.getConnection();
    String accno=accno_text.getText();
    String connectQuery="WITH Base AS (SELECT *, ROW_NUMBER() OVER (ORDER BY Accountnumber) RN FROM accounts)" +
            "SELECT *FROM Base WHERE Accountnumber IN ('"+accno+"')";
    try{
        Statement statement=connection.createStatement();
        ResultSet queryOutput=statement.executeQuery(connectQuery);
        while(queryOutput.next()){
            balance_label.setText(queryOutput.getString("balance"));
        }
    } catch (SQLException e) {
        System.out.println(e);
    }
}
    public String returnBalance(String accnumber){
        String currentbalance = null;
        DatabaseConnection connectNow=new DatabaseConnection();
        Connection connection=connectNow.getConnection();
        String accno=accnumber;
        String connectQuery="WITH Base AS (SELECT *, ROW_NUMBER() OVER (ORDER BY Accountnumber) RN FROM accounts)" +
                "SELECT *FROM Base WHERE Accountnumber IN ('"+accno+"')";
        try{
            Statement statement=connection.createStatement();
            ResultSet queryOutput=statement.executeQuery(connectQuery);
            while(queryOutput.next()){
               currentbalance=queryOutput.getString("balance");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return currentbalance;
    }

    public void deposit(ActionEvent event){
        DatabaseConnection connectNow=new DatabaseConnection();
        Connection connection=connectNow.getConnection();
        String accno=accno_text.getText();
        //int x=Integer.parseInt(accno_text.getText());
        int newbalance=(Integer.parseInt(returnBalance(accno))+Integer.parseInt(deposit_text.getText()));
        String connectQuery="UPDATE accounts SET balance='"+newbalance+"' WHERE id=?;";
        try{
            PreparedStatement statement=connection.prepareStatement(connectQuery);
            //1 da m3rfsh eh bs 2 danel rkm ely byt7t 3nd el ? fel connect query
            statement.setInt(1, 2);
            statement.executeUpdate();
            new_balance.setText(String.valueOf(newbalance));
        } catch (Exception e){
            System.out.println(e);
        }
    }
   public void withdraw(ActionEvent event){
        DatabaseConnection connectNow=new DatabaseConnection();
        Connection connection=connectNow.getConnection();
        String accno=accno_text.getText();
        //int x=Integer.parseInt(accno_text.getText());
        int newbalance=(Integer.parseInt(returnBalance(accno))-Integer.parseInt(withdraw_text.getText()));
        String connectQuery="UPDATE accounts SET balance='"+newbalance+"' WHERE id=?;";
        try{
            PreparedStatement statement=connection.prepareStatement(connectQuery);
            //1 da m3rfsh eh bs 2 danel rkm ely byt7t 3nd el ? fel connect query
            statement.setInt(1, 2);
            statement.executeUpdate();
            new_balancee.setText(String.valueOf(newbalance));
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void printInfo(CustomerController c) {

    }

    @Override
    public void printInfo() {

    }

    @Override
    public void checkBalance() {

    }
}
