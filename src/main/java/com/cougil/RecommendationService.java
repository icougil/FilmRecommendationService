package com.cougil;

import java.util.List;

public class RecommendationService {

    private FilmRepository filmRepository;

    public RecommendationService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> filmByGenre(String genre) {
        return filmRepository.findByGenre(genre, SortOrder.AVERAGE_RATE);
    }
}
