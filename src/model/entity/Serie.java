package model.entity;

import java.util.ArrayList;

public class Serie extends Film {
    private int id;
    private int sessionQuantity;
    private ArrayList<Chapter> chapters;

    public Serie(String title, String gener, String creator, int duration, int sessionQuantity) {
        super(title, gener, creator, duration);
        this.sessionQuantity = sessionQuantity;
    }

    public int getId() {
        return id;
    }

    public int getSessionQuantity() {
        return sessionQuantity;
    }

    public void setSessionQuantity(int sessionQuantity) {
        this.sessionQuantity = sessionQuantity;
    }

    public ArrayList<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(ArrayList<Chapter> chapters) {
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        return "\n:: SERIE ::" +
                "\nTitle: " + getTitle() +
                "\nGener: " + getGener() +
                "\nYear: " + getYear() +
                "\nCretor: " + getCreator() +
                "\nDuration: " + getDuration();
    }

    @Override
    public void view() {}

    public static ArrayList<Serie> makeList() {
        ArrayList<Serie> series = new ArrayList<>();
        Serie serie;

        for (int i = 0; i < 5; i++) {
            int item = i + 1;
            serie = new Serie(
                    "Serie ",
                    "Gener ",
                    "Creator ",
                    300 + item,
                    (short) (2011 + item)
            );
            serie.setChapters(Chapter.makeList(serie));
            series.add(serie);
        }
        return series;
    }
}
