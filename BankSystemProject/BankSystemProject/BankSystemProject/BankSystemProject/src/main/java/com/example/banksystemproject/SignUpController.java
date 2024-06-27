package com.example.banksystemproject;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

public class SignUpController implements Iback {

    @FXML
    private TextField FirstName_TextField;
    @FXML
    private TextField LastName_TextField;
    @FXML
    private TextField UserName_TextField;
    @FXML
    private TextField Password_TextField;
    @FXML
    private TextField Email_TextField;
    @FXML
    private TextField PhoneNumber_TextField;

    @FXML
    private RadioButton Male_Radio;
    @FXML
    private RadioButton Female_Radio;

    @FXML
    private Button SignUp_Button;
    @FXML
    private Label errorlable;
    @FXML

    public void handleSignUp_Button() throws IOException {
        //Handle Exception for the phone number input

        String Firstname = FirstName_TextField.getText();
        String Lastname = LastName_TextField.getText();
        String Username = UserName_TextField.getText();
        String Password = Password_TextField.getText();
        String Email = Email_TextField.getText();
        String phone = PhoneNumber_TextField.getText();

        if (Firstname.isEmpty()||Lastname.isEmpty() || Username.isEmpty()|| Password.isEmpty()||Email.isEmpty()|| phone.isEmpty()||(!Male_Radio.isSelected()&& !Female_Radio.isSelected())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Please fill all data");
            alert.showAndWait();
        }
        else {
            try{
                int phone1 =  Integer.parseInt(PhoneNumber_TextField.getText());

                CustomerController customer=new CustomerController(FirstName_TextField.getText(),LastName_TextField.getText()
                        ,UserName_TextField.getText(),Password_TextField.getText(),Email_TextField.getText(),PhoneNumber_TextField.getText()
                );

                DatabaseConnection connectNow=new DatabaseConnection();
                Connection connection=connectNow.getConnection();
                String add ="INSERT INTO customer_info(firstname,lastname,username,password,email,phonenumber)"+ "VALUES('"+customer.getFirstName()+"','"+customer.getLastName()+"'," +
                        "'"+ customer.getUsername()+"','"+customer.getSetPass()+"','"+customer.getEmail()+"','"+customer.getPhoneNo()+"')";


                try{
                    Statement statement=connection.createStatement();
                    statement.executeUpdate(add);

                }catch (Exception e){
                    System.out.println(e);
                }

                Parent root = FXMLLoader.load(getClass().getResource("SignUp_Continue.fxml"));
                Stage window = (Stage) SignUp_Button.getScene().getWindow();
                window.setScene(new Scene(root, 600, 400));
            }
            catch ( NumberFormatException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setContentText("Please Enter your phone number in the right format.");
                alert.showAndWait();
            }



        }


            /*Parent root = FXMLLoader.load(getClass().getResource("SignUp_Continue.fxml"));
            Stage window = (Stage) SignUp_Button.getScene().getWindow();
            window.setScene(new Scene(root, 600, 400));*/


    }

    @FXML
    private Button Back_Button;

    @FXML
    public void handleLBack_Button() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage window = (Stage) Back_Button.getScene().getWindow();
        window.setTitle("DashBoard");
        window.setScene(new Scene(root, 600, 400));
    }
}
