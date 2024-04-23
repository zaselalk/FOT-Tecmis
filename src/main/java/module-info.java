module com.fottecmis.fottecmis {
    requires javafx.controls;
    requires javafx.fxml;
//    requires mysql.connector.java;
    requires java.sql;
//    requires mysql.connector.j;


    opens com.fottecmis.Authenticate to javafx.fxml;
    exports com.fottecmis;
}