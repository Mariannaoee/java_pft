package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
        Groups before = applicationManager.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData groupForModification = new GroupData()
                .withId(modifiedGroup.getId()).withName( "test1").withHeader("test2").withFooter("test3");
        applicationManager.group().modifyGroup( groupForModification);

        // get the group list and check if no group is added
        assertThat(applicationManager.group().count(), equalTo (before.size() ));
        Groups after = applicationManager.group().all();
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(groupForModification)));
    }


}