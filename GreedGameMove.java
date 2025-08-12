// CLASS: GreedGameMove
//
// Author: Oluwanifemi Tawoju, 7980612
//
// REMARKS: This class represents a move in the Greed Game, identified by a unique move ID. 
// It provides functionality to execute the move on the game board.
//
//-----------------------------------------

public class GreedGameMove extends GameMove {
    int rowCoeff;
    int colCoeff;
    int noOfSteps; // number of steps to move for this action

    //------------------------------------------------------
    // GreedGameMove
    //
    // PURPOSE:    Initializes the game move with the specified move ID, number of steps, row coefficient, and column coefficient.
    // PARAMETERS: 
    //     int moveID - the unique identifier for the move
    //     int noOfSteps - the number of steps to move for this action
    //     int rowCoeff - the row coefficient for the move
    //     int colCoeff - the column coefficient for the move
    // Returns:    None
    //------------------------------------------------------
    public GreedGameMove(int moveID, int noOfSteps, int rowCoeff, int colCoeff) {
        super(moveID);
        this.noOfSteps = noOfSteps;
        this.rowCoeff = rowCoeff;
        this.colCoeff = colCoeff;
    }

    //------------------------------------------------------
    // getRowCoeff
    //
    // PURPOSE:    Returns the row coefficient for the move.
    // PARAMETERS: None
    // Returns:    int - the row coefficient
    //------------------------------------------------------
    public int getRowCoeff() {
        return rowCoeff;
    }

    //------------------------------------------------------
    // getColCoeff
    //
    // PURPOSE:    Returns the column coefficient for the move.
    // PARAMETERS: None
    // Returns:    int - the column coefficient
    //------------------------------------------------------
    public int getColCoeff() {
        return colCoeff;
    }

    //------------------------------------------------------
    // select
    //
    // PURPOSE:    Executes the move on the game board, updating the player's position and the board state.
    // PARAMETERS: 
    //     Viewable v - the current viewable state of the game
    //     GameLogical gl - the game logic
    // Returns:    boolean - true if the move is successfully executed
    //------------------------------------------------------
    @Override
    public boolean select(Viewable v, GameLogical gl) {
        GreedGameBoard board = (GreedGameBoard) v;

        int pRow = board.getPlayerRow();
        int pCol = board.getPlayerCol();

        board.eatChar(pRow, pCol);

        int i = 1;

        while (i <= noOfSteps) {
            board.eatChar(pRow, pCol);

            pRow = pRow + rowCoeff;
            pCol = pCol + colCoeff;

            i++;
        }

        board.setPlayer(pRow, pCol); // set player to new position

        return true;
    }
}