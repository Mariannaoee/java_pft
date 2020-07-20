package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public  void ensurePreconditions(){
        applicationManager.getNavigationHelper().returnToHomePage();
        if (!applicationManager.getContactHelper().isThereAContact()) {
            applicationManager.getContactHelper().createContact(new ContactData("Marianna", "Estrina",
                    null, null, null, null), true);
        }
    }

    @Test
    public void testContactModification() {

        // go to contact list and choose contact that is created to edit
        applicationManager.getContactHelper().initContactModification();
        List<ContactData> before = applicationManager.getContactHelper().getContactList();
        int index = before.size() - 1;
        ContactData contactForModification = new ContactData(before.get(index).getId(), "Marianna", "Estrina");


        applicationManager.getContactHelper().modifyContact(contactForModification, index);

        // get the contact list and check if no contact is added
        List<ContactData> after = applicationManager.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        // remove the last contact and add the contact after modification and check if still the number of contacts is same
        before.remove(index);
        before.add(contactForModification);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));


    }


}