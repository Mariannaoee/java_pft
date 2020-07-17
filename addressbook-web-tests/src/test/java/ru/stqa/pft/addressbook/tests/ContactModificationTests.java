package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {

        // our contacts for working with
        ContactData firstContact = new ContactData("Marianna", "Estrina",
                "Holon", "0865567", "marianna@mail.ru", "test1");


        // go to contact page and create contact if not exist
        applicationManager.getNavigationHelper().returnToHomePage();
        if (!applicationManager.getContactHelper().isThereAContact()) {
            applicationManager.getContactHelper().createContact(firstContact, true);
        }
        // go to contact list and choose contact that is created to edit
        List<ContactData> before = applicationManager.getContactHelper().getContactList();
        applicationManager.getContactHelper().selectContact(before.size() -1 );
        applicationManager.getContactHelper().initContactModification();

        ContactData contactForModification = new ContactData(before.get(before.size()-1).getId(),"Marianna", "Estrina",
                "Holon", "0865567", "marianna@mail.ru", "test1");
        applicationManager.getContactHelper().fillContactForm(contactForModification,false);
        applicationManager.getContactHelper().submitContactModification();
        applicationManager.getNavigationHelper().returnToHomePage();

        // get the contact list and check if no contact is added
        List<ContactData> after = applicationManager.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() );

        // remove the last contact and add the contact after modification and check if still the number of contacts is same
        before.remove(before.size()-1);
        before.add(contactForModification);
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));





    }
}
