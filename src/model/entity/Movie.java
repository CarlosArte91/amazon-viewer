package model.entity;

import java.util.ArrayList;
import java.util.Date;

public class Movie extends Film implements IVisualizable {
    private int id;
    private int timeViewed;

    public Movie(String title, String gener, String creator, int duration, short year) {
        super(title, gener, creator, duration);
        setYear(year);
    }

    public int getId() {
        return id;
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
                "\nGener: " + getGener() +
                "\nYear: " + getYear() +
                "\nCreator: " + getCreator() +
                "\nDuration: " + getDuration();
    }

    @Override
    public Date startToSee(Date dateI) {
        return dateI;
    }

    @Override
    public void stopToSee(Date dateI, Date dateF) {
        if (dateF.getTime() > dateI.getTime()) {
            setTimeViewed((int) (dateF.getTime() - dateI.getTime()));
        } else {
            setTimeViewed(0);
        }
    }

    @Override
    public void view() {
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
        ArrayList<Movie> movies = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int item = i + 1;
            movies.add(new Movie(
                    "Movie " + item,
                    "Gener " + item,
                    "Creator " + item,
                    120 + item,
                    (short) (2017 + item)
            ));
        }
        return movies;
    }
}
