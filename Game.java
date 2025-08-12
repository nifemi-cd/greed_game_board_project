// CLASS: Game
//
// Author: Oluwanifemi Tawoju, 7980612
//
// REMARKS: This abstract class represents a generic game with a game logic, game board, and menu. 
// It provides a framework for running the game by managing the game loop and transitions between menu and game states.
//
//-----------------------------------------

public abstract class Game implements RunnableGame {
    // Variables
    private GameLogic game;
    private GameBoard board;
    private Menu menu;
    private boolean isGamemode;

    // Constructor
    Game(GameLogic gl, GameBoard gb, Menu m){
        game = gl;
        board = gb;
        menu = m;
    }

    // Methods
    //------------------------------------------------------
    // run
    //
    // PURPOSE:    This method runs the main game loop, alternating between the menu and game states.
    // PARAMETERS: None
    // Returns:    None
    //------------------------------------------------------
    @Override
    public void run() {
        while (true) {
            menu.view();
            isGamemode = menu.nextState(menu);
            while (isGamemode) {
                game.view();
                board.view();   
                isGamemode = game.nextState(board);
            }
            menu.setMessage("Welcome back!");
            menu.reset();
            board.reset();
            game.reset();
        }
    }
}