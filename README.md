>to modify using the example provided in the example project in moodle

Lasvenes
Mateo

# Tarot reader 
## Description
This is a tarot reader app written in java and OcamL. 
It allows the user to do , in two steps, to draw 3 cards for a baseline reading, then prompts if the user wants to draw more cards ( from 0 to 3 for a total of a 6 card reading )

Then the app looks up the meaning of the cards using  a local database and, via random draw from for each cards( ranging from -10 , being negative, to 10, being positive ) displays the meaning of the cards to the user.

Once the user is done reading the cards, the app asks if the user wants to do another reading, wants to store their reading in a local database, or wants to quit the app.

when quitting the app, stores the last drawn cards in a temporary file, so that the user can review their last reading when they start the app again.

mermaid diagram of the app
 ```mermaid
 flowchart TD
 subgraph JAVA
	A{Start} -->|check user|D{Load User}-->|user doesn't exists|D
    D-->D1(display last draw)
    D-->D2(check all draws)
    D-->D3(delete user)
	D1-->C
	D2-->Z
	A{Start} -->|check last draw|C[Load Last Draw]-->|last draw empty|A
	C-->Z
	
	A{Start} -->|new draw|B{1st draw}-->|bad user input|B
    B -->B1(one more)
    B-->B2(two more )
    B-->B3(three more )
    B1-->B4[final draw]
	B2-->B4
	B3-->B4
	B4-->B5[roll chance ratio for each card]
	B5-->Z
	A-->|bad user input|A
subgraph Display Draw
	Z{display}
	Z-->Z1(card name and ratio card by card  )
	Z-->Z2(card with meanings)
	Z-->Z3(card, meaning, chance ratio, total chance ratio)
end
end
    
```
