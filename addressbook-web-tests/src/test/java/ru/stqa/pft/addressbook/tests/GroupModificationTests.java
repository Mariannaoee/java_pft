package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        applicationManager.getNavigationHelper().gotoGroupPage();
        if (!applicationManager.getGroupHelper().isThereAGroup()) {
            applicationManager.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
    }

    @Test
    public void testGroupModification() {

        // go to group list and choose group that is created to edit
        List<GroupData> before = applicationManager.getGroupHelper().getGroupList();
        int index = before.size() - 1;
        GroupData groupForModification = new GroupData(before.get(index).getId(), "test1", "test2", "test3");
        applicationManager.getGroupHelper().modifyGroup(index, groupForModification);

        // get the group list and check if no group is added
        List<GroupData> after = applicationManager.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        // remove the last group and add the group after modification and check if still the number of groups is same
        before.remove(index);
        before.add(groupForModification);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }


}
