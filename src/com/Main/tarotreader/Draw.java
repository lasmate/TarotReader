package com.Main.tarotreader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Draw {
    private int BaseDraw = 3;
    private int AdditionalDraw = 0;
    private int TotalDraw = 0;
    private int CardsInDeck = 78;// might rename this variable to DeckSize for improved clarity
    
    private int[] DrawnCards = new int[TotalDraw];

    public Draw() {// Default constructor
        this.BaseDraw = 3;
        this.AdditionalDraw = 0;
        this.TotalDraw = 0;
    }

    public int getCardsInDeck() {
        return this.CardsInDeck;
    }
    public int setCardsInDeck(int cardsInDeck) {  // this setter is not used yet but is here to be able to retro fin the function of creating a userdefined decksize 
        this.CardsInDeck = cardsInDeck;
        return this.CardsInDeck;
    }
    
    /**
     * Creates a list of integers representing the cards in the deck.
     *
     * @return A list of integers representing the cards in the deck.
     */
    public List<Integer> createCardList() {
        List<Integer> cardList = new ArrayList<>();
        for (int i = 0; i < this.CardsInDeck; i++) {
            cardList.add(i);
        }
        return cardList;
    }
    

    /**
     * Prompts the user to input the number of additional cards they would like to draw,
     * between 0 and 3, and updates the total number of cards to be drawn accordingly.
     */
    public void askAdditionalDraws() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("You can add between 0 and 3 cardss to your initial draw of 3. \n How many additional cards would you like to draw if any?");
        int additionalDraws = scanner.nextInt();
        scanner.close();
        
        this.AdditionalDraw = additionalDraws;
        this.TotalDraw = this.BaseDraw + this.AdditionalDraw;
    }
    /**
     * Generates a new chance ratio array based on the given drawn cards array.
     * Each drawn card is paired with a randomly generated number between -10 and 10.
     *
     * @param drawnCards the array of drawn cards
     * @return the new chance ratio array
     */
    public int[] NewChanceRatio(int[] drawnCards) {
        int[] chanceRatio = new int[drawnCards.length * 2];
        int index = 0;
        
        for (int i = 0; i < drawnCards.length; i++) {
            int randomNum = (int) (Math.random() * 21) - 10; // Generate a random number between -10 and 10
            chanceRatio[index++] = drawnCards[i];
            chanceRatio[index++] = randomNum;
        }
        
        return chanceRatio;
    }
    
    /**
     * Generates a new draw of cards.
     * 
     * @return an array of integers representing the drawn cards
     */
    public int[] NewDraw() {
        this.askAdditionalDraws();
        this.DrawnCards = new int[this.TotalDraw];
        List<Integer> cardList = createCardList(); // Get the initial card list

        for (int i = 0; i < this.TotalDraw; i++) {
            int randomIndex = (int) (Math.random() * cardList.size()); // Get a random index from the card list
            int drawnCard = cardList.get(randomIndex); // Get the drawn card from the card list
            this.DrawnCards[i] = drawnCard; // Add the drawn card to the DrawnCards array
            cardList.remove(randomIndex); // Remove the drawn card from the card list
        }

        return this.NewChanceRatio(this.DrawnCards);
    }

}
