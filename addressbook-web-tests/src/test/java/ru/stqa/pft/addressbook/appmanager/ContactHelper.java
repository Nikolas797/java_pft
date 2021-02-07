package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.NewContactData;

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

    public void fillNewContact(NewContactData newContactData) {
        typeb(By.name("firstname"), newContactData.getName());
        typeb(By.name("lastname"), newContactData.getLastname());
        typeb(By.name("title"), newContactData.getTitle());
        typeb(By.name("company"), newContactData.getCompany());
    }

    private void typeb(By locator1, String text1) {
        wd.findElement(locator1).click();
        wd.findElement(locator1).clear();
        wd.findElement(locator1).sendKeys(text1);
    }

}
