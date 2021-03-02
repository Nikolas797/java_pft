package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactPhoneTests extends TestBase {


    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData().withName("nk").withLastname("emp").withTitle("qa").withCompany("AH").withMobilePhone("8-985-759-2332").withWorkPhone("123").withHomePhone("222").withEmail("nikolas797@mail.ru"));
        }
    }


    @Test
    public void testContactPhones(){
        app.goTo().homeContact();
        ContactData contact = app.contact().list().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    }
}
