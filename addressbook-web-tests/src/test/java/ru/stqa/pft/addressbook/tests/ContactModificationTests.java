package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {
    int num  = 0;
    @BeforeMethod
    public  void ensurePreconditions(){
        num = num + 1 ;
        System.out.println("enter to ensurePreconditions : " + num);
        applicationManager.goTo().homePage();

        if (applicationManager.contact().list().size()==0) {
            applicationManager.contact().createContact(new ContactData("Marianna", "Estrina"), true);
        }
    }

    @Test
    public void testContactModification() {

        // go to contact list and choose contact that is created to edit
//        applicationManager.contact().initContactModification();
        List<ContactData> before = applicationManager.contact().list();
        int index = before.size() - 1;
        ContactData contactForModification = new ContactData(before.get(index).getId(), "Marianna", "Estrina");
        applicationManager.contact().modifyContact(contactForModification, index);

        // get the contact list and check if no contact is added
        List<ContactData> after = applicationManager.contact().list();
        Assert.assertEquals(after.size(), before.size());

        // remove the last contact and add the contact after modification and check if still the number of contacts is same
        before.remove(index);
        before.add(contactForModification);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));


    }


}