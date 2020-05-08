package com.adrianangara.shows.Models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Event {

    private int id;
    private String name;
    private String location;
    private String venue;


    public Event(int id, String name, String location, String venue) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.venue = venue;
    }
}
