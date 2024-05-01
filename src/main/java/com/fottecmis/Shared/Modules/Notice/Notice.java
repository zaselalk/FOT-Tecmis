package com.fottecmis.Shared.Modules.Notice;

public class Notice {
    protected int notice_id;
    protected String notice_title;
    protected String notice_description;

    public int getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(int notice_id) {
        this.notice_id = notice_id;
    }

    public String getNotice_title() {
        return notice_title;
    }

    public void setNotice_title(String notice_title) {
        this.notice_title = notice_title;
    }

    public String getNotice_description() {
        return notice_description;
    }

    public void setNotice_description(String notice_description) {
        this.notice_description = notice_description;
    }
}
