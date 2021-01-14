package com.cougil;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RecommendationServiceShould {

    @Mock
    private FilmRepository filmRepository;

    @Test
    void return_a_list_of_films_by_genre_ordered_by_average_rate() {
        RecommendationService recommendationService = new RecommendationService(filmRepository);

        List<Film> expectedFilms = Arrays.asList(FilmsObjectMother.MATRIX, FilmsObjectMother.STAR_WARS_EPISODE_IV);
        when(filmRepository.findByGenre("science-fiction", SortOrder.AVERAGE_RATE)).thenReturn(expectedFilms);

        assertThat(recommendationService.filmByGenre("science-fiction")).isEqualTo(expectedFilms);
    }
}
