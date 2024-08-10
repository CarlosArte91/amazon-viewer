package model.dao;

import static constants.DataBase.*;
import db.IDBConnection;
import model.entity.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface MovieDao extends IDBConnection {
    default Movie setToViewed(Movie movie) {
        return movie;
    }

    default ArrayList<Movie> read() {
        ArrayList<Movie> movies = new ArrayList<>();
        Movie movie;
        String title;
        String genre;
        String creator;
        int duration;
        short year;

        try (Connection connection = connectToDB()) {
            String query = "SELECT * FROM " + TMOVIE;
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                title = resultSet.getString(TMOVIE_TITLE);
                genre = resultSet.getString(TMOVIE_GENRE);
                creator = resultSet.getString(TMOVIE_CREATOR);
                duration = Integer.parseInt(resultSet.getString(TMOVIE_DURATION));
                year = Short.parseShort(resultSet.getString(TMOVIE_YEAR));
                movie = new Movie(title, genre, creator, duration, year);
                movie.setId(Integer.parseInt(resultSet.getString(TMOVIE_ID)));
                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movies;
    }

    private boolean isViewed() {
        return false;
    }
}
