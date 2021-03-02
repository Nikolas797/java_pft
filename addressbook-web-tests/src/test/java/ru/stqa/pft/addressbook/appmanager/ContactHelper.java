package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

    private int index;

    public ContactHelper(WebDriver wd){
        super(wd);
    }

    public void returnToContactPage() {
        click(By.linkText("home"));
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillNewContact(ContactData contactData) {
        typeb(By.name("firstname"), contactData.getName());
        typeb(By.name("lastname"), contactData.getLastname());
        typeb(By.name("title"), contactData.getTitle());
        typeb(By.name("company"), contactData.getCompany());
    }

    public void click1(By locator1) { wd.findElement(locator1).click(); }

    private void typeb(By locator1, String text1) {
//        wd.findElement(locator1).click();
//        wd.findElement(locator1).clear();
//        wd.findElement(locator1).sendKeys(text1);
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

//    public void selectContact(int index) {wd.findElements(By.xpath("(//input[@name='selected[]'])")).get(index).click();}

    private void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
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

    public void submitContactModification() {
        click(By.xpath("(//input[@name='update'])"));
    }

    public boolean isAcceptNextAlert() {
        return acceptNextAlert;
    }

    public void setAcceptNextAlert(boolean acceptNextAlert) {
        this.acceptNextAlert = acceptNextAlert;
    }

    public void create(ContactData contact) {
        fillNewContact(contact);
        submitContactCreation();
        contactCache = null;
        returnToContactPage();
    }

//    public void modify(int index, ContactData contact) {
//        initContactModification(index);
//        fillNewContact(contact);
//        submitContactModification();
//        returnToContactPage();
//    }

    public void modify(ContactData contact) {
        initContactModificationById(contact.getId());
        fillNewContact(contact);
        submitContactModification();
        contactCache = null;
        returnToContactPage();
    }

//    public void delete(int index) {
//        selectContact(index);
//        deleteContact();
//        submitDeleteContact();
//        returnToContactPage();
//    }

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

    public int count() {
        return wd.findElements(By.xpath("(//input[@name='selected[]'])")).size();
    }

    private Contacts contactCache = null;

    public Contacts list() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();

        List<WebElement> elements = wd.findElements((By.xpath("//*[@name=\"entry\"]")));
        for (WebElement element : elements) {
            String lastname = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
            String name = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
            int id = Integer.parseInt(element.findElement(By.cssSelector("td:nth-child(1) input")).getAttribute("value"));
            contactCache.add(new ContactData().withId(id).withName(name).withLastname(lastname));
        }
        return new Contacts(contactCache);
    }
}




