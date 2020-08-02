package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {
    private WebDriver wd;
    @BeforeMethod
    public void ensurePreconditions() {
        applicationManager.goTo().groupPage();
        if (applicationManager.group().all().size()==0) {
            applicationManager.group().createGroup(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupDeletion() throws Exception {

        Groups before = applicationManager.group().all();
        GroupData deletedGroup = before.iterator().next();
        applicationManager.group().deleteGroup(deletedGroup);
        assertThat(applicationManager.group().count(), equalTo (before.size() - 1));
        Groups after = applicationManager.group().all();
        assertThat(after, equalTo(before.without(deletedGroup)));

    }


}