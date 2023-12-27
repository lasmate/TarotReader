package com.Main.tarotreader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utillities {
    
    private static String[] CardBank;

    public static void main(String[] args) {
        try {
            getTarotNames();
            System.out.println("Tarot Names: " + String.join(", ", CardBank));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void getTarotNames() throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("../../../crud/parse_json");
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
        return CardBank;
    }
}
   

