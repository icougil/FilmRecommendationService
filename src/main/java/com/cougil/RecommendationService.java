package com.cougil;

import java.util.List;

public class RecommendationService {

    private FilmRepository filmRepository;

    public RecommendationService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> filmByTag(String tag) {
        return filmRepository.findByTag(tag, SortOrder.AVERAGE_RATE);
    }
}
