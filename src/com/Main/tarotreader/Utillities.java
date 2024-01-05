package com.Main.tarotreader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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

        // Check if CardMeanings is not initialized or empty
        if (CardMeanings == null || CardMeanings.length == 0) {
            ExtractMeaningsForNamedCard(cardName, new String(Files.readAllBytes(Paths.get(CaMeDBPath))));
        }

        // Convert cardName to lowercase for case-insensitive comparison
        cardName = cardName.toLowerCase();

        
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
            //find the good card to extract the meanings from
            int cardIndex = jsonContent.indexOf("\"name\":\"" + cardName + "\"");
            if (cardIndex == -1) {//useless check since cardName is created from the db but just in case and/or later implementation
                throw new IllegalArgumentException("Invalid card name. Please try again.");
            }
            // Find the starting index of the "meanings" field for the specified card
            int meaningsStart = jsonContent.indexOf("\"meanings\"",cardIndex);

            // Find the starting and ending indices of the "meanings" value
            int meaningsValueStart = jsonContent.indexOf("{", meaningsStart);
            int meaningsValueEnd = jsonContent.indexOf("}", meaningsValueStart);

            // Extract the "meanings" value from the JSON content
            String meaningsValue = jsonContent.substring(meaningsValueStart + 1, meaningsValueEnd);

            // Split the "meanings" value into an array of strings
            String[] meaningsArray = meaningsValue.split(",");
            List<String> lightMeanings = new ArrayList<>();
            List<String> shadowMeanings = new ArrayList<>();

            // Iterate through the "meanings" array to separate "light" and "shadow" subfields
            for (String meaning : meaningsArray) {
                if (meaning.contains("\"light\"")) {
                    // Extract values for the "light" subfield
                    extractSubfieldValues(meaning, lightMeanings);
                } else if (meaning.contains("\"shadow\"")) {
                    // Extract values for the "shadow" subfield
                    extractSubfieldValues(meaning, shadowMeanings);
                }
            }
            // Limit the number of meanings to 5 for both "light" and "shadow"
            lightMeanings = lightMeanings.subList(0, Math.min(5, lightMeanings.size()));
            shadowMeanings = shadowMeanings.subList(0, Math.min(5, shadowMeanings.size()));

            // Combine "light" and "shadow" meanings into a single list
            List<String> combinedMeanings = new ArrayList<>(lightMeanings);
            combinedMeanings.addAll(shadowMeanings);


            // Convert the list to an array
            CardMeanings = combinedMeanings.toArray(new String[0]);

    } catch (Exception e) {
        e.printStackTrace();}
    }

    // Helper method to extract values from a "light" or "shadow" subfield
    private static void extractSubfieldValues(String subfield, List<String> meaningsList) {
        // Split the subfield into key and value
        String[] subfieldArray = subfield.split(":");
        // Extract the value and trim unnecessary characters
        String subfieldValue = subfieldArray[1].trim();
        // Remove quotes and trailing comma
        subfieldValue = subfieldValue.substring(1, subfieldValue.length() - 2);
        // Add the extracted value to the meanings list
        meaningsList.add(subfieldValue);
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
   

