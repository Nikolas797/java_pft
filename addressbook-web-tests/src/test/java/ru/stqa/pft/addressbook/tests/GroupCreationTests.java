package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {


  @DataProvider
  public Iterator<Object[]> validGroups() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new GroupData().withName("test1").withHeader("header1").withFooter("footer1")});
    list.add(new Object[] {new GroupData().withName("test2").withHeader("header2").withFooter("footer2")});
    list.add(new Object[] {new GroupData().withName("test3").withHeader("header3").withFooter("footer3")});
    return list.iterator();
  }

  @Test(dataProvider = "validGroups")
  public void testGroupCreation56(GroupData group) {
    app.goTo().groupPage();
    Groups before = (Groups) app.group().all();
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size() + 1));
    Groups after = app.group().all();
    assertThat(after, equalTo(before.withAdded(group.withId(after.stream().
            mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

//    app.exitLogout();

//    int max = 0;
//    for(GroupData g : after){
//      if(g.getId() > max ) {
//        max = g.getId();
//      }
//    }
//    int max1 = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
//    group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());

  @Test
  public void testBadGroupCreation() throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test'");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();

    assertThat(after, equalTo(before));
  }
}
