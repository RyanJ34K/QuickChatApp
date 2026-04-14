package quickchatapp;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    Login login = new Login();

    @Test
    public void testCheckUserName() {
        assertTrue(login.checkUserName("Rex_1"));
        assertFalse(login.checkUserName("Rex!!!!!!"));
    }

    @Test
    public void testCheckPasswordComplexity() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCheckCellPhoneNumber() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testRegisterUser() {

        String result = login.registerUser("John", "Doe", "jd_1", "Password1!", "+27838968976");

        assertEquals("User successfully registered.", result);
    }

    @Test
    public void testLoginUser() {

        login.registerUser("John", "Doe", "jd_1", "Password1!", "+27838968976");

        assertTrue(login.loginUser("jd_1", "Password1!"));
        assertFalse(login.loginUser("jd_1", "wrongPass"));
    }
}
