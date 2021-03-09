package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddNewContact extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() {
    List<Object[]> list = new ArrayList<Object[]>();
//    File photo = new File("src/test/resources/stru.png");
//    list.add(new Object[]{"nk1", "emp1", "MSC1"});
//    list.add(new Object[]{"nk2", "emp2", "MSC2"});
//    list.add(new Object[]{"nk3", "emp3", "MSC3"});
    list.add(new Object[]{ new ContactData().withName("nk").withLastname("emp").withTitle("qa").withAddress("Москва Ленина 5-2").withCompany("AH").withMobilePhone("89857592332").withWorkPhone("123").withHomePhone("222").withEmail("nikolas797@mail.ru").withEmail2("q@ah.com").withEmail3("nk@ah.com")});
    list.add(new Object[]{ new ContactData().withName("AD").withLastname("ad").withTitle("qa").withAddress("Москва Ленина 5-2").withCompany("AH").withMobilePhone("89857592332").withWorkPhone("123").withHomePhone("222").withEmail("nikolas797@mail.ru").withEmail2("q@ah.com").withEmail3("nk@ah.com")});
    list.add(new Object[]{ new ContactData().withName("TS").withLastname("hm").withTitle("qa").withAddress("Москва Ленина 5-2").withCompany("AH").withMobilePhone("89857592332").withWorkPhone("123").withHomePhone("222").withEmail("nikolas797@mail.ru").withEmail2("q@ah.com").withEmail3("nk@ah.com")});
    return list.iterator();
  }

  @Test (dataProvider = "validContacts")
  public void testAddNewContact(ContactData contact) throws Exception {
    app.goTo().homeContact();
    Contacts before = app.contact().all();
//    File photo = new File("src/test/resources/stru.png");
    app.contact().create(contact);
    app.goTo().homeContact();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId()))));
//    app.exitLogout();
  }

  @Test
  public void testAddNewContact() throws Exception {
    app.goTo().homeContact();
    Contacts before = app.contact().all();
    app.goTo().goToAddNew();
    File photo = new File("src/test/resources/stru.png");
    ContactData contact = new ContactData().withName("nk").withLastname("emp").withPhoto(photo).withTitle("qa").withAddress("Москва Ленина 5-2").withCompany("AH").withMobilePhone("89857592332").withWorkPhone("123").withHomePhone("222").withEmail("nikolas797@mail.ru").withEmail2("q@ah.com").withEmail3("nk@ah.com");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId()))));
  }

  @Test
  public void testCurrentDir() throws Exception {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/stru.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
}
