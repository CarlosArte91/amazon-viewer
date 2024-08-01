package model.entity;

import java.util.ArrayList;
import java.util.Date;

public class Book extends Publication implements IVisualizable {
    private int id;
    private String isbn;
    private boolean isReaded;
    private int timeReaded;

    public Book(String title, Date edititionDate, String editorial, String[] authors) {
        super(title, edititionDate, editorial);
        setAuthors(authors);
    }

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean getIsReaded() {
        return isReaded;
    }

    public void setIsReaded(boolean isReaded) {
        this.isReaded = isReaded;
    }

    public int getTimeReaded() {
        return timeReaded;
    }

    public void setTimeReaded(int timeReaded) {
        this.timeReaded = timeReaded;
    }

    public String verifyState() {
        String state = "";
        if (isReaded) {
            state = "Yes";
        } else {
            state = "No";
        }
        return state;
    }

    public void view() {
        setIsReaded(true);
        Date dateI = startToSee(new Date());
        stopToSee(dateI, new Date());

        for (int i = 0;i < 1000; i++) {
            System.out.println("...........................");
        }

        System.out.println("\nYou viewed: " + toString());
        System.out.println("By: " + getTimeReaded() + "seconds");
    }

    @Override
    public String toString() {
        String[] authors = getAuthors();
        StringBuilder detail = new StringBuilder("\n:: Book ::" +
                "\nTitle: " + getTitle() +
                "\nEditorial: " + getEditorial() +
                "\nEdition date: " + getEdititionDate() +
                "\nAuthors: \n");

        for (String author : authors) {
            detail.append("\t").append(author).append("\n");
        }
        return detail.toString();
    }

    @Override
    public Date startToSee(Date dateI) {
        return dateI;
    }

    @Override
    public void stopToSee(Date dateI, Date dateF) {
        if (dateF.getTime() > dateI.getTime()) {
            setTimeReaded((int) (dateF.getTime() - dateI.getTime()));
        } else {
            setTimeReaded(0);
        }

    }

    public static ArrayList<Book> makeList() {
        ArrayList<Book> books = new ArrayList<>();
        String[] authors = new String[3];

        for (int i = 0; i < authors.length; i++) {
            authors[i] = "author " + (i + 1);
        }

        for (int i = 0; i < 5; i++) {
            books.add(new Book(
                    "Book " + (i + 1),
                    new Date(),
                    "Editorial " + (i + 1),
                    authors
            ));
        }

        return books;
    }
}
