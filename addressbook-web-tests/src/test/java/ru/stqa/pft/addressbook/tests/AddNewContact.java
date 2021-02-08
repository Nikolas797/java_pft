package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.NewContactData;

public class AddNewContact extends TestBase {

  @Test
  public void testAddNewContact() throws Exception {
    app.getNavigationHelper().goToAddNew();
    app.getContactHelper().fillNewContact(new NewContactData("nk", "emp", "qa", "Q"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToContactPage();

  }



}
