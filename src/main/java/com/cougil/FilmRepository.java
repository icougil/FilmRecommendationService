package com.cougil;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FilmRepository {

    private DataSource dataSource;

    public FilmRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Film> findByGenre(String genre, SortOrder sortOrder) {
        List<Film> films = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
        final String sql = "select f.id as id, f.title as title, f.year as year, f.tags as tags, f.genres as genres, avg(r.rate) as avg_rate " +
                "from ratings r, films f " +
                "where r.film_id = f.id and f.genres like ? " +
                "group by r.film_id, f.id, f.title, f.year, f.tags, f.genres " +
                "order by "+sortOrder.getName()+" DESC";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, "%"+genre+"%");
                final ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    final Film film = readFilm(resultSet);
                    films.add(film);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return films;
    }

    private Film readFilm(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        int year = resultSet.getInt("year");
        String tags = resultSet.getString("tags");
        final List<String> tagList = Arrays.stream(tags.split(", ")).collect(toList());
        final String genres = resultSet.getString("genres");
        final List<String> genresList = Arrays.stream(genres.split(", ")).collect(toList());
        return new Film(id, title, year, tagList, genresList);
    }
}
