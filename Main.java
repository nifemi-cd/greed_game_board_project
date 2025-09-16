//-----------------------------------------
// NAME        : Oluwanifemi Tawoju
// REMARKS: This program initializes and runs the Greed Game, setting up the game board, game logic, and menu.
//-----------------------------------------

public class Main {

    public static void main(String[] args){

        int row = 20;
        int col = 80;

        GreedGameBoard ggm = new GreedGameBoard(row, col);
        GreedGameLogic ggl = new GreedGameLogic();
        Menu menu = new GreedMenu();
        
        GreedGame game = new GreedGame(ggl, ggm, menu);
        game.run();
    }
}