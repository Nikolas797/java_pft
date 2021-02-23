package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;


public class DeletionContact extends TestBase{


  @Test
  public void testDeletionContact() throws Exception {
    app.getNavigationHelper().goToHomePage();
    int before = app.getContactHelper().getContactCount();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new NewContactData("nk", "emp", "qa", "AH"));
    }
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().deleteContact();
    app.getContactHelper().submitDeleteContact();
    app.getNavigationHelper().goToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);
//    app.exitLogout();
  }
}
