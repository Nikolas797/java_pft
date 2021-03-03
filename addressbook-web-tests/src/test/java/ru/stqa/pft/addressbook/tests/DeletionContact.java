package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class DeletionContact extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withName("nk").withLastname("emp").withTitle("qa").withAddress("Москва Ленина 5-2").withCompany("AH").withMobilePhone("8-985-759-2332").withWorkPhone("123").withHomePhone("222").withEmail("nikolas797@mail.ru").withEmail2("q@ah.com").withEmail3("nk@ah.com"));
    }
  }


  @Test()
  public void testDeletionContact() throws Exception {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(deletedContact)));

//    app.exitLogout();
  }
}
