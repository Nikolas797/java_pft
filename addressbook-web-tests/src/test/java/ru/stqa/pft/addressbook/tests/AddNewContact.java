package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class AddNewContact extends TestBase {

  @Test
  public void testAddNewContact() throws Exception {
    app.getNavigationHelper().goToHomeContact();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().goToAddNew();
    app.getContactHelper().createContact(new ContactData("nk", "emp", "qa", "AH"));
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
    app.exitLogout();
  }
}
