package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.NewContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() throws Exception {
        app.getNavigationHelper().goToHomeContact();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new NewContactData("nk", "emp", "qa", "AH"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().submitContactModification();
//    app.getContactHelper().deleteContact();
//    submitDeleteContact();

    }
}
