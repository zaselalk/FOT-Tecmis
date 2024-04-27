module com.fottecmis.fottecmis {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.fottecmis.Authenticate to javafx.fxml;
    opens com.fottecmis.Lecturer to javafx.fxml;
    opens com.fottecmis.Admin to javafx.fxml;
    opens com.fottecmis.Student to javafx.fxml;
    opens com.fottecmis.TestMap to javafx.fxml;
    opens com.fottecmis.TecnicalOfficer to javafx.fxml;
    opens com.fottecmis.Student.StudentMedical to javafx.fxml, javafx.base;
    exports com.fottecmis;
}