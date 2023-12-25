package com.Main.tarotreader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class History {
    //History file handling
    private char UserName= ' ';
    private String UserHistory;
    private String HistoryFile = "History.csv";
    private String HistoryFileHeader = "UserName, Draw[NbOfDraw,NbOfCards,[Draw1[[Card1,LuckRatio1],[Card2,LuckRatio2],...,[CardNbOfCards,LuckRatioNbOfCards]],...,[DrawNbOfDraw[[Card1,LuckRatio1],[Card2,LuckRatio2],...,[CardNbOfCards,LuckRatioNbOfCards]]";
    private int HistoryFileHeaderLength = 1;
    private String HistoryFileSeparator = ",";
    private String HistoryFileNewLine = "\n";

    
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
}