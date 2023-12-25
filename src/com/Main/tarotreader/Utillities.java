package com.Main.tarotreader;


public class Utillities {
    //cards DB
    private char CardName = ' ';
    private char CardMeaning = ' ';
    private char[] CardInfo = new char[2];
    private int CardNumber= 0;
    private int LuckRatio = 0;
    //users DB
    private int ReservedLine = 0;
    private char UserName = ' ';
    private int[] UserDrawHistory;

    /**
     * Gets the card's name and meaning by calling an OcamL function to parse a CSV database.
     * @param CardNumber The number of the card to retrieve information for.
     * @param LuckRatio the specific card's luck ratio.
     * @return The card's name and meaning.
     */
    public char[]  CardInfoRetrieve(int CardNumber, int LuckRatio) {

        return CardInfo;


    }

    /**
     * Looks up the user's name in the database using an OCamL function and returns the contents of the line where it is stored. stores the content of the line in a list of list of tuples of integers.
     * 
     * @param ReservedLine The line in the database where the is NEVER stored.
     * @param UserName The user's name.
     * @return The contents of the line where the user's name is stored.
     */
    public int[] UserRetrieve(int ReservedLine, char UserName) {

        
        return UserDrawHistory;
    }

}
