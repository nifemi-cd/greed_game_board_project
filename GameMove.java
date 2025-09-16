// CLASS: GameMove
//
// Author: Oluwanifemi Tawoju
//
// REMARKS: This abstract class represents a move in the game, identified by a unique move ID. 
// It provides basic functionality for game moves.
//
//-----------------------------------------

public abstract class GameMove implements Selectable {
    private int moveID;

    // Constructor
    //------------------------------------------------------
    // GameMove
    //
    // PURPOSE:    Initializes the game move with a specified move ID.
    // PARAMETERS: 
    //     int moveID - the unique identifier for the move
    // Returns:    None
    //------------------------------------------------------
    public GameMove(int moveID) {
        this.moveID = moveID;
    }

    // Methods
    //------------------------------------------------------
    // getMoveID
    //
    // PURPOSE:    Returns the unique identifier for the move.
    // PARAMETERS: None
    // Returns:    int - the unique identifier for the move
    //------------------------------------------------------
    public int getMoveID() {
        return moveID;
    }
}