package com.Main.tarotreader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class History {
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
        Utilities.AddDraw(Draw, UserName, HistoryFileTempLine);

    }

    /**
     * AddDrawToUserHistory method adds the draw to history.csv by calling the method CheckHistory in the Utilities class to check if the user already has a field in the history file and 
     * if yes : calls the method AddDraw in the Utilities class to add the draw to the user history
     * if no : calls the method AddFirstDraw in the Utilities class to create the user field in the history file and add the draw to the user history
     * 
     * @param UserName
     * 
     */
    public void AddDrawToUserHistory(char UserName){
        UserHistory = Utilities.CheckHistory(UserName);
        if (UserHistory.equals("")){
            Utilities.AddDraw(Draw, UserName, HistoryFileHeaderLine);
        }else{
            Utilities.AddDraw(Draw, UserName, HistoryFileTempLine);
        }

    }

}