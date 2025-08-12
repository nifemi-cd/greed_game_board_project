// CLASS: GameLogic
//
// Author: Oluwanifemi Tawoju, 7980612
//
// REMARKS: This abstract class represents the logic of a game, managing the player's score and providing basic functionality for game logic.
//
//-----------------------------------------

public abstract class GameLogic implements GameLogical {
    private int playerScore;

    // Constructor
    //------------------------------------------------------
    // GameLogic
    //
    // PURPOSE:    Initializes the game logic with an initial player score of 0.
    // PARAMETERS: None
    // Returns:    None
    //------------------------------------------------------
    public GameLogic() {
        this.playerScore = 0; // initial playerScore
    }

    // Methods
    //------------------------------------------------------
    // getPlayerScore
    //
    // PURPOSE:    Returns the current player score.
    // PARAMETERS: None
    // Returns:    int - the current player score
    //------------------------------------------------------
    public int getPlayerScore() {
        return this.playerScore;
    }
}