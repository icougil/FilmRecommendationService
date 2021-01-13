package com.cougil;

import java.util.List;

public class Film {
    private final int id;
    private final String title;
    private final int year;
    private final List<String> tags;
    private final List<String> genres;

    public Film(int id, String title, int year, List<String> tags, List<String> genres) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.tags = tags;
        this.genres = genres;
    }
}
