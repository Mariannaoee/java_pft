package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {

        applicationManager.getNavigationHelper().gotoGroupPage();
        List<GroupData> before = applicationManager.getGroupHelper().getGroupList();
        GroupData group = new GroupData("test1", null, null);
        applicationManager.getGroupHelper().createGroup(group);
        List<GroupData> after = applicationManager.getGroupHelper().getGroupList();
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


