package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;

public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    gotoGroupPage();
    submitGroupCreation("new");
    submitGroupCreation("group_name");
    fillGroupForm(new GroupData("test2", "test3", "test4"));
    submitGroupCreation("submit");
    returnToGroupPage();
    gotoGroupPage();
  }

}