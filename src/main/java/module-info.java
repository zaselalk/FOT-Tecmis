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
//    opens com.fottecmis.Shared.Modules to javafx.base, javafx.fxml;
    opens com.fottecmis.Lecturer.LecturerMedical to javafx.fxml;
    opens com.fottecmis.Student.StudentCourse to javafx.fxml;
    opens com.fottecmis.Shared.Modules.Course to javafx.base, javafx.fxml;
    opens com.fottecmis.Shared.Modules.Medical to javafx.base, javafx.fxml;
}