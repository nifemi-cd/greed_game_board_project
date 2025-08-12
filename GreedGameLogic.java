// CLASS: GreedGameLogic
//
// Author: Oluwanifemi Tawoju, 7980612
//
// REMARKS: This class represents the game logic for the Greed Game. 
// It manages the player's score, valid moves, and transitions between game states.
//
//-----------------------------------------

import java.util.ArrayList;

public class GreedGameLogic extends GameLogic {
    private int playerScore;
    HumanPlayer player;
    ArrayList<GameMove> validPossMoves; // list of valid possible moves

    // Vectors used to make player movement more efficient
    private static final int[] rowVect = {1, 1, 1, 0, 0, -1, -1, -1}; // Change in row
    private static final int[] colVect = {-1, 0, 1, -1, 1, -1, 0, 1}; // Change in column
    private static final char[] moves = {'1', '2', '3', '4', '6', '7', '8', '9'}; // Corresponding move keys

    private static final String invalidMessage = "Invalid move option. Try again!";
    private static final String gameOver = "No more moves, give up : ";

    //------------------------------------------------------
    // GreedGameLogic
    //
    // PURPOSE:    Initializes the game logic for the Greed Game.
    // PARAMETERS: None
    // Returns:    None
    //------------------------------------------------------
    public GreedGameLogic() {
        validPossMoves = new ArrayList<GameMove>();
        player = new HumanPlayer();
    }

    //------------------------------------------------------
    // view
    //
    // PURPOSE:    Displays the player's current score.
    // PARAMETERS: None
    // Returns:    None
    //------------------------------------------------------
    public void view() {
        System.out.println("Player score: " + this.playerScore);
    }

    //------------------------------------------------------
    // nextState
    //
    // PURPOSE:    Manages the transition to the next state of the game.
    // PARAMETERS: 
    //     Viewable v - the current viewable state of the game
    // Returns:    boolean - true if the game continues, false if it ends
    //------------------------------------------------------
    public boolean nextState(Viewable v) {
        generatePossibleMoves(v);

        boolean result = true;

        if (gameOver()) {
            System.out.print(gameOver);
            // result = false; // game over
        }

        String input = player.getInput();
        if (validateInput(input)) { // contains only digits and is a valid input(1-9, excluding 5) and 0 to quit game
            Integer move = Integer.parseInt(input);

            if (move == 0) {
                result = false;
            }

            if (move != 0 && !gameOver()) {
                int noOfSteps = getDigit(v, move); // also score of player

                boolean found = false; // used for 'for' loop

                for (int i = 0; i < validPossMoves.size() && !found; i++) {
                    if (validPossMoves.get(i).getMoveID() == move) {
                        this.updateScore(noOfSteps);
                        result = validPossMoves.get(i).select(v, this);
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println(invalidMessage);
                }

            }

        } else {
            System.out.println(invalidMessage);
        }

        validPossMoves.clear();
        // scnr.close();
        return result;

    }

    //------------------------------------------------------
    // generatePossibleMoves
    //
    // PURPOSE:    Generates a list of valid possible moves for the player.
    // PARAMETERS: 
    //     Viewable v - the current viewable state of the game
    // Returns:    None
    //------------------------------------------------------
    private void generatePossibleMoves(Viewable v) {

        for (int i = 0; i < moves.length; i++) {
            int move = Character.getNumericValue(moves[i]);
            int noOfSteps = getDigit(v, move);

            if (validMove(v, move, noOfSteps, i) && noOfSteps != -1) { // if it is a valid move
                validPossMoves.add(new GreedGameMove(move, noOfSteps, rowVect[i], colVect[i]));
            }
        }

    }

    //------------------------------------------------------
    // gameOver
    //
    // PURPOSE:    Checks if the game is over by verifying if there are no valid possible moves left.
    // PARAMETERS: None
    // Returns:    boolean - true if the game is over, false otherwise
    //------------------------------------------------------
    private boolean gameOver() {
        return validPossMoves.isEmpty();
    }

    //------------------------------------------------------
    // validMove
    //
    // PURPOSE:    Checks if a move is valid based on the current state of the game board.
    // PARAMETERS: 
    //     Viewable v - the current viewable state of the game
    //     int move - the move to validate
    //     int noOfSteps - the number of steps for the move
    //     int i - the index of the move in the move vectors
    // Returns:    boolean - true if the move is valid, false otherwise
    //------------------------------------------------------
    private boolean validMove(Viewable v, int move, int noOfSteps, int i) {
        GreedGameBoard board = (GreedGameBoard) v;

        boolean valid = true; // used for while loop

        int pRow = board.getPlayerRow();
        int pCol = board.getPlayerCol();

        int indx = -1;

        indx = i;
        pRow = pRow + rowVect[i];
        pCol = pCol + colVect[i];

        int j = 1;

        while (j <= noOfSteps && valid) {

            if (pRow < 0 || pRow >= board.getRow() || pCol < 0 || pCol >= board.getCol()) {
                valid = false;
            }

            if (pRow >= 0 && pRow < board.getRow() && pCol >= 0 && pCol < board.getCol()) { // check if it is off the board

                if (board.isEmpty(pRow, pCol)) {
                    valid = false;
                }
            }

            pRow = pRow + rowVect[indx];
            pCol = pCol + colVect[indx];

            j++;
        }

        return valid;

    }

    //------------------------------------------------------
    // getDigit
    //
    // PURPOSE:    Retrieves the digit at the specified move position on the game board.
    // PARAMETERS: 
    //     Viewable v - the current viewable state of the game
    //     int move - the move to get the digit for
    // Returns:    int - the digit at the move position, or -1 if invalid
    //------------------------------------------------------
    private int getDigit(Viewable v, int move) {
        GreedGameBoard board = (GreedGameBoard) v;

        int digit = -1;

        boolean found = false;

        int pRow = board.getPlayerRow();
        int pCol = board.getPlayerCol();

        for (int i = 0; i < moves.length && !found; i++) {
            if (Character.getNumericValue(moves[i]) == move) {
                found = true;
                pRow = pRow + rowVect[i];
                pCol = pCol + colVect[i];

                if (pRow >= 0 && pRow < board.getRow() && pCol >= 0 && pCol < board.getCol() && Character.getNumericValue(board.getBoard()[pRow][pCol]) != ' ') { // check if it is off the board
                    digit = Character.getNumericValue(board.getBoard()[pRow][pCol]);
                }

            }
        }

        return digit;

    }

    //------------------------------------------------------
    // validateInput
    //
    // PURPOSE:    Validates the player's input to ensure it is a valid move.
    // PARAMETERS: 
    //     String move - the player's input move
    // Returns:    boolean - true if the input is valid, false otherwise
    //------------------------------------------------------
    private boolean validateInput(String move) {
        boolean result = false;
        if (move != null && move.length() == 1 && move.matches("\\d+")) { // contains only digits and is a valid input(1-9) except 5 and 0 for quit
            int choice = Integer.parseInt(move);
            if (choice >= 0 && choice <= 9 && choice != 5) { // valid input
                result = true;
            }
        }

        return result;
    }

    //------------------------------------------------------
    // updateScore
    //
    // PURPOSE:    Updates the player's score by adding the specified score.
    // PARAMETERS: 
    //     int score - the score to add to the player's current score
    // Returns:    None
    //------------------------------------------------------
    private void updateScore(int score) {
        this.playerScore += score;
    }

    //------------------------------------------------------
    // reset
    //
    // PURPOSE:    Resets the game logic to its initial state.
    // PARAMETERS: None
    // Returns:    None
    //------------------------------------------------------
    public void reset() {
        this.playerScore = 0;
    }
}