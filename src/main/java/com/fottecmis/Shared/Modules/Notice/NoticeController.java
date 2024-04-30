package com.fottecmis.Shared.Modules.Notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoticeController {
    Connection connection;

    protected NoticeController(Connection connection) {
        this.connection = connection;
    }

    public void createNotice(Notice notice) throws SQLException {
        PreparedStatement pres = connection.prepareStatement("INSERT INTO notice (notice_title, notice_description) VALUES (?, ?);");
        pres.setString(1, notice.getNotice_title());
        pres.setString(2, notice.getNotice_description());

        pres.executeUpdate();
    }

    public void deleteNotice(int notice_id) throws SQLException {
        PreparedStatement pres = connection.prepareStatement("DELETE FROM notice WHERE notice_id = ?;");
        pres.setInt(1, notice_id);

        pres.executeUpdate();
    }

    public void updateNotice(Notice notice) throws SQLException {
        PreparedStatement pres = connection.prepareStatement("UPDATE notice SET notice_title = ?, notice_description = ? WHERE notice_id = ?;");
        pres.setString(1, notice.getNotice_title());
        pres.setString(2, notice.getNotice_description());
        pres.setInt(3, notice.getNotice_id());

        pres.executeUpdate();
    }

    public List<Notice> getAllNotices() throws SQLException {
        ResultSet resultSet;
        PreparedStatement getNotices = connection.prepareStatement("SELECT * FROM notice;");
        resultSet = getNotices.executeQuery();

        if (!resultSet.next()) {
            return null;
        }

        return getNotices(resultSet);
    }

    private List<Notice> getNotices(ResultSet resultSet) {
        try {
            List<Notice> notices = new ArrayList<>();
            do {
                Notice notice = new Notice();
                notice.setNotice_id(resultSet.getInt("notice_id"));
                notice.setNotice_title(resultSet.getString("notice_title"));
                notice.setNotice_description(resultSet.getString("notice_description"));

                notices.add(notice);
            } while (resultSet.next());
            return notices;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }


}
