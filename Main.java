//-----------------------------------------
// NAME        : Oluwanifemi Tawoju
// STUDENT NUMBER : your student number
// COURSE      : COMP 2150
// INSTRUCTOR  : Olivier Tremblay Savard
// ASSIGNMENT  : assignment 3
// QUESTION    : question 0/1      
// 
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