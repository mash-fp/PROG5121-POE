
package com.mycompany.loginsystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testUsernameCorrectlyFormatted() {
        Login login = new Login();
        assertEquals(true, login.checkUserName("kyl_1"), "kyl_1 should return true");
    }

    @Test 
    public void testUsernameIncorrectlyFormatted() {
        Login login = new Login();
        assertEquals(false, login.checkUserName("kyle!!!!!!"), "kyle!!!!!! should return false");
    }
    
    @Test
    public void testPasswordMeetsRequirements() {
        Login login = new Login();
        assertEquals(true, login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordFailsRequirements() {
        Login login = new Login();
        assertEquals(false, login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCellNumberCorrectlyFormatted() {
        Login login = new Login();
        assertEquals(true, login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCellNumberIncorrectlyFormatted() {
        Login login = new Login();
        assertEquals(false, login.checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testLoginSuccessful() {
        Login login = new Login();
        login.setFirstName("Kyle");
        login.setLastName("Smith");
        login.registerUser("kyl_1", "Ch&&sec@ke99!");
        assertEquals(true, login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testReturnLoginStatusSuccess() {
        Login login = new Login();
        login.setFirstName("Kyle");
        login.setLastName("Smith");
        assertEquals("Welcome Kyle, Smith it is great to see you again.", login.returnLoginStatus(true));
    }
}