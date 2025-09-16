// CLASS: HumanPlayer
//
// Author: Oluwanifemi Tawoju
//
// REMARKS: This class represents a human player in the game. 
// It provides functionality to get input from the player.
//
//-----------------------------------------

import java.util.Scanner;

public class HumanPlayer implements Player {
    private Scanner scnr;

    //------------------------------------------------------
    // HumanPlayer
    //
    // PURPOSE:    Initializes the human player with a scanner for input.
    // PARAMETERS: None
    // Returns:    None
    //------------------------------------------------------
    public HumanPlayer() {
        scnr = new Scanner(System.in);
    }

    //------------------------------------------------------
    // getInput
    //
    // PURPOSE:    Prompts the player to enter a move option and returns the input.
    // PARAMETERS: None
    // Returns:    String - the player's input
    //------------------------------------------------------
    @Override
    public String getInput() {
        System.out.print("Enter move option (0 to give up) : ");
        String input = scnr.nextLine();
        return input;
    }
}