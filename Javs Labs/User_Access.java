/*
    Class to check the user credentials.
    Functions:
        logIn
            - This function checks the credentials of users with an account.
        
        SignUp
            - Let employees to register.

*/

// packages and libraries
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.*;

public class User_Access {

    // global string variable to return the username once the employee log in.
    public static String current_Username = " ";

    /*
        Description:
            - Function to logIn the employees
            - returns true for access granted.
            - returns false if the credentials do not match.

    */
    public static boolean logIn() throws IOException {

        // string to save username
        String username_Int = JOptionPane.showInputDialog("Enter Username");

        // string to save password
        String password_Int = JOptionPane.showInputDialog("Enter Password");

        /* read username */

        // creates a file object to read the username file
        File credentialsFile = new File("C:\\Users\\Cardo\\Desktop\\Personal Projects\\Java Projects\\Javs Labs\\employee_Credentials\\" + username_Int + "_Username.txt");

        // scanner object to read credentials
        Scanner readCredentials = new Scanner(credentialsFile);

        // string to store employee username from file
        String system_Username = readCredentials.nextLine();

        readCredentials.close();

        /* read password */

        // reassing file object to read the password file
        credentialsFile = new File("C:\\Users\\Cardo\\Desktop\\Personal Projects\\Java Projects\\Javs Labs\\employee_Credentials\\" + username_Int + "_Password.txt");

        // scanner object to read credentials
        readCredentials = new Scanner(credentialsFile);

        // String to store employee password from file
        String system_Password = readCredentials.nextLine();

        readCredentials.close();

        /* compares the credentials with the text files */

        // if statement to check the credentials entered by the employee
        if (username_Int.equals(system_Username) && password_Int.equals(system_Password)) {

            // assigns the username entered by the user to the global variable once the employee log in.
            current_Username = system_Username;

            // returns true if the employee enters the right credentials
            return true;
        }

        // else statement to return false if the employee credentials do not match the system credentials
        else {
            return false;
        }
    }

    /*
        Function that allow the employee to create a new account.
        
        Description:
            - Let the employee make an account once is hired.
    */
    public static void signUp() throws IOException {

        // string variables to stores the username and password
        String new_Username = JOptionPane.showInputDialog("Enter a username");
        String new_Password = JOptionPane.showInputDialog("Enter a password");

        /* creates the PrintWriter object for username */

        // PrintWriter
        PrintWriter writeCredentials = new PrintWriter("C:\\Users\\Cardo\\Desktop\\Personal Projects\\Java Projects\\Javs Labs\\employee_Credentials\\" + new_Username + "_Username.txt");

        // writes the new username into a new textfile called username_Username.txt
        writeCredentials.print(new_Username);

        writeCredentials.close();

        // reassing the PrintWriter to a new file to create a password file
        writeCredentials = new PrintWriter("C:\\Users\\Cardo\\Desktop\\Personal Projects\\Java Projects\\Javs Labs\\employee_Credentials\\" + new_Username + "_Password.txt");

        // writes the new password
        writeCredentials.print(new_Password);

        writeCredentials.close();

        // prints message of account successfuly created
        JOptionPane.showMessageDialog(null, "Account Successfuly created!");
    }
    
    
    /*  
        Description:
            - Funtion to return the username once the user makes log in.
            - Uses the global variable
            - Returns a string that contains the username.
    */
    public static String getUsername() {

        // returns the username string
        return current_Username;
    }
}
