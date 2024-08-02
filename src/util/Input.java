package util;

import java.util.Scanner;

public class Input {
    public static int validateInput(int min, int max) {
        Scanner reader = new Scanner(System.in);

        while (!reader.hasNextInt()) {
            reader.next();
            System.out.println("Invalid option\nTry again");
        }

        int response = reader.nextInt();

        while (response < min || response > max) {
            System.out.println("Invalid option\nTry again");

            while (!reader.hasNextInt()) {
                reader.next();
                System.out.println("Invalid option\nTry again");
            }

            response = reader.nextInt();
        }

        System.out.println("You choise " + response + "option\n");
        return response;
    }
}
