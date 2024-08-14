import model.entity.*;
import util.Input;

import java.util.ArrayList;

/**
 * <h1>Amazon Viewer</h1>
 * It is a program that allows you to watch movies and series with their respective episodes,
 * as well as books and magazines. It also allows you to generate general and daily reports.
 * <p></p>
 * There are some rules, such as; All items can be watched or read except for magazines, as
 * these can only be viewed.
 *
 * @author carlos_cruz
 * @version 1.1
 * @since 2024
 */
public class Application {
    public static ArrayList<Movie> movies = Movie.makeList();
    public static ArrayList<Serie> series = Serie.makeList();
    public static ArrayList<Book> books = Book.makeList();
    public static ArrayList<Magazine> magazines = Magazine.makeList();

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        int exit = 0;
        do {
            System.out.println("WELCOME TO AMAZON VIEWER");
            System.out.println("\nSelect the wish option");
            System.out.println("1. Movies");
            System.out.println("2. Series");
            System.out.println("3. Books");
            System.out.println("4. Magazines");
            System.out.println("5. Report");
            System.out.println("6. Report today");
            System.out.println("0. Exit");

            int response = Input.validateInput(0, 6);

            switch (response) {
                case 1:
                    showMovies();
                    break;
                case 2:
                    showSeries();
                    break;
                case 3:
                    showBooks();
                    break;
                case 4:
                    showMagazines();
                    break;
                case 5:
                    System.out.println("Make report");
                    break;
                case 6:
                    System.out.println("Make report today");
                case 0:
                    exit = 0;
                    break;
                default:
                    System.out.println("\n¡Choise one option!\n");
                    break;
            }
        } while (exit != 0);
    }

    public static void showMovies() {
        int exit = 1;
        int item;

        do {
            System.out.println("\n:: MOVIES ::\n");
            item = 1;

            for (Movie movie : movies) {
                System.out.println(item + ". " + movie.getTitle() + " --> viewed: " + movie.getIsViewed());
                item++;
            }

            System.out.println("0. Back to menu\n");

            int response = Input.validateInput(0, movies.size());

            if (response == 0) {
                exit = 0;
                showMenu();
                break;
            }

            if (response > 0) {
                Movie movieSelected = movies.get(response - 1);
                movieSelected.view();
            }
        } while (exit != 0);
    }

    public static void showSeries() {
        int exit = 1;

        do {
            System.out.println("\n:: SERIES ::\n");

            for (int i = 0; i < series.size(); i++) {
                Serie serie = series.get(i);
                System.out.println((i + 1) + ". " + serie.getTitle() + " Viewed: " + serie.getIsViewed());
            }

            System.out.println("0. Back to menu\n");

            int response = Input.validateInput(0, series.size());

            if (response == 0) {
                exit = 0;
                showMenu();
                break;
            }

            if (response > 0) {
                showChapters(series.get(response - 1).getChapters());
            }
        } while (exit != 0);
    }

    public static void showChapters(ArrayList<Chapter> chaptersOfSerieSelected) {
        int exit = 1;

        do {
            System.out.println("\n:: CHAPTERS ::\n");

            for (int i = 0; i < chaptersOfSerieSelected.size(); i++) {
                Chapter chapter = chaptersOfSerieSelected.get(i);
                System.out.println((i + 1) + ". " + chapter.getTitle() + " Viewed: " + chapter.getIsViewed());
            }

            System.out.println("0. Back to menu\n");

            int response = Input.validateInput(0, chaptersOfSerieSelected.size());

            if (response == 0) {
                exit = 0;
            }

            if (response > 0) {
                Chapter chapterSelected = chaptersOfSerieSelected.get(response - 1);
                chapterSelected.view();
            }
        } while (exit != 0);
    }

    public static void showBooks() {
        int exit = 1;

        do {
            System.out.println("\n:: BOOKS ::\n");

            for (int i = 0; i < books.size(); i++) {
                Book book = books.get(i);
                System.out.println((i + 1) + ". " + book.getTitle() + " Viewed: " + book.getIsReaded());
            }

            System.out.println("0. Back to menu\n");

            int response = Input.validateInput(0, books.size());

            if (response == 0) {
                exit = 0;
                showMenu();
                break;
            }

            if (response > 0) {
                Book bookSelected = books.get(response - 1);
                bookSelected.view();
            }
        } while (exit != 0);
    }

    public static void showMagazines() {
        int exit = 1;

        do {
            System.out.println("\n:: MAGAZINES ::\n");

            for (int i = 0; i < magazines.size(); i++) {
                Magazine magazine = magazines.get(i);
                System.out.println((i + 1) + ". " + magazine.getTitle());
            }

            System.out.println("0. Back to menu\n");

            int response = Input.validateInput(0, magazines.size());

            if (response == 0) {
                exit = 0;
                showMenu();
                break;
            }
        } while (exit != 0);
    }
}
