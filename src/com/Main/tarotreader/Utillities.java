package com.Main.tarotreader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Utillities {
    
    private static String[] NamedCardBank;
    private static String[] CardMeanings;
    private static String CaMeDBPath = "src/com/Main/tarotreader/Tarot-DB.json";

    /**
     * Gets the card names from the by parsing the json database.
     * 
     * 
     */
    public static void CreateNamedCardBank(){
        try{
            //read json file into a string
            String jsonContent = new String(Files.readAllBytes(Paths.get(CaMeDBPath)));
            List<String> NamesList = new ArrayList<String>();
            int Index=0;

            while (Index < jsonContent.length()) {
                //find the start and end of the "name" field
                int NameStart = jsonContent.indexOf("\"name\":", Index);
                if (NameStart == -1) {
                    break;
                }
                int nameValueStart = jsonContent.indexOf("\"", NameStart + 7)+1;
                int nameValueEnd = jsonContent.indexOf("\"", nameValueStart);
                //extract the name and add to the list
                String name = jsonContent.substring(nameValueStart, nameValueEnd);
                NamesList.add(name);
                Index = nameValueEnd+1;
            }
            NamedCardBank = NamesList.toArray(new String[0]);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * Retrieves the card bank from the TarotNames file and returns it as an array of strings.
     *
     * @return the card bank as an array of strings
     */
    public static String[] getNamedCardBank() {
        CreateNamedCardBank();
        return NamedCardBank;
    }

    /**
     * Retrieves the meanings of a tarot card based on its card number.
     * 
     * @param cardNumber The card number of the tarot card.
     * @return An array of strings representing the meanings of the tarot card.
     * @throws IOException
     */
    public static String[] getCardMeanings(String cardName) throws IOException {//no checks for accurate card name since created from db not from user 
        // Check if CardBank is not initialized or empty
        if (NamedCardBank == null || NamedCardBank.length == 0) {
            CreateNamedCardBank();
        }
        ExtractMeaningsForNamedCard(cardName, new String(Files.readAllBytes(Paths.get(CaMeDBPath))));
         //System.out.println(Arrays.toString(CardMeanings));debug
        return CardMeanings;

    
    }
   

    /**
     * Extracts the meanings of a tarot card from the json database.
     * 
     * @param cardName The name of the tarot card.
     * @param jsonContent The json database content.
     */
    private static void ExtractMeaningsForNamedCard(String cardName, String jsonContent) {
        try {
            // Find the starting index of the "meanings" field for the specified card
            int cardIndex = jsonContent.indexOf(cardName);
    
            if (cardIndex != -1) {
                // Find the starting index of the "light" and "shadow" arrays within the "meanings" field
                int lightStart = jsonContent.indexOf("\"light\":", cardIndex);
                int shadowStart = jsonContent.indexOf("\"shadow\":", cardIndex);
    
                // Find the ending indices of the "light" and "shadow" arrays
                int lightEnd = jsonContent.indexOf("]", lightStart);
                int shadowEnd = jsonContent.indexOf("]", shadowStart);
    
                // Extract the "light" and "shadow" arrays from the JSON content
                String lightArray = jsonContent.substring(lightStart + "\"light\":".length(), lightEnd + 1);
                String shadowArray = jsonContent.substring(shadowStart + "\"shadow\":".length(), shadowEnd + 1);
    
                // Split the arrays into individual meanings and clean up unnecessary characters
                String[] lightMeanings = lightArray.split("\",\"?");
                String[] shadowMeanings = shadowArray.split("\",\"?");
    
                // Combine "light" and "shadow" meanings into a single array
                String[] combinedMeanings = new String[lightMeanings.length + shadowMeanings.length];
                System.arraycopy(lightMeanings, 0, combinedMeanings, 0, lightMeanings.length);
                System.arraycopy(shadowMeanings, 0, combinedMeanings, lightMeanings.length, shadowMeanings.length);
    
                // Assign the combined meanings array to your desired variable
                CardMeanings = combinedMeanings;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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


    /**
     * AddFirstDraw method creates the user field in the history file and adds the draw to the user history
     * 
     * @param Draw
     * @param UserName
     * @param HistoryFileTempLine
     */
    public void AddFirstDraw(int[][] draw, char userName, int historyFileTempLine) {
        
    }



}
   

