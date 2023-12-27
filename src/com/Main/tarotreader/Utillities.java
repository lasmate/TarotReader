package com.Main.tarotreader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utillities {
    
    private static String[] CardBank;
    /**
     * Gets the card names from the parse_json executable.
     * 
     * @throws IOException
     * @throws InterruptedException
     */
    private static void getTarotNames() throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("../../../crud/parse_json.ml");
        Process process = processBuilder.start();
        process.waitFor(); //wait for the process to finish

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line = reader.readLine();
            if (line != null) {
                CardBank = line.split(",");
            } else {
                CardBank = new String[0]; // Empty array if no names are found
            }

        }
    }
    public static String[] getCardBank() {
        try {
            getTarotNames();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return CardBank;
    }
    /**
     * Gets the card meanings from the parse_json executable.
     * 
     * @throws IOException
     * @throws InterruptedException
     */
    private static void getTarotMeanings() throws IOException, InterruptedException { //TODO: Implement this method cuz this is a simple copypaste 4nyauw
        ProcessBuilder processBuilder = new ProcessBuilder("../../../crud/parse_json.ml");
        Process process = processBuilder.start();
        process.waitFor(); //wait for the process to finish

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line = reader.readLine();
            if (line != null) {
                CardBank = line.split(",");
            } else {
                CardBank = new String[0]; // Empty array if no names are found
            }

        }
    }
    public static String[] getCardMeanings() {//TODO: Implement this method cuz this is a simple copypaste 4nyauw
        try {
            getTarotMeaning();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return CardMeaning;
    }


    /**
     * CheckHistory method checks if the user has a field in the history file and returns the user history
     * 
     * @param UserName
     * @return String representing the user history
     */
    public String CheckHistory(char UserName) {
        return "";
    }
    /**
     * AddDraw method adds the draw to the history file
     * 
     * @param Draw
     * @param UserName
     * @param HistoryFileLine
     */
    public void AddDraw(int[][] Draw, char UserName, int HistoryFileLine) {
        
    
    
    }



}
   

