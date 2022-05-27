/*
    Main_System class will collect information from the other classes 
    in the program to combine them in only one function

*/

// packages and libraries
import java.io.IOException;
import javax.swing.JOptionPane;

public class Main_System extends User_Access {

    public static void run_System() throws IOException {
        
        // int to get the user choice
        int userAccess = accessMenu();

        // switch statement to process the user selection
        switch(userAccess) {

            // case 1 will log in an employee with an actual account
            case 1:
                 // calls the logIn function to store the boolean value in grantAccess variable
                 boolean grantAccess = logIn();

                 // if statemet to grant access or not
                 if (grantAccess == true) {

                    // string variable to hold the current employee username
                    String currentUsername = getUsername();

                    // print a welcome message
                    JOptionPane.showMessageDialog(null, "Welcome back, " + currentUsername);
                 }

                 else {
                     JOptionPane.showMessageDialog(null, "Invalid Credentials. Call customer service.");
                 }

                 break;
            
            // case 2 will make the employee to sign up
            case 2:
                 signUp();
                 break;

            // default will exit the program and print a goodbye message
            default:
                 JOptionPane.showMessageDialog(null, "Goodbye!\n\nJavs Labs");

        }
        
    }

    public static int accessMenu() {

        // displays menu options
        String selection = JOptionPane.showInputDialog("1 - Log In\n2 - Sign Up\n0 - Exit");

        // convert the user selection into a int to returned
        int user_Selection = Integer.parseInt(selection);

        // while statement to make sure the user enters a number between 0 and 2

        while((user_Selection < 0) || (user_Selection > 2)) {

            selection = JOptionPane.showInputDialog("1 - Log In\n2 - Sign Up\n0 - Exit");

            // convert the user selection into a int to returned
            user_Selection = Integer.parseInt(selection);

        }

        // return the user selection
        return user_Selection;
    }
    
}
