package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.testng.Assert.assertTrue;

public class DeleteContactFromGroup extends TestBase {

    @BeforeMethod
    public void ensurePreconditionsSorted() {
        app.goTo().homePage();
        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactData().withName("nk").withLastname("emp"), true);
            app.goTo().homePage();
        }

        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test0"));
            app.goTo().homePage();
        }
    }

    @Test
    public void testDeleteContactFromTheGroup() {
        app.goTo().homePage();
        ContactData contactData = app.db().contactInGroup();
        GroupData groupData = contactData.getGroups().iterator().next();
        app.contact().getGroupData(groupData);
        app.contact().selectContactNotInGroup(contactData);
        app.contact().pushButtonRemoveFromGroup();
        app.goTo().homePage();
        ContactData contactData1 = app.db().contactById(contactData.getId());
        assertTrue(contactData1.getGroups().contains(groupData));
    }
}
