module com.fottecmis.fottecmis {
    requires javafx.controls;
    requires javafx.fxml;
//    requires mysql.connector.java;
    requires java.sql;


    opens com.fottecmis to javafx.fxml;
    exports com.fottecmis;
}