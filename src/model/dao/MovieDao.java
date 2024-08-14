package model.dao;

import static constants.DataBase.*;
import db.IDBConnection;
import model.entity.Movie;

import java.sql.*;
import java.util.ArrayList;

public interface MovieDao extends IDBConnection {
    default void setToViewed(Movie movie) {
        String query = "INSERT INTO " + TVIEWED + " (id_material, id_element, id_user) VALUES (?, ?, ?)";
        try (Connection connection = connectToDB()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, ID_MATERIALS[0]);
            statement.setInt(2, movie.getId());
            statement.setInt(3, USER_DEFAULT);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    default ArrayList<Movie> read() {
        ArrayList<Movie> movies = new ArrayList<>();
        Movie movie;
        String title;
        String genre;
        String creator;
        int duration;
        short year;

        String query = "SELECT * FROM " + TMOVIE;
        try (Connection connection = connectToDB()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int movieId = Integer.parseInt(resultSet.getString(TMOVIE_ID));
                title = resultSet.getString(TMOVIE_TITLE);
                genre = resultSet.getString(TMOVIE_GENRE);
                creator = resultSet.getString(TMOVIE_CREATOR);
                duration = Integer.parseInt(resultSet.getString(TMOVIE_DURATION));
                year = Short.parseShort(resultSet.getString(TMOVIE_YEAR));
                movie = new Movie(title, genre, creator, duration, year);
                movie.setId(movieId);
                movie.setIsViewed(isViewed(connection, movieId));
                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movies;
    }

    private boolean isViewed(Connection connection, int movieId) {
        boolean viewed = false;
        String query = "SELECT * FROM " + TVIEWED +
                " WHERE " + TVIEWED_ID_MATERIAL + " = ? AND " + TVIEWED_ID_ELEMENT + " = ? AND " + TVIEWED_ID_USER + " = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, ID_MATERIALS[0]);
            statement.setInt(2, movieId);
            statement.setInt(3, USER_DEFAULT);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                viewed = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return viewed;
    }
}
