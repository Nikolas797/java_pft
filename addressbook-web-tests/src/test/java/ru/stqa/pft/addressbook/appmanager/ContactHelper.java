package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd){
        super(wd);
    }

    public void returnToContactPage() {
        click(By.linkText("home page"));
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

    public void selectContact(int index) {
        wd.findElements(By.xpath("(//input[@name='selected[]'])")).get(index).click();
//        click(By.xpath("(//input[@name='selected[]'])"));
    }

    public void initContactModification() {
        if(isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")) {
            return;
        }
        click(By.xpath("(//img[@alt='Edit'])"));
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

    public void createContact(ContactData contact) {
        fillNewContact(contact);
        submitContactCreation();
        returnToContactPage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("(//input[@name='selected[]'])"));
    }

    public int getContactCount() {
        return wd.findElements(By.xpath("(//input[@name='selected[]'])")).size();
    }
}


