package com.adrianangara.shows.Models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Data
@RequiredArgsConstructor
public class Show {

    public int id;
    public long date;
    public Type type;
    public int eventId;

    public Show(int id, long show_date, Type show_type, int eventId) {
        this.id = id;
        this.date = show_date;
        this.type = show_type;
        this.eventId = eventId;
    }

    public enum Type {
        ALLBREED, SPECIALTY, GROUP
    }
}
