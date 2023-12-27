package com.Main.tarotreader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class History {
    //History file handling
    
    private String UserHistory;
    private String HistoryFile = "History.csv";
    private String HistoryFileHeader = "UserName, Draw[NbOfDraw,NbOfCards,[Draw1[[Card1,LuckRatio1],[Card2,LuckRatio2],...,[CardNbOfCards,LuckRatioNbOfCards]],...,[DrawNbOfDraw[[Card1,LuckRatio1],[Card2,LuckRatio2],...,[CardNbOfCards,LuckRatioNbOfCards]]";
    private int HistoryFileHeaderLine = 0;
    private int HistoryFileTempLine= 1;

    
    /**
     * GetUserHistory method looks up the user name in the history file  by calling an OcamL function named  Historylookup in the file named DataMgmt.ml and returns the user history in the form of a list of list of tuple of integers.
     * @param UserName
     * @return String representing the user history
     */
    public String GetUserHistory(char UserName) {
        try {
            ProcessBuilder pb = new ProcessBuilder("ocaml", "DataMgmt.ml", String.valueOf(UserName));
            Process p = pb.start();
    
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                // Parse the output line and add it to the result
                // This depends on the format of your OCaml function's output
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return UserHistory;
    }

    /**
     * AddDrawTemp method adds the draw to temp line in the history file by calling the method AddDraw in the Utilities class
     * @param Draw
     * @param UserName
     */
    public void AddDrawTemp(int[][] Draw){


    }

    /**
     * AddDrawToUserHistory method adds the draw to history by calling the method CheckHistory in the Utilities class to check if the user already has a history and then calls the method AddDraw in the Utilities class to add the draw to the history file
     * 
     * @param UserName
     * 
     */
    public void AddDrawToUserHistory(char UserName){
        



}