package geco;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Theo on 30/11/2016.
 */
public class TestLoginGenerator {

    private LoginService loginService;
    private LoginGenerator loginGenerator;

    @Before
    public void setUp() {
        loginService = new LoginService(new String[] {"JROL", "BPER",
                "CGUR", "JDUP", "JRAL", "JRAL1"});
        loginGenerator = new LoginGenerator(loginService);
    }

    @Test
    public void generateLoginForDurandPaulTest() {
        Assert.assertEquals("PDUR", loginGenerator.generateLoginForNomAndPrenom("Durand","Paul"));
    }

    @Test
    public void generateLoginForJohnRallingTest() {
        Assert.assertEquals("JRAL2", loginGenerator.generateLoginForNomAndPrenom("Ralling","John"));
    }

    @Test
    public void generateLoginForJeanRollingTest() {
        Assert.assertEquals("JROL1", loginGenerator.generateLoginForNomAndPrenom("Rolling","Jean"));
    }

    @Test
    public void generateLoginForDùrandPaulTest() {
        Assert.assertEquals("PDUR", loginGenerator.generateLoginForNomAndPrenom("Dùrand","Paul"));
    }

}
