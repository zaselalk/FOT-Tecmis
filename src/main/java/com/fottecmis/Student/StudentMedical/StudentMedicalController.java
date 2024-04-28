package com.fottecmis.Student.StudentMedical;

import com.fottecmis.Shared.Modules.Medical.MedicalController;

import java.sql.Connection;

public class StudentMedicalController extends MedicalController {

    StudentMedicalController(Connection connection) {
        super(connection);
    }

}
