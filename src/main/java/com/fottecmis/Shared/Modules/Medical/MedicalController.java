package com.fottecmis.Shared.Modules.Medical;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicalController {
    Connection connection;

    protected MedicalController(Connection connection) {
        this.connection = connection;
    }

    public List<Medical> getAllMedicals() throws SQLException {
        List<Medical> medicals = new ArrayList<>();
        ResultSet resultSet;
        PreparedStatement getStudentMedical = connection.prepareStatement("SELECT * FROM medical m INNER JOIN courses c where m.course_id = c.c_id;");
        resultSet = getStudentMedical.executeQuery();

        if (!resultSet.next()) {
            return null;
        }

        return getMedicals(medicals, resultSet);

    }

    public List<Medical> getAllMedicalsById(int stuid) throws SQLException {
        List<Medical> medicals = new ArrayList<>();
        ResultSet resultSet;

        PreparedStatement getStudentMedical = connection.prepareStatement("SELECT * FROM medical m INNER JOIN courses c where m.course_id = c.c_id AND m.student_id = ?;");
        getStudentMedical.setInt(1, stuid);

        resultSet = getStudentMedical.executeQuery();

        if (!resultSet.next()) {
            System.out.println("No medical found");
            return null;
        }

        return getMedicals(medicals, resultSet);
    }

    private List<Medical> getMedicals(List<Medical> medicals, ResultSet resultSet) throws SQLException {
        do {
            Medical studentMedical = new Medical();
            studentMedical.setStudent_id(resultSet.getInt("student_id"));
            studentMedical.setMedical_id(resultSet.getInt("medical_id"));
            studentMedical.setCourse_id(resultSet.getInt("course_id"));
            studentMedical.setCourse_name(resultSet.getString("course_name"));
            medicals.add(studentMedical);
        } while (resultSet.next());

        return medicals;
    }
}
