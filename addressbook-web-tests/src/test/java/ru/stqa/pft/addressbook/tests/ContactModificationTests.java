package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() throws Exception {
        app.getNavigationHelper().goToHomePage();
        int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new NewContactData("nk", "emp", "qa", "AH"));
        }
        app.getContactHelper().selectContact(before - 1);
        app.getContactHelper().initContactModification();
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToHomeContact();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);
//        app.exitLogout();
//    app.getContactHelper().deleteContact();
//    submitDeleteContact();
    }
}
