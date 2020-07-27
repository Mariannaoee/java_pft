package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        applicationManager.goTo().groupPage();
        if (applicationManager.group().all().size()==0) {
            applicationManager.group().createGroup(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModification() {

        // go to group list and choose group that is created to edit
        Set<GroupData> before = applicationManager.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData groupForModification = new GroupData()
                .withId(modifiedGroup.getId()).withName( "test1").withHeader("test2").withFooter("test3");
        applicationManager.group().modifyGroup( groupForModification);

        // get the group list and check if no group is added
        Set<GroupData> after = applicationManager.group().all();
        Assert.assertEquals(after.size(), before.size());

        // remove the last group and add the group after modification and check if still the number of groups is same
        before.remove(modifiedGroup);
        before.add(groupForModification);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }


}