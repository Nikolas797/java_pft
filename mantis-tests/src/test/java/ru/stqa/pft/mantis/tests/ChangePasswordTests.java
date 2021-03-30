package ru.stqa.pft.mantis.tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.Users;

import java.io.IOException;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;


public class ChangePasswordTests extends TestBase {


    @BeforeSuite(alwaysRun = true)
    public void setUp() throws IOException {
        app.init();
    }

//    @BeforeMethod
    public void startMailServer(){
        app.mail().start();
    }

    @Test
    public void testChangeUserPassword() throws Exception {
        String user = "nk";
        String email = "nk@localhost";
        String password = "password";
        String passwordNew = "password1";
        app.session().login("Administrator", "root");
        app.session().usersList();
        Users mantisUser = app.db().mantisUser();
        Thread.sleep(2000);
        app.session().selectUser(String.valueOf(mantisUser.getId()));
        app.session().changePassword();
        List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
        String confirmationLink = app.session().findConfirmationLink(mailMessages, email);
        app.session().updateUserPassword(confirmationLink, user, passwordNew);
        HttpSession httpSession = app.newSession();
        assertTrue(httpSession.login(user, passwordNew));
        assertTrue(httpSession.isLoggedInAs("nk"));
    }

//    @AfterMethod(alwaysRun = true)
    public void stopMailServer(){
        app.mail().stop();
    }
}