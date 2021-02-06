package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase{

  @Test
  public void testGroupDeletion() throws Exception {
    gotoGroupPage("groups");
    selectGroup("selected[]");
    deleteSelectedGroups("delete");
    returnToGroupPage("group page");
  }

}
