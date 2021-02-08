package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;


public class DeletionContact extends TestBase{

    @Test
  public void testDeletionContact() throws Exception {
    app.getNavigationHelper().goToHomeContact();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
//    submitDeleteContact();
    app.exitLogout();
  }
//
//    private void submitDeleteContact() {
//        assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
//    }

}
