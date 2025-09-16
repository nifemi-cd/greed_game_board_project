// CLASS: GreedGame
//
// Author: Oluwanifemi Tawoju
//
// REMARKS: This class represents the Greed Game, initializing the game logic, game board, and menu. 
// It sets up the menu with options to play the game or quit.
//
//-----------------------------------------

public class GreedGame extends Game {

    //------------------------------------------------------
    // GreedGame
    //
    // PURPOSE:    Initializes the Greed Game with the specified game logic, game board, and menu.
    // PARAMETERS: 
    //     GreedGameLogic gl - the game logic for the Greed Game
    //     GreedGameBoard gb - the game board for the Greed Game
    //     Menu menu - the menu for the Greed Game
    // Returns:    None
    //------------------------------------------------------
    public GreedGame(GreedGameLogic gl, GreedGameBoard gb, Menu menu) {
        super(gl, gb, menu);
        
    }
}