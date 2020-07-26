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
        applicationManager.goTo().groupPage();
        if (applicationManager.group().list().size()==0) {
            applicationManager.group().createGroup(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupDeletion() throws Exception {


        List<GroupData> before = applicationManager.group().list();
        applicationManager.group().deleteGroup(before);
        List<GroupData> after = applicationManager.group().list();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        Assert.assertEquals(before,after);
    }


}