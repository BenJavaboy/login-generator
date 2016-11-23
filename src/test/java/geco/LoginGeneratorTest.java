package geco;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginGeneratorTest {

    LoginService loginService;
    LoginGenerator loginGenerator;


    @Before
    public void setUp() throws Exception {
        loginService = new LoginService(new String[]{"JROL","BPER","CQUR",
                    "JDUP","JRAL","JRAL1"});
        loginGenerator = new LoginGenerator(loginService);
    }


    @Test
    public void testGenerateLoginForNomAndPrenom() throws Exception {


        loginGenerator.generateLoginForNomAndPrenom("Durand","Paul");
        assertTrue(loginService.loginExists("PDUR"));

        loginGenerator.generateLoginForNomAndPrenom("Rolling","John");
        assertTrue(loginService.loginExists("JROL1"));

        loginGenerator.generateLoginForNomAndPrenom("Dùrand","Paul");
        assertTrue(loginService.loginExists("PDUR"));

    }

    @Test
    public void testGenreateLoginJRAL2() throws Exception{

        loginGenerator.generateLoginForNomAndPrenom("Ralling","John");
        assertTrue(loginService.loginExists("JRAL2"));

    }
}