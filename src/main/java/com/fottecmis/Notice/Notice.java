package com.fottecmis.Notice;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Notice {
    private final StringProperty date;
    private final StringProperty title;

    public Notice(String date, String title) {
        this.date = new SimpleStringProperty(date);
        this.title = new SimpleStringProperty(title);
    }

    public StringProperty dateProperty() {
        return date;
    }

    public StringProperty titleProperty() {
        return title;
    }

}
