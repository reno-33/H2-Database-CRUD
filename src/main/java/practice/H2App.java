package practice;

import java.sql.SQLException;
import java.util.Scanner;

public class H2App {

    public static void main(String[] args) throws SQLException {
        showMenu();

    }

    /**
     * Show the menu
     */
    public static void showMenu() throws SQLException {
        boolean quit = false;
        System.out.println("Welcome");
        int userChoice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Choose what you want to do!");
            System.out.println("1. Create new table");
            System.out.println("2. Insert into table");
            System.out.println("3. Update data");
            System.out.println("4. Delete data");
            System.out.println("0. Quit");

            userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1:
                    Controller.createTable();
                    break;
                case 2:
                    System.out.println("Inserting into table\n");
                    break;
                case 3:
                    System.out.println("Updating data\n");
                    break;
                case 4:
                    System.out.println("Delete data\n");
                    break;
                case 0:
                    System.out.println("Qutting...\n");
                    quit = true;
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
        } while(!quit);
        scanner.close();
    }
}
