package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddNewContact extends TestBase {

  @Test()
  public void testAddNewContact() throws Exception {
    app.goTo().homeContact();
    Contacts before = app.contact().all();
    app.goTo().goToAddNew();
    ContactData contact = new ContactData().withName("nk").withLastname("emp").withTitle("qa").withCompany("AH").withMobilePhone("89857592332").withWorkPhone("123").withHomePhone("222").withEmail("nikolas797@mail.ru");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId()))));
//    app.exitLogout();


//    contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
//    before.add(contact);
//    Assert.assertEquals(before, after);
//    int max = 0;
//    for(ContactData c : after){
//      if(c.getId() > max) {
//        max = c.getId();
//      }
//    }
  }
}
