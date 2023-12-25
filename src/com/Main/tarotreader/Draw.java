package com.Main.tarotreader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * The Draw class represents the process of drawing tarot cards.
 * It allows the user to draw a specified number of cards from a deck and calculate their "Luck Ratio".
 * The Luck Ratio is a number between -10 and 10 that represents the user's luck with the cards they drew.
 * 
 */
public class Draw {
    private int BaseDraw = 3;
    private int AdditionalDraw = 0;
    private int TotalDraw = 0;
    private int CardsInDeck = 78;// might rename this variable to DeckSize for improved clarity
    
    private int[] DrawnCards = new int[TotalDraw];

    /**
     * Default constructor for the Draw class.
     * Initializes the BaseDraw, AdditionalDraw, and TotalDraw variables to their default values.
     */
    public Draw() {
        this.BaseDraw = 3;
        this.AdditionalDraw = 0;
        this.TotalDraw = 0;
    }

    /**
     * Gets the number of cards in the deck.
     *
     * @return The number of cards in the deck.
     */
    public int getCardsInDeck() {
        return this.CardsInDeck;
    }

    /**
     * Sets the number of cards in the deck.
     *
     * @param cardsInDeck The new number of cards in the deck.
     * @return The updated number of cards in the deck.
     */
    public int setCardsInDeck(int cardsInDeck) {
        this.CardsInDeck = cardsInDeck;
        return this.CardsInDeck;
    }
    
    /**
     * Creates a list of integers representing the cards in the deck.
     *might rename this method to createDeck for improved clarity

     * @return A list of integers representing the cards in the deck.
     */
    public List<Integer> createCardList() {//works perfectly
        List<Integer> cardList = new ArrayList<>();
        for (int i = 1; i < this.CardsInDeck+1; i++) {
            cardList.add(i);
        }
        System.out.println("The card list is: " + cardList);//debug
        return cardList;
    }
    

    /**
     * Prompts the user to input the number of additional cards they would like to draw,
     * between 0 and 3, and updates the total number of cards to be drawn accordingly.
     */
    public void askAdditionalDraws() {//works perfectly
        Scanner scanner = new Scanner(System.in);
        System.out.print("You can add between 0 and 3 cards to your initial draw of 3.\nHow many additional cards would you like to draw if any?\n");
        int additionalDraws = scanner.nextInt();
        scanner.close();
        System.out.println("You chose to draw " + additionalDraws + " additional cards.");//debug
        this.AdditionalDraw = additionalDraws;
        this.TotalDraw = this.BaseDraw + this.AdditionalDraw;
    }
    
    /**
     * Generates a new Luck ratio array based on the given drawn cards array.
     * Each drawn card is paired with a randomly generated number between -10 and 10.
     *
     * @param drawnCards The array of drawn cards.
     * @return The new Luck ratio array.
     */
    public List<Pair<Integer, Integer>> NewLuckRatio(int[] drawnCards) {
        List<Pair<Integer, Integer>> LuckRatio = new ArrayList<>();
        
        for (int i = 0; i < drawnCards.length; i++) {
            int randomNum = (int) (Math.random() * 21) - 10; // Generate a random number between -10 and 10
            LuckRatio.add(new Pair<>(drawnCards[i], randomNum));
        }
        
        System.out.println("The Luck Ratio is: " + LuckRatio); // debug
        
        return LuckRatio;
    }
    
    /**
     * Generates a new draw of cards.
     * 
     * @return An array of integers representing the drawn cards.
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

        return this.NewLuckRatio(this.DrawnCards);
    }
}
