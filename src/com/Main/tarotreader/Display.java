package com.Main.tarotreader;

public class Display {
    private int CardsToDisplay = 0;
    private char[] DisplayedCard= new char[2];
    private char CardName = ' ';
    private char CardMeaning = ' ';

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
     * Displays the card's name and meaning.
     * 
     * @param CardNumber The number of the card to display.
     * @param LuckRatio the specific card's luck ratio.
     * @param CardsToDisplay The number of cards to display.
     **/
    public void DisplayCard(int CardNumber, int LuckRatio, int CardsToDisplay) {
        this.CardsToDisplay = CardsToDisplay;
        while (this.CardsToDisplay > 0) {
            GetCardInfo(CardNumber, LuckRatio);
            this.DisplayedCard[0] = this.CardName;
            this.DisplayedCard[1] = this.CardMeaning;
            System.out.println("you drew the " + this.DisplayedCard[0] + " card, and this time it took the meaning : " + this.DisplayedCard[1] + "");
            this.CardsToDisplay--;
        }
    }
}
