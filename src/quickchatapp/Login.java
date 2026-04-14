//Ryan Jeffries
//Created Login Class
package quickchatapp;

import java.util.regex.Pattern;

public class Login 
{

    User registeredUser;

    // Check Username
    public boolean checkUserName(String username) 
    {
        return username.contains("_") && username.length() <= 5;
    }

    // Check Password Complexity
    public boolean checkPasswordComplexity(String password) 
    {

        boolean hasUpper = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        if (password.length() < 8) 
        {
            return false;
        }

        for (char c : password.toCharArray()) 
        {
            if (Character.isUpperCase(c)) 
            {
                hasUpper = true;
            }
            if (Character.isDigit(c)) 
            {
                hasNumber = true;
            }
            if (!Character.isLetterOrDigit(c)) 
            {
                hasSpecial = true;
            }
        }

        return hasUpper && hasNumber && hasSpecial;
    }

    // Check Cell Phone Number
    public boolean checkCellPhoneNumber(String cellPhone) 
    {
        return cellPhone.matches("^\\+27\\d{9}$");
    }

    // Register User
    public String registerUser(String firstName, String lastName, String username, String password, String cellPhone)
    {

        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber(cellPhone)) {
            return "Cell phone number is incorrectly formatted or does not contain an international code.";
        }

        registeredUser = new User(firstName, lastName, username, password, cellPhone);

        return "User successfully registered.";
    }

    //Login User
    public boolean loginUser(String username, String password) {

        if (registeredUser == null) {
            return false;
        }

        return registeredUser.username.equals(username) && registeredUser.password.equals(password);
    }

    // 6. Return Login Message
    public String returnLoginStatus(boolean success) {

    if (success) {
        return "Welcome " + registeredUser.firstName + " " + registeredUser.lastName + ", it is great to see you again.";
    } else {
        return "Username or password incorrect, please try again.";
    }
}
}
