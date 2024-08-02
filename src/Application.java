import model.entity.Movie;
import model.entity.Serie;
import util.Input;

import java.util.ArrayList;

public class Application {
    public static ArrayList<Movie> movies = Movie.makeList();
    public static ArrayList<Serie> series = Serie.makeList();

    public static void main(String[] args) {
        System.out.println("Access point");
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
                    System.out.println("Show movies");
                    break;
                case 2:
                    System.out.println("Show series");
                    break;
                case 3:
                    System.out.println("Show books");
                    break;
                case 4:
                    System.out.println("Show magazines");
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

        do {
            System.out.println("\n:: MOVIES ::\n");

            for (int i = 0; i < movies.size(); i++) {
                Movie movie = movies.get(i);
                System.out.println((i + 1) + ". " + movie.getTitle() + " Viewed: " + movie.getIsViewed());
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
}
