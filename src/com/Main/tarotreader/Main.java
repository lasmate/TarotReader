
package com.Main.tarotreader; // Replace com.example.tarotreader with your desired package name

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int selection;

        do {
            System.out.println("Please select an action:");
            System.out.println("1. Start a new draw");
            System.out.println("2. Load a puser's draw history");
            System.out.println("3. Load last draw");
            System.out.println("4. Exit");

            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("You selected Action 1");
                    // Call the method for Action 1 here
                    break;
                case 2:
                    System.out.println("You selected Action 2");
                    // Call the method for Action 2 here
                    break;
                case 3:
                    System.out.println("You selected Action 3");
                    // Call the method for Action 3 here
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        } while (selection != 4);

        scanner.close();
    }
}