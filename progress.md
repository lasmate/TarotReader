file used to keep track of the progress of the project in addition to the git commits

# 1st step:
creating a Java main used as a menu to interact with either the "New Draw", "Load User Draw", or "Last Draw" methods.

# 2nd step:
creating a Java class Draw used to create a **NewDraw**, and ask the user if they want to draw more.
Cards are represented in an array of 78 user-defined cards, which are drawn and put in a new array of 3+ user-defined cards.
Then the array of cards is sent to the **LuckRatio** method, which stores them as tuples of their own value + a second random number ranging from -10 to 10.

# 3rd step:
creating a Display class to display the cards in a window and/or in the console that will use the number of the card in the array to display the card name and the LuckRatio number assigned to it to display the specified meaning of the designed card.


# 4th step:
create a class to save the user's draws in a history.csv file and to allow them to be loaded back from the main menu.
Also, reserve a line in the history.csv for the last draw to be saved in.
