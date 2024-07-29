package model.entity;

import java.util.ArrayList;

public class Serie extends Film {
    private int id;
    private int sessionQuantity;

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

    @Override
    public String toString() {
        return "\n:: SERIE ::" +
                "\nTitle: " + getTitle() +
                "\nGener: " + getGener() +
                "\nYear: " + getYear() +
                "\nCretor: " + getCreator() +
                "\nDuration: " + getDuration();
    }

    public static ArrayList<Serie> makeList() {
        ArrayList<Serie> series = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int item = i + 1;
            series.add(new Serie(
                    "Serie ",
                    "Gener ",
                    "Creator ",
                    300 + item,
                    (short) (2011 + item)
            ));
        }
        return series;
    }
}
