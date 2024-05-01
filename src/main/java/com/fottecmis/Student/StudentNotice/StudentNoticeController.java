package com.fottecmis.Student.StudentNotice;

import com.fottecmis.Shared.Modules.Notice.NoticeController;

import java.sql.Connection;

public class StudentNoticeController extends NoticeController {

    public StudentNoticeController(Connection connection) {
        super(connection);
    }
}
