package com.cougil;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

class FilmRepositoryITest {

    @Container
    public PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            DockerImageName.parse("postgres:13.1")
    )
    .withInitScript("init.sql")
    .withExposedPorts(5432);

    @BeforeEach
    public void setUp() {
        postgres.start();
    }

    @Test
    void should_return_list_of_films_filtered_by_genre_and_ordered_by_average() {
        FilmRepository filmRepository = new FilmRepository(getDataSource());
        List<Film> expectedFilms = Arrays.asList(FilmsObjectMother.MATRIX, FilmsObjectMother.STAR_WARS_EPISODE_IV);
        assertThat(filmRepository.findByGenre("science-fiction", SortOrder.AVERAGE_RATE)).isEqualTo(expectedFilms);
    }

    private DataSource getDataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(postgres.getJdbcUrl());
        hikariConfig.setUsername(postgres.getUsername());
        hikariConfig.setPassword(postgres.getPassword());
        hikariConfig.setDriverClassName(postgres.getDriverClassName());

        return new HikariDataSource(hikariConfig);
    }
}
