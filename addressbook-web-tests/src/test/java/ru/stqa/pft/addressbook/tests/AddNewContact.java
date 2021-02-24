package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.HashSet;
import java.util.List;

public class AddNewContact extends TestBase {

  @Test
  public void testAddNewContact() throws Exception {
    app.getNavigationHelper().goToHomeContact();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().goToAddNew();
    ContactData contact = new ContactData("QQQ", "emp", "qa", "AH");
    app.getContactHelper().createContact(contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

//    int max = 0;
//    for(ContactData c : after){
//      if(c.getId() > max) {
//        max = c.getId();
//      }
//    }

    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));


    app.exitLogout();
  }
}
