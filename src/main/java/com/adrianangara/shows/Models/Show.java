package com.adrianangara.shows.Models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Data
@RequiredArgsConstructor
public class Show {

    public int id;
    public long date;
    public String location;
    public Type type;

    public Show(int id, long show_date, String location, Type show_type) {
        this.id = id;
        this.date = show_date;
        this.location = location;
        this.type = show_type;
    }

    public enum Type {
        ALLBREED, SPECIALTY, GROUP
    }
}
