package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() throws Exception {
        app.getNavigationHelper().goToHomeContact();
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().submitContactModification();
//    app.getContactHelper().deleteContact();
//    submitDeleteContact();

    }
}
