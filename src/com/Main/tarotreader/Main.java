
package com.Main.tarotreader;


import java.io.IOException;
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
                        System.out.println("do you want to save this draw? \n 1:yes \n 2:no");
                        int save=0;
                        scanner.nextLine();
                        save = scanner.nextInt();
                        scanner.nextLine();
                        if (save == 1) {
                            System.out.println("Please enter your username");
                            String username = scanner.nextLine();
                        
                            // Pass the username to your history or draw-related methods
                            // For example, you can use it when saving the draw or retrieving user history.
                            history.AddDraw(username, draw.getLuckRatio());
                        
                            System.out.println("Draw saved successfully!");
                        } else {
                            System.out.println("Draw not saved.");
                        }
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
            }catch (InputMismatchException | IOException e){
                System.out.println("Invalid selection. Please enter a correct number.");
                scanner.nextLine();
            
            }
        } while (selection != 4);

        scanner.close();
    }
}