package geco;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Theo on 29/11/2016.
 */
public class TestLoginService {

    private LoginService loginService;


    @Test
    public void findAllLogins() throws Exception {
        // given : un login service
        loginService = new LoginService(new String[] {"JOLP", "ALOP", "BTUE"});

        // when : on recherche tous les login existants
        List<String> allLogins = loginService.findAllLogins();

        // then : les logins sont retournés triés par ordre croissant
        assertEquals(allLogins.get(0), "ALOP");
        assertEquals(allLogins.get(1), "BTUE");
        assertEquals(allLogins.get(2), "JOLP");

    }


    @Test
    public void loginExists() throws Exception {
        // given : un login service contenant "ALOP"
        loginService = new LoginService(new String[] {"JOLP", "ALOP", "BTUE"});

        // expect : "ALOP" existe dans la base de login
        assertTrue(loginService.loginExists("ALOP"));
    }

    @Test
    public void addLogin() throws Exception {
        // given : un login service ne contenant pas "ALOP"
        loginService = new LoginService(new String[] {"JOLP", "BTUE"});

        // when : on ajoute "ALOP"
        loginService.addLogin("ALOP");

        // then : le login existe bien dans la base
        loginService.loginExists("ALOP");
    }

    @Test
    public void findAllLoginsStartingWith() throws Exception {
        // given : un login service ne contenant plusieurs logins avec le même préfixe
        loginService = new LoginService(new String[] {"JOLP", "ALOP2","BTUE","ALOP","ALOP1", "ALOPA"});

        // when : on recherche les logins préfixés par "ALOP"
        List<String> allLogins = loginService.findAllLoginsStartingWith("ALOP");

        // then : les logins sont retournés triés par ordre croissant
        assertEquals(allLogins.get(0), "ALOP");
        assertEquals(allLogins.get(1), "ALOP1");
        assertEquals(allLogins.get(2), "ALOP2");
        assertEquals(allLogins.get(3), "ALOPA");
    }
}
