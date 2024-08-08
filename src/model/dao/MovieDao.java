package model.dao;

import model.entity.Movie;

import java.util.ArrayList;

public interface MovieDao {
    default Movie setToViewed(Movie movie) {
        return movie;
    }

    default ArrayList<Movie> read() {
        ArrayList<Movie> movies = new ArrayList<>();
        return movies;
    }

    private boolean isViewed() {
        return false;
    }
}
