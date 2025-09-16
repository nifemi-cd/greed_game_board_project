# Greed Game

## Overview

The Greed Game is a console-based game where players navigate a grid, collecting points by moving in specified directions. The game features a menu system, game logic, and a game board, all implemented in Java.

## Project Structure

The project consists of the following main components:

- **Game**: The abstract base class for the game, managing the game loop and transitions between menu and game states.
- **GameBoard**: The interface representing a game board that can be viewed and reset.
- **GameLogic**: The abstract base class for game logic, managing the player's score and providing basic functionality for game logic.
- **Menu**: The abstract base class for the game menu, managing menu items and handling user input to navigate the menu.
- **MenuItem**: The abstract base class for a menu item, providing functionality to get the item's description and identifier, and to select the item.
- **Player**: The interface representing a player in the game, providing a method to get input from the player.
- **Selectable**: The interface representing a selectable item, providing a method to select the item.
- **Viewable**: The interface representing a viewable item, providing a method to view the item.

## Classes

### Main Classes

- **[Main](GivenCode/Main.java)**: Initializes and runs the Greed Game, setting up the game board, game logic, and menu.
- **[GreedGame](GivenCode/GreedGame.java)**: Represents the Greed Game, initializing the game logic, game board, and menu.
- **[GreedGameBoard](GivenCode/GreedGameBoard.java)**: Represents the game board for the Greed Game, managing the board's state, including the player's position and the contents of each cell.
- **[GreedGameLogic](GivenCode/GreedGameLogic.java)**: Represents the game logic for the Greed Game, managing the player's score, valid moves, and transitions between game states.
- **[GreedMenu](GivenCode/GreedMenu.java)**: Represents the menu for the Greed Game, providing functionality to reset the menu with a specific message.
- **[HumanPlayer](GivenCode/HumanPlayer.java)**: Represents a human player in the game, providing functionality to get input from the player.

### Menu Items

- **[PlayGame](GivenCode/PlayGame.java)**: Represents the "Play Game" menu item, providing functionality to select the item and view its description.
- **[QuitGame](GivenCode/QuitGame.java)**: Represents the "Quit Game" menu item, providing functionality to select the item and view its description.

### Game Moves

- **[GameMove](GivenCode/GameMove.java)**: Represents a move in the game, identified by a unique move ID, providing basic functionality for game moves.
- **[GreedGameMove](GivenCode/GreedGameMove.java)**: Represents a move in the Greed Game, identified by a unique move ID, providing functionality to execute the move on the game board.

### Interfaces

- **[GameBoard](GivenCode/GameBoard.java)**: Represents a game board that can be viewed and reset.
- **[GameLogical](GivenCode/GameLogical.java)**: Represents the logic of a game, managing the player's score and providing basic functionality for game logic.
- **[Menuable](GivenCode/Menuable.java)**: Represents a menu that can be reset and have a message set.
- **[Player](GivenCode/Player.java)**: Represents a player in the game, providing a method to get input from the player.
- **[RunnableGame](GivenCode/RunnableGame.java)**: Represents a runnable game, providing a method to run the game.
- **[Selectable](GivenCode/Selectable.java)**: Represents a selectable item, providing a method to select the item.
- **[Viewable](GivenCode/Viewable.java)**: Represents a viewable item, providing a method to view the item.

## How to Run

1. Compile the Java files:
    ```sh
    javac *.java
    ```

2. Run the `Main` class:
    ```sh
    java Main
    ```


## Author

Oluwanifemi Paul Tawoju
