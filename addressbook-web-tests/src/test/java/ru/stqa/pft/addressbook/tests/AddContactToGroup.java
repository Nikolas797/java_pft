package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroup extends TestBase{

    @BeforeClass
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("name").withHeader("header").withFooter("footer"));
        }
    }

    @Test
    public void addContactToGroupFromContact(){
        Contacts contacts = app.db().contacts();
        app.contact().selectContactById(contacts.iterator().next().getId());
        app.contact().selectGroup(contacts);
        app.contact().addContactToGroup();
        Contacts contactsafter = app.db().contacts();
        assertThat(contacts.iterator().next(), equalTo(contactsafter.iterator().next()));
    }

}
