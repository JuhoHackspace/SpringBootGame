# SpringBootGame

## A multiplayer quiz game played with REST endpoints!

**Game instructions**
- This is a multiplayer quiz game. Players post their answers in turns. Those first to get 20 points win the game
- GET map the application root "/" for instructions
- Start a new game with new players by GET mapping '/newGameNewPlayers'
- Follow instructions and start adding players
- Once the players are added, start the game by GET mapping '/newGame'
- If you allready have a player pool, and wish to start a new game with the same players, GET map '/newGame' at any point
- To post answers, POST map '/postAnswer' with the answer as a parameter (answer: D). Use Postman and url-encoded request body for POST mappings. Only use letters from A to D

**The application keeps track of player scores**
- Each correct answer gains the player 5 points
- Players can tie for the win if they reach 20 points in the same round

**Error handling in application**
- Players must do things in the right order
- First a game must be created
- At least two players must be added before the game can be started
- If users try to add players or post answers at the wrong time, they will be notfied