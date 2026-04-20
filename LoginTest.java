/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    
    Login login = new Login();

    @Test
    public void testCheckUserNameCorrectlyFormatted() {
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testCheckUserNameIncorrectlyFormatted() {
        assertFalse(login.checkUserName("kyle!!!!!!"));
    }
    
    @Test
    public void testCheckPasswordComplexitySuccess() {
        assertTrue(login.checkPasswordComplexity("Ch&sec@ke99!"));
    }
    
    @Test
    public void testCheckPasswordComplexityFailure() {
        assertFalse(login.checkPasswordComplexity("password"));
    }
    
    @Test
    public void testCheckCellPhoneNumberCorrect() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }
    
    @Test
    public void testCheckCellPhoneNumberIncorrect() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }
    
    @Test
    public void testLoginSuccessful() {
        login.registerUser("kyl_1", "Ch&sec@ke99!");
        assertTrue(login.loginUser("kyl_1", "Ch&sec@ke99!"));
    }
    
    @Test
    public void testLoginFailed() {
        login.registerUser("kyl_1", "Ch&sec@ke99!");
        assertFalse(login.loginUser("kyl_1", "wrong"));
    }
    
    @Test
    public void testRegisterUserMessage() {
        String result = login.registerUser("kyl_1", "Ch&sec@ke99!");
        String expected = "Username successfully captured.\nPassword successfully captured.\nUser registered successfully.";
        assertEquals(expected, result);
    }
}
