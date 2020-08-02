package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {

        applicationManager.goTo().groupPage();
        Groups before = applicationManager.group().all();
        GroupData group = new GroupData().withName("test2");
        applicationManager.group().createGroup(group);
        assertThat(applicationManager.group().count(), equalTo (before.size() + 1));
        Groups after = applicationManager.group().all();
        assertThat(after, equalTo(before.withAdded
                (group.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt()))));

    }
    public void testBadGroupCreation() {

        applicationManager.goTo().groupPage();
        Groups before = applicationManager.group().all();
        GroupData group = new GroupData().withName("test2'");
        applicationManager.group().createGroup(group);
        assertThat(applicationManager.group().count(), equalTo (before.size() ));
        Groups after = applicationManager.group().all();
        assertThat(after, equalTo(before));

    }
}
