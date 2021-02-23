package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.NewContactData;

public class AddNewContact extends TestBase {

  @Test
  public void testAddNewContact() throws Exception {
    app.getNavigationHelper().goToHomeContact();
    int before = app.getContactHelper().getContactCount();
    app.getNavigationHelper().goToAddNew();
    app.getContactHelper().createContact(new NewContactData("nk", "emp", "qa", "AH"));
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);
//    app.exitLogout();
  }
}
