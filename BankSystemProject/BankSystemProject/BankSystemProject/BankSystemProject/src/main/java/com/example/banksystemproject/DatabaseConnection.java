package com.example.banksystemproject;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection connection;
    public Connection getConnection(){
        String databaseName="bankdb";
        String databaseUser="root";
        String databasePassword="0119658100Ah*";
        String url="jdbc:mysql://localhost/"+databaseName;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,databaseUser,databasePassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
