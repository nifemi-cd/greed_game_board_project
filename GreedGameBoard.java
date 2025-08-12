// CLASS: GreedGameBoard
//
// Author: Oluwanifemi Tawoju, 7980612
//
// REMARKS: This class represents the game board for the Greed Game. 
// It manages the board's state, including the player's position and the contents of each cell.
//
//-----------------------------------------

import java.util.Random;

public class GreedGameBoard implements GameBoard {
    private int rows;
    private int cols;
    private char[][] board;
    int playerRow;
    int playerCol;

    // constants
    private final char playerChar = '@';
    private final char emptySpot = ' ';

    //------------------------------------------------------
    // GreedGameBoard
    //
    // PURPOSE:    Initializes the game board with the specified number of rows and columns.
    // PARAMETERS: 
    //     int rows - the number of rows in the game board
    //     int cols - the number of columns in the game board
    // Returns:    None
    //------------------------------------------------------
    public GreedGameBoard(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board = new char[rows][cols];
        this.playerRow = rows / 2;
        this.playerCol = cols / 2;
        this.fillBoard();
    }

    //------------------------------------------------------
    // getRow
    //
    // PURPOSE:    Returns the number of rows in the game board.
    // PARAMETERS: None
    // Returns:    int - the number of rows
    //------------------------------------------------------
    public int getRow() {
        return this.rows;
    }

    //------------------------------------------------------
    // getCol
    //
    // PURPOSE:    Returns the number of columns in the game board.
    // PARAMETERS: None
    // Returns:    int - the number of columns
    //------------------------------------------------------
    public int getCol() {
        return this.cols;
    }

    //------------------------------------------------------
    // getPlayerRow
    //
    // PURPOSE:    Returns the current row position of the player.
    // PARAMETERS: None
    // Returns:    int - the player's row position
    //------------------------------------------------------
    public int getPlayerRow() {
        return playerRow;
    }

    //------------------------------------------------------
    // getPlayerCol
    //
    // PURPOSE:    Returns the current column position of the player.
    // PARAMETERS: None
    // Returns:    int - the player's column position
    //------------------------------------------------------
    public int getPlayerCol() {
        return playerCol;
    }

    //------------------------------------------------------
    // setPlayer
    //
    // PURPOSE:    Sets the player's position on the game board.
    // PARAMETERS: 
    //     int row - the row position to set the player
    //     int col - the column position to set the player
    // Returns:    None
    //------------------------------------------------------
    public void setPlayer(int row, int col) {
        this.playerRow = row;
        this.playerCol = col;
        this.board[playerRow][playerCol] = playerChar;
    }

    //------------------------------------------------------
    // eatChar
    //
    // PURPOSE:    Removes a character from the specified position on the game board.
    // PARAMETERS: 
    //     int row - the row position of the character to remove
    //     int col - the column position of the character to remove
    // Returns:    None
    //------------------------------------------------------
    public void eatChar(int row, int col) {
        this.board[row][col] = emptySpot;
    }

    //------------------------------------------------------
    // isEmpty
    //
    // PURPOSE:    Checks if the specified position on the game board is empty.
    // PARAMETERS: 
    //     int row - the row position to check
    //     int col - the column position to check
    // Returns:    boolean - true if the position is empty, false otherwise
    //------------------------------------------------------
    public boolean isEmpty(int row, int col) {
        return board[row][col] == emptySpot;
    }

    //------------------------------------------------------
    // getBoard
    //
    // PURPOSE:    Returns the current state of the game board.
    // PARAMETERS: None
    // Returns:    char[][] - the game board
    //------------------------------------------------------
    public char[][] getBoard() {
        return board;
    }

    //------------------------------------------------------
    // fillBoard
    //
    // PURPOSE:    Fills the game board with random characters, except for the player's position.
    // PARAMETERS: None
    // Returns:    None
    //------------------------------------------------------
    private void fillBoard() {
        Random rand = new Random();

        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                this.board[i][j] = (char) (rand.nextInt(9) + '1');
            }
        }
        this.board[playerRow][playerCol] = playerChar;
    }

    //------------------------------------------------------
    // view
    //
    // PURPOSE:    Displays the current state of the game board on the terminal.
    // PARAMETERS: None
    // Returns:    None
    //------------------------------------------------------
    public void view() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                System.out.print(this.board[i][j] + "");
            }
            System.out.println();
        }
    }

    //------------------------------------------------------
    // reset
    //
    // PURPOSE:    Resets the game board to its initial state.
    // PARAMETERS: None
    // Returns:    None
    //------------------------------------------------------
    @Override
    public void reset() {
        this.playerRow = rows / 2;
        this.playerCol = cols / 2;
        this.board[playerRow][playerCol] = playerChar;
        fillBoard();
    }
}