package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withName("nk").withLastname("emp").withTitle("qa").withCompany("AH").withMobilePhone("8-985-759-2332").withWorkPhone("123").withHomePhone("222").withEmail("nikolas797@mail.ru"));
        }
    }

    @Test()
    public void testContactModification() throws Exception {
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withName("nk").withLastname("emp").withTitle("qa").withCompany("AH").withMobilePhone("8-985-759-2332").withWorkPhone("123").withHomePhone("222").withEmail("nikolas797@mail.ru");
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));





//        Assert.assertEquals(after.size(), before.size());
//        before.remove(index);
//        before.add(contact);
//        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
//        before.sort(byId);
//        after.sort(byId);

//        app.exitLogout();
//    app.getContactHelper().deleteContact();
//    submitDeleteContact();
    }
}
