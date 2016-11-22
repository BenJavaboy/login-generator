package geco;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LoginServiceTest {

    LoginService loginService;

    @Before
    public void setUp() throws Exception {

        String[] logins = {"Johnson", "Germaine"};
        loginService = new LoginService(logins);
    }



    @Test
    public void testLoginExists() throws Exception {
        assertTrue(loginService.loginExists("Johnson"));

    }

    @Test
    public void testAddLogin() throws Exception {
        String log = "Winmarleigh";
        loginService.addLogin(log);
        assertTrue(loginService.loginExists(log));


    }

    @Test
    public void testFindAllLoginsStartingWith() throws Exception {
        List<String> prefixe = loginService.findAllLoginsStartingWith("John");
        assertEquals(prefixe.get(0), "Johnson");

    }

    @Test
    public void testFindAllLogins() throws Exception {
        List<String> log = loginService.findAllLogins();
        assertTrue(log.contains("Johnson"));

    }
}