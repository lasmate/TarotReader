package com.Main.tarotreader;

public class Display {
    private int CardsToDisplay = 0;
    private char[] DisplayedCard= new char[2];
    private String[][] CardBank;

    /**
     * Calls a method called CardInfoRetrieve(int cardNumber, int LuckRatio) from the Utilities class.
     * this method will retrieve the card's name and meaning from the database.
     * and then store them in the CardName and CardMeaning variables.
     * 
     * @param CardNumber The number of the card to retrieve information for.
     * @param LuckRatio the specific card's luck ratio.
     **/
    public void GetCardInfo(int CardNumber, int LuckRatio) {//to complete 
        Utillities utillities = new Utillities();
        char[] CardInfo = utillities.CardInfoRetrieve(CardNumber, LuckRatio);
        this.CardName = CardInfo[0];
        this.CardMeaning = CardInfo[1];
    }

    /**
     * Displays the card's number and luck ratio.
     * 
     * @param LuckRatio The array containing the card's number and luck ratio.
     * 
     **/
    public void DisplayCard(int[][] LuckRatio ) {
        for (int i = 0; i < LuckRatio.length; i++) {
            System.out.println("Card " + (i + 1) + ": " + LuckRatio[i][0] + " " + LuckRatio[i][1]);
        }

    }

    /**
     * Displays the card's name and meaning.
     * 
     * @param int[][] LuckRatio
     * @param String[][] CardBank
     */
    public void DisplayCardInfo(int[][] LuckRatio, String[][] CardBank) {
        for (int i = 0; i < LuckRatio.length; i++) {
            System.out.println("Card " + (i + 1) + ": " + CardBank[LuckRatio[i][0]][0] + " "
                    + CardBank[LuckRatio[i][1]][1]);
        }

}
