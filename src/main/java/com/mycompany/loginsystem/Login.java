/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystem;

/**
 *
 * @author masha
 */

// === CLASS VARIABLES ===
public class Login {
    // These store user details after registration so we can check them during login
    private String storedUsername;  // keeps username for login check
    private String storedPassword;  // keeps password for login check
    private String firstName;       // used for welcome message
    private String lastName;        // used for welcome message
    private String cellNumber;      // user's cell number

    // === SETTER METHODS ===
    // Basic setters to save first and last name
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    // Only saves cell number if it matches +27 format
    public void setCellNumber(String cellNumber) {
        if (checkCellPhoneNumber(cellNumber)) {
            this.cellNumber = cellNumber;
        } else {
            System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
            this.cellNumber = null;
        }
    }

    // === VALIDATION METHODS ===
    // Checks username rule: must have _ and be 5 chars or less
    public Boolean checkUserName(String username) {
        if (username == null) return false;  // avoid null errors
        boolean isShortEnough = username.length() <= 5;
        boolean hasUnderscore = username.contains("_");
        return (hasUnderscore && isShortEnough);
    }

    // Uses regex to check password rules: 8+ chars, capital, number, special char
    public Boolean checkPasswordComplexity(String password) {
        if (password == null) return false;
        boolean isLongEnough = password.length() >= 8;
        boolean hasCapitalLetter = password.matches(".*[A-Z].*");  // regex for capital
        boolean hasNumber = password.matches(".*\\d.*");           // regex for digit
        boolean hasSpecialCharacter = password.matches(".*[^a-zA-Z0-9].*");  // regex for special char
        return (isLongEnough && hasCapitalLetter && hasNumber && hasSpecialCharacter);
    }

    // Uses regex to check cell: must be +27 followed by exactly 9 digits
    public Boolean checkCellPhoneNumber(String cellNumber) {
        if (cellNumber == null) return false;
        return cellNumber.matches("^\\+27\\d{9}$");  // ^start \+27 literal \d{9} nine digits $end
    }

    // === REGISTRATION & LOGIN LOGIC ===
    // Runs all checks, then saves username/password if valid
    public String registerUser(String username, String password) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        // If code reaches here, both checks passed
        this.storedUsername = username;
        this.storedPassword = password;
        return "Username successfully captured.\nPassword successfully captured.\nUser registered successfully.";
    }

    // Compares login input to stored username/password
    public Boolean loginUser(String username, String password) {
        if (storedUsername == null || storedPassword == null) {
            return false;  // nothing registered yet
        }
        return username.equals(storedUsername) && password.equals(storedPassword);
    }

    // Sends back welcome message or error based on login result
    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}