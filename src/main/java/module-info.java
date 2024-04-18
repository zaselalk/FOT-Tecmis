module com.fottecmis.fottecmis {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.fottecmis to javafx.fxml;
    exports com.fottecmis;
}