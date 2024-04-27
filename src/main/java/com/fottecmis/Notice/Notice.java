package com.fottecmis.Notice;

import java.util.Date;

public class Notice {
    public int noticeId;
    private Date date;
    private String title;
    private String description;
    private String filepath;


    public int getNoticeId(){
        return noticeId;
    }
    public void setNoticeId(int noticeId){
        this.noticeId=noticeId;
    }

    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date=date;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }

    public String getFilepath(){
        return filepath;
    }
    public void setFilepath(String filepath){
        this.filepath=filepath;
    }



}

















/*package com.fottecmis.Notice;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Notice {
    private final StringProperty date;
    private final StringProperty description;

    public Notice(String date, String description) {
        this.date = new SimpleStringProperty(date);
        this.description = new SimpleStringProperty(description);
    }

    public StringProperty dateProperty() {
        return date;
    }

    public StringProperty descriptionProperty() {
        return description;
    }

}
*/