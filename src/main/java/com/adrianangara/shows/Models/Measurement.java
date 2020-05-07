package com.adrianangara.shows.Models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Measurement {

    private String imperial;
    private String metric;

    public Measurement(String imp, String met) {
        this.imperial = imp;
        this.metric = met;
    }
}
