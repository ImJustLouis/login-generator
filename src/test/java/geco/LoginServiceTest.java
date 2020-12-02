package geco;

import junit.framework.TestCase;
import org.junit.BeforeClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginServiceTest extends TestCase {

    private LoginService loginService;

    @BeforeClass
    public void setUp() throws Exception {
        super.setUp();
        String[] loginExistants = new String[]{"PDUP1", "LAYR", "LCUS"};
        loginService = new LoginService(loginExistants);
    }

    public void testLoginExists() {
        assertTrue(loginService.loginExists("LAYR"));
        assertFalse(loginService.loginExists("IAYR"));
    }

    public void testAddLogin(){
        loginService.addLogin("IAYR");
        loginService.addLogin("LAYR");
        assertTrue(loginService.loginExists("IAYR"));
        assertTrue (loginService.loginExists("LAYR"));
    }

    public void testFindAllLoginsStartingWith(){
        List<String> loginsStart = loginService.findAllLoginsStartingWith("L");
        assertEquals(Arrays.asList("LAYR", "LCUS"),loginsStart);
        assertEquals(Arrays.asList(), loginService.findAllLoginsStartingWith("M"));
    }

    public void testFindAllLogins(){
        assertEquals(Arrays.asList("LAYR", "LCUS","PDUP1"),loginService.findAllLogins());
    }
}