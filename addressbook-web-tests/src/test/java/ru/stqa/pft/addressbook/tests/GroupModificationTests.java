package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupModification() {

        // our groups for working with
        GroupData firstGroup = new GroupData("test1", null, null);


        // go to group page and create group if not exist
        applicationManager.getNavigationHelper().gotoGroupPage();
        if (!applicationManager.getGroupHelper().isThereAGroup()){
            applicationManager.getGroupHelper().createGroup(firstGroup);
        }
        // go to group list and choose group that is created to edit
        List<GroupData> before = applicationManager.getGroupHelper().getGroupList();
        applicationManager.getGroupHelper().selectGroup(before.size() -1);
        applicationManager.getGroupHelper().initGroupModification();
        // groups for modification
        GroupData groupForModification = new GroupData(before.get(before.size()-1).getId(),"test1", "test2", "test3");
        applicationManager.getGroupHelper().fillGroupForm(groupForModification);
        applicationManager.getGroupHelper().submitGroupModification();
        applicationManager.getGroupHelper().returnToGroupPage();

        // get the group list and check if no group is added
        List<GroupData> after = applicationManager.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        // remove the last group and add the group after modification and check if still the number of groups is same
        before.remove(before.size()-1);
        before.add(groupForModification);
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
    }
}
