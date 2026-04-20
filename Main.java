/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystem;

/**
 *
 * @author masha
 */
import java.util.Scanner;
public class Main 
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Login loginSystem = new Login();
        
        System.out.println("=== Registration ===");
        System.out.print("Enter your first name: ");
        loginSystem.setFirstName(input.nextLine());
        System.out.print("Enter your last name: ");
        loginSystem.setLastName(input.nextLine());
        
        // Keep asking until username is valid
        String username;
        boolean validUsername = false;
        do {
            System.out.print("Enter your Username: ");
            username = input.nextLine();
            validUsername = loginSystem.checkUserName(username);
            if (!validUsername) {
                System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
            }
        } while (!validUsername);
        
        // Keep asking until password is valid
        String password;
        boolean validPassword = false;
        do {
            System.out.print("Enter password: ");
            password = input.nextLine();
            validPassword = loginSystem.checkPasswordComplexity(password);
            if (!validPassword) {
                System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            }
        } while (!validPassword);
        
        // Get cell number
        String cell;
        do {
            System.out.print("Enter cell number: ");
            cell = input.nextLine();
            loginSystem.setCellNumber(cell);
        } while (loginSystem.checkCellPhoneNumber(cell) == false);
        
        System.out.println(loginSystem.registerUser(username, password));
        
        System.out.println("\n=== Login to your account ===");
        boolean loginSuccess = false;
        do {
            System.out.print("Enter username: ");
            String loginUsername = input.nextLine();
            System.out.print("Enter password: ");
            String loginPassword = input.nextLine();
            loginSuccess = loginSystem.loginUser(loginUsername, loginPassword);
            System.out.println(loginSystem.returnLoginStatus(loginSuccess));
        } while (!loginSuccess);
        
        input.close();
    }
}