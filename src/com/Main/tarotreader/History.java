package com.Main.tarotreader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class History {
    //History file handling
    
    private String UserHistory;
    
    private String HistoryFileHeader = "UserName, Draw[NbOfDraw,NbOfCards,[Draw1[[Card1,LuckRatio1],[Card2,LuckRatio2],...,[CardNbOfCards,LuckRatioNbOfCards]],...,[DrawNbOfDraw[[Card1,LuckRatio1],[Card2,LuckRatio2],...,[CardNbOfCards,LuckRatioNbOfCards]]";
    private int HistoryFileHeaderLine = 0;
    private int HistoryFileTempLine= 1;

    
    /**
     * GetUserHistory method looks up the user name in the history file by calling the method checkhistory in the Utilities class and returns the user history
     * 
     * @param UserName
     * @return String representing the user history
     */
    public String GetUserHistory(char UserName) {
        UserHistory = Utilities.CheckHistory(UserName);
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

}