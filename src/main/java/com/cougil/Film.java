package com.cougil;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id == film.id &&
                year == film.year &&
                Objects.equals(title, film.title) &&
                Objects.equals(tags, film.tags) &&
                Objects.equals(genres, film.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, year, tags, genres);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Film.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("title='" + title + "'")
                .add("year=" + year)
                .add("tags=" + tags)
                .add("genres=" + genres)
                .toString();
    }
}
