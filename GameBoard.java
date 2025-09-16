// CLASS: GameBoard
//
// Author: Oluwanifemi Tawoju
//
// REMARKS: This interface represents a game board that can be viewed and reset. 
// It provides the necessary methods to reset the game board and view its current state.
//
//-----------------------------------------

public interface GameBoard extends Viewable {

    //------------------------------------------------------
    // reset
    //
    // PURPOSE:    This method resets the game board to its initial state.
    // PARAMETERS: None
    // Returns:    None
    //------------------------------------------------------
    void reset();
}