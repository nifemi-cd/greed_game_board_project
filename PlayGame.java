// CLASS: PlayGame
//
// Author: Oluwanifemi Tawoju
//
// REMARKS: This class represents the "Play Game" menu item. 
// It provides functionality to select the item and view its description.
//
//-----------------------------------------

public class PlayGame extends MenuItem {

    //------------------------------------------------------
    // PlayGame
    //
    // PURPOSE:    Initializes the "Play Game" menu item with a specific identifier and description.
    // PARAMETERS: 
    //     int no - the unique identifier for the menu item
    //     String description - the description of the menu item
    // Returns:    None
    //------------------------------------------------------
    public PlayGame(int no, String description) {
        super(no, description);
    }

    //------------------------------------------------------
    // select
    //
    // PURPOSE:    Executes the action when the "Play Game" menu item is selected.
    // PARAMETERS: 
    //     Viewable v - the current viewable state of the game
    //     GameLogical gl - the game logic
    // Returns:    boolean - true if the action is successfully executed
    //------------------------------------------------------
    @Override
    public boolean select(Viewable v, GameLogical gl) {
        return true;
    }

    //------------------------------------------------------
    // view
    //
    // PURPOSE:    Displays the description of the "Play Game" menu item.
    // PARAMETERS: None
    // Returns:    None
    //------------------------------------------------------
    @Override
    public void view() {
        System.out.println(super.getId() + ": " + super.getDescription() + "?");
    }
}