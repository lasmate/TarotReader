file used to keep track of the progress of the project in addition to the git commits

### 1st step :
    creating a java main used as a menu to interact either with the  "New Draw" , "Load User Draw" or "Last Draw" methods
### 2nd step :
    creating a java class Draw used to create **NewDraw**, and ask user if they want to draw more
    cards are are represented in an array of ~~*(userdefined)*~~ 78 cards
    which are drawn and put in a new array of 3+ *(userdefined)* cards 
    then the array of cards is being sent to the **ChanceRatio** method which then stores them as tuples of their own value + a second random number ranging from -10 to 10

### 3rd step :
    calculate their ratio and 1st save them in a temporary file , and then call the "DisplayDraw" method
