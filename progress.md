file used to keep track of the progress of the project in addition to the git commits

### 1st step :
    creating a java main used as a menu to interact either with the  "New Draw" , "Load User Draw" or "Last Draw" methods
### 2nd step :
    creating a java class Draw used to create **NewDraw**, and ask user if they want to draw more
    cards are are represented in an array of ~~*(userdefined)*~~ 78 cards
    which are drawn and put in a new array of 3+ *(userdefined)* cards 
    then the array of cards is being sent to the **ChanceRatio** method which then stores them as tuples of their own value + a second random number ranging from -10 to 10

### 3rd step :
    creating a Display class to display the cards in a window and / or in the console

### 4th step :
    create a class to save the user's draws in a history.csv file and to allow them to be loaded back from the main menu 
    as well as a reserved line in the history.csv for the last draw to be saved in
