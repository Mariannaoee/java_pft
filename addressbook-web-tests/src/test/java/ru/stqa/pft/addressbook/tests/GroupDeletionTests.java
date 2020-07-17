package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {
    private WebDriver wd;


    @Test
    public void testGroupDeletion() throws Exception {
        applicationManager.getNavigationHelper().gotoGroupPage();

        if (!applicationManager.getGroupHelper().isThereAGroup()) {
            applicationManager.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }

        List<GroupData> before = applicationManager.getGroupHelper().getGroupList();
        applicationManager.getGroupHelper().selectGroup(before.size() - 1);
        applicationManager.getGroupHelper().deleteSelectedGroups();
        applicationManager.getGroupHelper().returnToGroupPage();
        List<GroupData> after = applicationManager.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        Assert.assertEquals(before,after);
    }
}