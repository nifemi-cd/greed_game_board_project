// CLASS: Menu
//
// Author: Oluwanifemi Tawoju
// REMARKS: This class represents a menu for the game. 
// It manages menu items, displays the menu, and handles user input to navigate the menu.
//
//-----------------------------------------

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Menu implements Menuable {
    private String welcomeMessage;
    private List<MenuItem> list;
    private Scanner scnr;

    // constants
    private static String invalidMessage = "Invalid choice. Try again!!";

    //------------------------------------------------------
    // Menu
    //
    // PURPOSE:    Initializes the menu with an empty list of menu items and a scanner for input.
    // PARAMETERS: None
    // Returns:    None
    //------------------------------------------------------
    public Menu() {
        list = new ArrayList<MenuItem>();
        scnr = new Scanner(System.in);
    }

    //------------------------------------------------------
    // addMenuItem
    //
    // PURPOSE:    Adds a menu item to the menu.
    // PARAMETERS: 
    //     MenuItem item - the menu item to add
    // Returns:    None
    //------------------------------------------------------
    public void addMenuItem(MenuItem item) {
        list.add(item);
    }

    //------------------------------------------------------
    // nextState
    //
    // PURPOSE:    Handles user input to navigate the menu and transition to the next state.
    // PARAMETERS: 
    //     Viewable v - the current viewable state of the game
    // Returns:    boolean - true if the game continues, false if it ends
    //------------------------------------------------------
    @Override
    public boolean nextState(Viewable v) {
        boolean result = false;

        System.out.print("Enter menu option: ");
        String input = scnr.nextLine();

        if (input != null && input.matches("\\d+")) { // contains only digits and is a valid input
            int choice = Integer.parseInt(input);

            if (choice >= 1 && choice <= list.size()) {

                boolean found = false; // used for 'for' loop

                for (int i = 0; i < list.size() && !found; i++) {
                    if (list.get(i).getId() == choice) {
                        result = list.get(i).select(v, this);
                        found = true;
                    }
                }

            } else {
                System.out.println(invalidMessage);
                result = false;
            }
        } else {
            System.out.println(invalidMessage);
            result = false;
        }
        return result; // Continue running unless quit is chosen
    }



    public void concatMessage(String message) {
        this.welcomeMessage += " " + message;
    }

    //------------------------------------------------------
    // view
    //
    // PURPOSE:    Displays the menu and its items.
    // PARAMETERS: None
    // Returns:    None
    //------------------------------------------------------
    @Override
    public void view() {
        System.out.println(welcomeMessage);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).view();
        }
    }

    //------------------------------------------------------
    // setMessage
    //
    // PURPOSE:    Sets the welcome message for the menu.
    // PARAMETERS: 
    //     String message - the welcome message to set
    // Returns:    None
    //------------------------------------------------------
    @Override
    public void setMessage(String message) {
        this.welcomeMessage = message;
    }
}