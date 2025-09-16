// CLASS: QuitGame
//
// Author: Oluwanifemi Tawoju
//
// REMARKS: This class represents the "Quit Game" menu item. 
// It provides functionality to select the item and view its description.
//
//-----------------------------------------

public class QuitGame extends MenuItem {

    //------------------------------------------------------
    // QuitGame
    //
    // PURPOSE:    Initializes the "Quit Game" menu item with a specific identifier and description.
    // PARAMETERS: 
    //     int no - the unique identifier for the menu item
    //     String description - the description of the menu item
    // Returns:    None
    //------------------------------------------------------
    public QuitGame(int no, String description) {
        super(no, description);
    }

    //------------------------------------------------------
    // select
    //
    // PURPOSE:    Executes the action when the "Quit Game" menu item is selected, terminating the program.
    // PARAMETERS: 
    //     Viewable v - the current viewable state of the game
    //     GameLogical gl - the game logic
    // Returns:    boolean - false as the game is terminated
    //------------------------------------------------------
    @Override
    public boolean select(Viewable v, GameLogical gl) {
        System.out.println("Program terminated successfully");
        System.exit(0);
        return false;
    }

    //------------------------------------------------------
    // view
    //
    // PURPOSE:    Displays the description of the "Quit Game" menu item.
    // PARAMETERS: None
    // Returns:    None
    //------------------------------------------------------
    @Override
    public void view() {
        System.out.println(super.getId() + ": " + super.getDescription() + "?");
    }
}