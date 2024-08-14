package model.entity;

import model.dao.MovieDao;

import java.util.ArrayList;
import java.util.Date;

/**
 * It inherits from {@link Film}
 * It implements {@link IVisualizable}
 */
public class Movie extends Film implements IVisualizable, MovieDao {
    private int id;
    private int timeViewed;

    public Movie() {}

    public Movie(String title, String gener, String creator, int duration, short year) {
        super(title, gener, creator, duration);
        setYear(year);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTimeViewed() {
        return timeViewed;
    }

    public void setTimeViewed(int timeViewed) {
        this.timeViewed = timeViewed;
    }

    @Override
    public String toString() {
        return "\n:: MOVIE ::" +
                "\nTitle: " + getTitle() +
                "\nGener: " + getGenre() +
                "\nYear: " + getYear() +
                "\nCreator: " + getCreator() +
                "\nDuration: " + getDuration();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date startToSee(Date dateI) {
        return dateI;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stopToSee(Date dateI, Date dateF) {
        if (dateF.getTime() > dateI.getTime()) {
            setTimeViewed((int) (dateF.getTime() - dateI.getTime()));
        } else {
            setTimeViewed(0);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void view() {
        Movie movie = new Movie();
        movie.setToViewed(this);
        setIsViewed(true);
        Date dateI = startToSee(new Date());
        stopToSee(dateI, new Date());

        for (int i = 0;i < 1000; i++) {
            System.out.println("...........................");
        }

        System.out.println("\nYou viewed: " + toString());
        System.out.println("By: " + getTimeViewed() + "seconds");
    }

    public static ArrayList<Movie> makeList() {
        Movie movie = new Movie();
        return movie.read();
    }
}
