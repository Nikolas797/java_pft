package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;


public class DeletionContact extends TestBase{


  @Test
  public void testDeletionContact() throws Exception {
    app.getNavigationHelper().goToHomeContact();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new NewContactData("nk", "emp", "qa", "AH"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().submitDeleteContact();
    app.exitLogout();
  }
}
