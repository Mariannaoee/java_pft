package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {
    private WebDriver wd;
    @BeforeMethod
    public void ensurePreconditions() {
        applicationManager.getNavigationHelper().gotoGroupPage();
        if (!applicationManager.getGroupHelper().isThereAGroup()) {
            applicationManager.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
    }

    @Test
    public void testGroupDeletion() throws Exception {


        List<GroupData> before = applicationManager.getGroupHelper().getGroupList();
        applicationManager.getGroupHelper().deleteGroup(before);
        List<GroupData> after = applicationManager.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        Assert.assertEquals(before,after);
    }


}