package com.fottecmis.Notice;

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
