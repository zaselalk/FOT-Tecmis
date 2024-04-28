package com.fottecmis.Student.StudentMedical;

import com.fottecmis.Shared.Modules.MedicalController;

import java.sql.Connection;

public class StudentMedicalController extends MedicalController {

    StudentMedicalController(Connection connection) {
        super(connection);
    }

}
