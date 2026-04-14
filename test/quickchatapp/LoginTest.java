package quickchatapp;

import org.junit.Test;
    
public class LoginTest {

    Login login = new Login();

    // ---------------- USERNAME TESTS ----------------
    @Test
    public void testUsernameCorrect() {
        assertTrue(login.checkUserName("ky_1"));
    }

    @Test
    public void testUsernameIncorrect() {
        assertFalse(login.checkUserName("kyle!!!!!!"));
    }

    // ---------------- PASSWORD TESTS ----------------
    @Test
    public void testPasswordCorrect() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordIncorrect() {
        assertFalse(login.checkPasswordComplexity("password"));
    }

    // ---------------- CELL TESTS ----------------
    @Test
    public void testCellCorrect() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCellIncorrect() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    // ---------------- REGISTER TESTS ----------------
    @Test
    public void testRegisterSuccess() {
        String result = login.registerUser(
                "John",
                "Doe",
                "jd_1",
                "Password1!",
                "+27838968976"
        );

        assertEquals("User successfully registered.", result);
    }

    @Test
    public void testRegisterFailUsername() {
        String result = login.registerUser(
                "John",
                "Doe",
                "wrongname",
                "Password1!",
                "+27838968976"
        );

        assertEquals(
                "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.",
                result
        );
    }

    // ---------------- LOGIN TESTS ----------------
    @Test
    public void testLoginSuccess() {
        login.registerUser("John", "Doe", "jd_1", "Password1!", "+27838968976");
        assertTrue(login.loginUser("jd_1", "Password1!"));
    }

    @Test
    public void testLoginFail() {
        login.registerUser("John", "Doe", "jd_1", "Password1!", "+27838968976");
        assertFalse(login.loginUser("jd_1", "wrongPass"));
    }
}
