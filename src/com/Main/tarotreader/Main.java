
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
                History history = new History();
                switch (selection) {
                    case 1:
                        System.out.println("Starting a new draw...");

                        Draw draw = new Draw();
                        Display display = new Display();
                        System.out.println("The card your drew and their luck are as follows:");
                        draw.NewDraw();
                        System.out.println("The cards you drew are as follows:");
                        display.DisplayCardsSimple(draw.getLuckRatio());
                        System.out.println("The cards you drew and their meanings are as follows:");
                        display.DisplayCardsFull(draw.getLuckRatio());
                        System.out.println("do you want to save this draw? (y/n)");
                        String save = scanner.next();
                        
                        if (save.equals("y")){
                            System.out.println("Please enter your username");
                            char username = scanner.next().charAt(0);
                            
                            history.AddDraw(username, draw.getLuckRatio());
                        };
                        history.AddDrawTemp(draw.getLuckRatio());
                        
                        break;
                    case 2:
                        System.out.println("Loading a user's draw history...");
                        System.out.println("Please enter your username");
                        //char username = scanner.next().charAt(0);
                        //history.LoadDraw(username);

                        
                        

                        break;
                    case 3:
                        System.out.println("Loading the last draw...");
                        

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