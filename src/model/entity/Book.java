package model.entity;

import util.Input;

import java.util.ArrayList;
import java.util.Date;

public class Book extends Publication implements IVisualizable {
    private int id;
    private String isbn;
    private boolean isReaded;
    private int timeReaded;
    private ArrayList<Page> pages;

    public Book(String title, Date edititionDate, String editorial, String[] authors, ArrayList<Page> pages) {
        super(title, edititionDate, editorial);
        setAuthors(authors);
        setPages(pages);
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

    public ArrayList<Page> getPages() {
        return pages;
    }

    public void setPages(ArrayList<Page> pages) {
        this.pages = pages;
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

        int i = 0;
        Page page;

        do {
            page = getPages().get(i);
            System.out.println(".........................");
            System.out.println("Page " + page.getNumber());
            System.out.println(page.getContent());
            System.out.println(".........................");

            if (i != 0) {
                System.out.println("1. Back page");
            }

            System.out.println("2. Next page");
            System.out.println("0. Close book\n");

            int response = Input.validateInput(0, 2);

            if (response == 2) {
                i++;
            } else if (response == 1) {
                i--;
            } else if (response == 0) {
                break;
            }
        } while (i < getPages().size());

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
        ArrayList<Page> pages = new ArrayList<>();
        String[] authors = new String[3];

        for (int i = 0; i < authors.length; i++) {
            authors[i] = "author " + (i + 1);
        }

        for (int i = 0; i < 5; i++) {
            pages.add(new Page((i + 1), "xxxxxxxxxxxxxxxxxxxx\nContent of page " + (i + 1) + "\nxxxxxxxxxxxxxxxxxxxx"));
        }

        for (int i = 0; i < 5; i++) {
            books.add(new Book(
                    "Book " + (i + 1),
                    new Date(),
                    "Editorial " + (i + 1),
                    authors,
                    pages
            ));
        }

        return books;
    }

    public static class Page {
        private int id;
        private int number;
        private String content;

        public Page(int number, String content) {
            this.number = number;
            this.content = content;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
