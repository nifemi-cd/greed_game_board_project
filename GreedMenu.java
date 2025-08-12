// CLASS: GreedMenu
//
// Author: Oluwanifemi Tawoju, 7980612
//
// REMARKS: This class represents the menu for the Greed Game. 
// It provides functionality to reset the menu with a specific message.
//
//-----------------------------------------

public class GreedMenu extends Menu {

    public GreedMenu(){
        super.setMessage("Welcome to Greed Game!");  
        super.addMenuItem(new PlayGame(1, "Play Game"));
        super.addMenuItem(new QuitGame(2, "Quit Game")); 

    }

    //------------------------------------------------------
    // reset
    //
    // PURPOSE:    Resets the menu with a specific message for the Greed Game.
    // PARAMETERS: None
    // Returns:    None
    //------------------------------------------------------
    @Override
    public void reset() {
        super.concatMessage("Greed Game Menu");
    }
}