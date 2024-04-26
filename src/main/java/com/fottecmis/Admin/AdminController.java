package com.fottecmis.Admin;

import java.sql.Connection;

public class AdminController {
    private int admin_id;
    private Connection connection;


    public void initialize(int adminId, Connection connection) {
        this.admin_id = adminId;
        this.connection = connection;
    }
}
