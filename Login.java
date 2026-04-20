/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystem;

/**
 *
 * @author masha
 */
public class Login {
    // Store user details after registration
    private String storedUsername;
    private String storedPassword;
    private String firstName;
    private String lastName;
    private String cellNumber;

    // Setters
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public void setCellNumber(String cellNumber) {
        if (checkCellPhoneNumber(cellNumber)) {
            this.cellNumber = cellNumber;
        } else {
            System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
            this.cellNumber = null;
        }
    }

    // Username must have _ and be <= 5 chars
    public Boolean checkUserName(String username) {
        if (username == null) return false;
        boolean isShortEnough = username.length() <= 5;
        boolean hasUnderscore = username.contains("_");
        return (hasUnderscore && isShortEnough);
    }

    // Password: 8+ chars, capital, number, special char
    public Boolean checkPasswordComplexity(String password) {
        if (password == null) return false;
        boolean isLongEnough = password.length() >= 8;
        boolean hasCapitalLetter = password.matches(".*[A-Z].*");
        boolean hasNumber = password.matches(".*\\d.*");
        boolean hasSpecialCharacter = password.matches(".*[^a-zA-Z0-9].*");
        return (isLongEnough && hasCapitalLetter && hasNumber && hasSpecialCharacter);
    }

    // Cell: must be +27 followed by 9 digits
    public Boolean checkCellPhoneNumber(String cellNumber) {
        if (cellNumber == null) return false;
        return cellNumber.matches("^\\+27\\d{9}$");
    }

    // Register user if all checks pass
    public String registerUser(String username, String password) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        this.storedUsername = username;
        this.storedPassword = password;
        return "Username successfully captured.\nPassword successfully captured.\nUser registered successfully.";
    }

    // Check login details
    public Boolean loginUser(String username, String password) {
        if (storedUsername == null || storedPassword == null) return false;
        return username.equals(storedUsername) && password.equals(storedPassword);
    }

    // Return message after login attempt
    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}