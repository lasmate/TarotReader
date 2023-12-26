
package com.Main.tarotreader;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int selection=0;

        do {
            try{
                System.out.println("Please select an action:");
                System.out.println("1. Start a new draw");
                System.out.println("2. Load a user's draw history");
                System.out.println("3. Load last draw");
                System.out.println("4. Exit");

                selection = scanner.nextInt();

                switch (selection) {
                    case 1:
                        System.out.println("Starting a new draw...");

                        Draw draw = new Draw();
                        Display display = new Display();
                        System.out.println("The card your drew and their luck are as follows:");
                        draw.NewDraw();
                        System.out.println("The cards you drew are as follows:");
                        display.DisplayCard(draw.getLuckRatio());
                        
                        
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
            }catch (InputMismatchException e){
                System.out.println("Invalid selection. Please enter a correct number.");
                scanner.nextLine();
            }
        } while (selection != 4);

        scanner.close();
    }
}