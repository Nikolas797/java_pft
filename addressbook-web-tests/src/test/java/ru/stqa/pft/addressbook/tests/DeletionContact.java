package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.*;


public class DeletionContact extends TestBase{

    @Test
  public void testDeletionContact() throws Exception {
    app.getNavigationHelper().goToHomeContact();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().submitDeleteContact();
  }

//
//    private void submitDeleteContact() {
//        assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
//    }

}
