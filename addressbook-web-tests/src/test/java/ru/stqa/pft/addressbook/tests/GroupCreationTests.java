package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {

        applicationManager.goTo().groupPage();
        List<GroupData> before = applicationManager.group().list();
        GroupData group = new GroupData().withName("test2");
        applicationManager.group().createGroup(group);
        List<GroupData> after = applicationManager.group().list();
        Assert.assertEquals(after.size(), before.size() + 1);

        int max = 0;
        for (GroupData g : after)//variable g that runs in list after
            if (g.getId() > max) {
                max = g.getId();
            }

        group.setId(max);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
