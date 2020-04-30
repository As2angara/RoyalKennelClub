package com.adrianangara.shows.Models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BreedPic {

    public int id;
    public String pic_url;

    public BreedPic(int id, String pic_url) {
        this.id = id;
        this.pic_url = pic_url;
    }
}
