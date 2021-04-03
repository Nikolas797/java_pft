package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
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
            app.group().create(new GroupData().withName("test 0"));
            app.goTo().homePage();
        }

        if (app.db().contactWithoutGroups().size() == 0) {
            app.goTo().homePage();
            app.contact().create(new ContactData().withName("nk").withLastname("emp"), true);
        }
        if (app.db().contactWithGroups().size() == 0) {
            ContactData before = app.db().contactWithoutGroup();
            Groups groups = app.db().groups();
            GroupData group = groups.iterator().next();
            app.goTo().homePage();
            app.contact().selectContactWithoutGroup(before);
            app.contact().selectGroup(group);
            app.contact().pushButtonAddToGroup();
        }
    }

    @Test
    public void testDeleteContactFromTheGroup() {
        ContactData before = app.db().contactWithGroup();
        GroupData group = before.getGroups().iterator().next();
        app.goTo().homePage();
        app.contact().groupName(group);
        app.contact().selectContact(before);
        app.contact().removeContactFromGroup();
        ContactData after = app.db().contactById(before.getId());
        assertTrue(after.getGroups().contains(group));
        verifyContactListInUI();
    }
}
