// CLASS: MenuItem
//
// Author: Oluwanifemi Tawoju
//
// REMARKS: This abstract class represents a menu item in the game menu. 
// It provides functionality to get the item's description and identifier, and to select the item.
//
//-----------------------------------------

public abstract class MenuItem implements Selectable, Viewable {
    int numberID; // specific identifier for each menuItem
    String description;

    //------------------------------------------------------
    // MenuItem
    //
    // PURPOSE:    Initializes the menu item with a specific identifier and description.
    // PARAMETERS: 
    //     int no - the unique identifier for the menu item
    //     String desc - the description of the menu item
    // Returns:    None
    //------------------------------------------------------
    public MenuItem(int no, String desc) {
        this.description = desc;
        this.numberID = no;
    }

    //------------------------------------------------------
    // getDescription
    //
    // PURPOSE:    Returns the description of the menu item.
    // PARAMETERS: None
    // Returns:    String - the description of the menu item
    //------------------------------------------------------
    public String getDescription() {
        return description;
    }

    //------------------------------------------------------
    // getId
    //
    // PURPOSE:    Returns the unique identifier of the menu item.
    // PARAMETERS: None
    // Returns:    int - the unique identifier of the menu item
    //------------------------------------------------------
    public int getId() {
        return numberID;
    }

    //------------------------------------------------------
    // select
    //
    // PURPOSE:    Abstract method to be implemented by subclasses to define the action when the menu item is selected.
    // PARAMETERS: 
    //     Viewable v - the current viewable state of the game
    //     GameLogical gl - the game logic
    // Returns:    boolean - true if the action is successfully executed
    //------------------------------------------------------
    @Override
    public abstract boolean select(Viewable v, GameLogical gl);
}