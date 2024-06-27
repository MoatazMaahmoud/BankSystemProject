module com.example.banksystemproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.banksystemproject to javafx.fxml;
    exports com.example.banksystemproject;
}