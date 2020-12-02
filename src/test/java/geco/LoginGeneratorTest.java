package geco;

import junit.framework.TestCase;
import org.junit.BeforeClass;

public class LoginGeneratorTest extends TestCase {

    private LoginGenerator loginGenerator;
    private LoginService loginService;

    @BeforeClass
    public void setUp() throws Exception {
        super.setUp();
        String[] loginExistants = new String[]{"PDUP1", "LAYR", "LCUS"};
        loginService = new LoginService(loginExistants);
        loginGenerator = new LoginGenerator(loginService);
    }

    public void testGenerateLoginForNomAndPrenom() {
        assertEquals("LAYR1",loginGenerator.generateLoginForNomAndPrenom("Ayroles","Louis"));
        assertEquals("EAYR",loginGenerator.generateLoginForNomAndPrenom("Ayroles","Esther"));
    }

}