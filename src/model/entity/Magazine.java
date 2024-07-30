package model.entity;

import java.util.ArrayList;
import java.util.Date;

public class Magazine extends Publication {
    private int id;

    public Magazine(String title, Date editionDate, String editorial) {
        super(title, editionDate, editorial);
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        String[] authors = getAuthors();

        StringBuilder detail = new StringBuilder(
                "\n:: MAGAZINE ::" +
                "\nTitle: " + getTitle() +
                "\nEditorial: " + getEditorial() +
                "\nEdition date: " + getEdititionDate() +
                "\nAuthors:\n"
        );

        for (String author : authors) {
            detail.append("\t").append(author).append("\n");
        }

        return detail.toString();
    }

    public static ArrayList<Magazine> makeList() {
        ArrayList<Magazine> magazines = new ArrayList<>();
        String[] authors = new String[3];
        Magazine magazine;

        for (int i = 0; i < authors.length; i++) {
            authors[i] = "author " + (i + 1);
        }

        for (int i = 0; i < 5; i++) {
            int item = i + 1;
            magazine = new Magazine("Magazine " + item, new Date(), "Editorial " + item);
            magazine.setAuthors(authors);
            magazines.add(magazine);
        }
        return magazines;
    }
}
