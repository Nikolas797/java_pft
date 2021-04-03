package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactHelper extends HelperBase {

    private int index;

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToContactPage() {
        click(By.linkText("home"));
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillNewContact(ContactData contactData, boolean creation) {
        typeb(By.name("firstname"), contactData.getName());
        typeb(By.name("lastname"), contactData.getLastname());
        typeb(By.name("title"), contactData.getTitle());
        typeb(By.name("address"), contactData.getAddress());
        typeb(By.name("company"), contactData.getCompany());
        typeb(By.name("home"), contactData.getHomePhone());
        typeb(By.name("mobile"), contactData.getMobilePhone());
        typeb(By.name("work"), contactData.getWorkPhone());
        typeb(By.name("email"), contactData.getEmail());
        typeb(By.name("email2"), contactData.getEmail2());
        typeb(By.name("email3"), contactData.getEmail3());
//        attach(By.name("photo"), contactData.getPhoto());

//        if (creation) {
//            if (contactData.getGroups().size() > 0) {
//                Assert.assertTrue(contactData.getGroups().size() == 1);
//                new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
//            }
//        } else {
//            Assert.assertFalse(isElementPresent(By.name("new_group")));
//        }
    }

    public void click1(By locator1) {
        wd.findElement(locator1).click();
    }

    private void typeb(By locator1, String text1) {
        click1(locator1);
        if (text1 != null) {
            String existingText = wd.findElement(locator1).getAttribute("value");
            if (!text1.equals(existingText)) {
                wd.findElement(locator1).click();
                wd.findElement(locator1).clear();
                wd.findElement(locator1).sendKeys(text1);
            }
        }
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    private boolean acceptNextAlert = true;

    public void submitDeleteContact() {
        wd.switchTo().alert().accept();
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("tr[name='entry'] input[value ='" + id + "']")).click();
    }

    private void initContactModificationById(int id) {
//        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
//        WebElement checkbox = wd.findElement(By.cssSelector(String.format("//input[@value='%s]", id)));
//        WebElement row = checkbox.findElement(By.xpath("./../.."));
//        List<WebElement> cells = row.findElement(By.tagName("td"));
//        cells.get(7).findElement(By.tagName("a")).click();
//        wd.findElement(By.xpath(String.format("//input[@value='%s']/td[8]/a", id))).click();
        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void submitContactModification() {
        click(By.xpath("(//input[@name='update'])"));
    }

    public boolean isAcceptNextAlert() {
        return acceptNextAlert;
    }

    public void setAcceptNextAlert(boolean acceptNextAlert) {
        this.acceptNextAlert = acceptNextAlert;
    }

    public void create(ContactData contact, boolean creation ) {
        fillNewContact(contact, true);
        submitContactCreation();
        contactCache = null;
        returnToContactPage();
    }

    public void modify(ContactData contact) {
        initContactModificationById(contact.getId());
        fillNewContact(contact, true);
        submitContactModification();
        contactCache = null;
        returnToContactPage();
    }

    public void modifyById(ContactData contact) {
        initContactModificationById(contact.getId());
        fillNewContact(contact, true);
        submitContactModification();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteContact();
        submitDeleteContact();
        contactCache = null;
        returnToContactPage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("(//input[@name='selected[]'])"));
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
            String lastname = cells.get(1).getText();
            String name = cells.get(2).getText();
            String address = cells.get(3).getText();
            String allEmails = cells.get(4).getText();
            String allPhones = cells.get(5).getText();
            contactCache.add(new ContactData().withId(id).withName(name).withLastname(lastname)
                    .withAddress(address).withAllEmails(allEmails).withAllPhones(allPhones));
        }
        return new Contacts(contactCache);
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String name = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withName(name).withLastname(lastname).withAddress(address)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withEmail(email).withEmail2(email2).withEmail3(email3);
    }

    public int count() {
        return wd.findElements(By.name("entry")).size();
    }

    public void selectContactNotInGroup(ContactData contact) {
        wd.findElement(By.xpath(String.format("//input[@type='checkbox']", contact.getId()))).click();
    }

    public void groupName(GroupData group) {
        click(By.xpath(String.format("//select[@name='group']/option[text() = '%s']", group.getName())));
    }

    public void selectGroup(GroupData group) {
        wd.findElement(By.xpath(String.format("//select[@name='to_group']/option[@value='%s']", group.getId()))).click();
    }

    public void pushButtonAddToGroup() {
        wd.findElement(By.xpath("//input[@name='add']")).click();
    }

    public void getGroupData(GroupData groupData) {
        WebElement element = wd.findElement(By.xpath(String.format("//select[@name='group']/option[text() = '%s']", groupData.getName())));
        element.click();
    }

    public void pushButtonRemoveFromGroup() {
        wd.findElement(By.xpath("//input[@name='remove']")).click();
    }

    public void selectContactWithoutGroup(ContactData contact) {
        new Select(wd.findElement(By.name("group"))).selectByVisibleText("[none]");
        click(By.xpath(String.format("//input[@type='checkbox']", contact.getId())));
    }

    public void selectContact(ContactData contact) {
        click(By.xpath(String.format("//input[@type='checkbox']", contact.getId())));
    }

    public void gotoHomePage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home"));
    }

    public void removeContactFromGroup() {
        wd.findElement(By.name("selected[]")).click();
        click(By.name("remove"));
        contactCache = null;
        gotoHomePage();
    }
}




