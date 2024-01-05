package com.Main.tarotreader;

import java.io.IOException;

public class Display {
    private String[] CardBank;
    private String[] CardMeaning;

    /**
     * Retrieves the card name from the CardBank array by using the int provided by the LuckRatio array.
     * 
     *  @param LuckRatio The array containing the card's number and luck ratio.
     *  
     **/
    public String GetCardName(int CardNumber){
        CardBank = Utillities.getNamedCardBank();
        return CardBank[CardNumber];

    }
    public String GetCardMeaning(int CardNumber , int LuckRatio) throws IOException{
        CardMeaning = Utillities.getCardMeanings(CardBank[CardNumber]);
        
        return CardMeaning[LuckRatio];

    }

    /**
     * Displays the card's number and card name only.
     * 
     * @param LuckRatio The array containing the card's number and luck ratio.
     * 
     **/
    public void DisplayCardsSimple(int[][] LuckRatio) {
        for (int i = 0; i < LuckRatio.length; i++) {
            System.out.println("Card " + LuckRatio[i][0] + ": " + GetCardName(LuckRatio[i][0])+"\n"); 
        }
    }

    /**
     * Displays all the drawn cards names and selected meaning.
     * 
     * @param int[][] LuckRatio
     * @throws IOException
     * 
     */
    public void DisplayCardsFull(int[][] LuckRatio) throws IOException {
        for (int i = 0; i < LuckRatio.length; i++) {
            System.out.println("Card " + LuckRatio[i][0] + ": " + GetCardName(LuckRatio[i][0]) + "\n" + "Meaning: " + GetCardMeaning(LuckRatio[i][0],LuckRatio[i][0]) + "\n");
        }
    }
}
