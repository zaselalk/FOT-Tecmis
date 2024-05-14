package com.fottecmis.TecnicalOfficer;

import com.fottecmis.Shared.Modules.Medical.MedicalController;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.sql.Connection;

public class TechnicalOfficerMedicalController extends MedicalController {
    @FXML
    public TableView tableView;

    public TechnicalOfficerMedicalController(Connection connection) {
        super(connection);
    }


}
